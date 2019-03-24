package com.fces.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alibaba.druid.util.StringUtils;
import com.fces.domain.Clazz;
import com.fces.domain.Student;
import com.fces.domain.Teacher;
import com.fces.service.ClazzService;
import com.fces.service.StudentService;
import com.fces.service.TeacherService;
import com.fces.util.ModelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fces.domain.Admin;
import com.fces.service.AdminService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
    @Autowired
    private ClazzService clazzService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;

	@RequestMapping("/login")
	public String adminLogin() {
		return "admin/login";
	}

    @RequestMapping(value = "/login", method=RequestMethod.POST)
    public String adminLogin(String userName, String password, HttpServletRequest request) {
        System.out.println("admin login -> userName : " + userName + " password : " + password);
        Admin admin = adminService.login(userName, password);
        if (admin != null) {
            request.getSession().setAttribute("id", admin.getId());
            request.getSession().setAttribute("realName", admin.getUserName());
            request.getSession().setAttribute("role", "admin");
            System.out.println("admin login success!");
            return "redirect:/admin/class";
        }
        System.out.println("admin login error!");
        return "admin/login";
    }

    @RequestMapping("/class")
    public String classManage(HttpSession session, Model model) {
        System.out.println("-> admin -> class");
        ModelUtil.setModelValue(session, model);
        List<Clazz> clazzList = clazzService.getAllClazz();
        model.addAttribute("classes", clazzList);
        return "admin/classManage";
    }

    @RequestMapping("/student")
    public String studentManage(HttpSession session, Model model) {
        System.out.println("-> admin -> student");
        ModelUtil.setModelValue(session, model);
        List<Student> studentList = studentService.getAllStudent();
        model.addAttribute("students", studentList);
        return "admin/studentManage";
    }

    @RequestMapping(value = "/class/update", method = RequestMethod.GET)
    public String classUpdate(String id, Model model) {
        System.out.println("-> admin -> class -> update " + id);
        Clazz clazz = clazzService.getClazzById(id);
        model.addAttribute("clazz", clazz);
        List<Teacher> teachers = teacherService.getAllTeacher();
        model.addAttribute("teachers", teachers);
        return "admin/classNewOrUpdate";
    }

    @RequestMapping(value = "/student/update", method = RequestMethod.GET)
    public String studentUpdate(String id, Model model) {
        System.out.println("-> admin -> student -> update " + id);
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "admin/studentNewOrUpdate";
    }

    @RequestMapping(value = "/class/update", method=RequestMethod.POST)
    public String classUpdate(Clazz clazz, HttpSession session) {
        System.out.println("admin class update clazz " + clazz.toString());
        if (clazz.getId()!= null && !StringUtils.equals(clazz.getId(), "")) {
            if (clazzService.updateClazz(clazz) != null) {
                session.setAttribute("message", "修改成功！");
            } else {
                session.setAttribute("error", "修改失败！");
            }
        } else {
            if (clazzService.createClazz(clazz) != null) {
                session.setAttribute("message", "添加成功！");
            } else {
                session.setAttribute("error", "添加失败！");
            }
        }
        return "redirect:/admin/class";
    }

    @RequestMapping(value = "/student/update", method=RequestMethod.POST)
    public String studentUpdate(Student student, HttpSession session) {
        System.out.println("admin student update student " + student.toString());
        if (student.getId()!= null && !StringUtils.equals(student.getId(), "")) {
            if (studentService.updateStudent(student) != null) {
                session.setAttribute("message", "修改成功！");
            } else {
                session.setAttribute("error", "修改失败！");
            }
        } else {
            if (studentService.createStudent(student) != null) {
                session.setAttribute("message", "添加成功！");
            } else {
                session.setAttribute("error", "添加失败！");
            }
        }
        return "redirect:/admin/student";
    }

    @RequestMapping(value = "/class/delete", method=RequestMethod.POST)
    public String classDelete(String classId, HttpSession session) {
        System.out.println("admin class delete " + classId);
        if (classId != null) {
            String ids[] = classId.split(",");
            for (String id1 : ids) {
                clazzService.deleteClazz(id1);
            }
            session.setAttribute("message", "删除成功！");
        }
        return "redirect:/admin/class";
    }

    @RequestMapping(value = "/student/delete", method=RequestMethod.POST)
    public String studentDelete(String studentId, HttpSession session) {
        System.out.println("admin student delete " + studentId);
        if (studentId != null) {
            String ids[] = studentId.split(",");
            for (String id1 : ids) {
                studentService.deleteStudent(id1);
            }
            session.setAttribute("message", "删除成功！");
        }
        return "redirect:/admin/student";
    }
}
