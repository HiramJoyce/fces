package com.fces.controller;

import com.fces.domain.Clazz;
import com.fces.domain.Result;
import com.fces.domain.Student;
import com.fces.domain.dto.ScoreStudent;
import com.fces.domain.dto.ScoreTeacher;
import com.fces.service.ClazzService;
import com.fces.service.StudentService;
import com.fces.util.ModelUtil;
import com.fces.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private ClazzService clazzService;

    @RequestMapping("/login")
    public String studentLogin() {
        return "student/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String studentLogin(String studentNum, String password, HttpServletRequest request) {
        System.out.println("student login -> studentNum : " + studentNum + " password : " + password);
        Student student = studentService.login(studentNum, password);
        if (student != null) {
            request.getSession().setAttribute("id", student.getId());
            request.getSession().setAttribute("realName", student.getRealName());
            request.getSession().setAttribute("role", "student");
            System.out.println("student login success!");
            return "redirect:/student/class";
        }
        System.out.println("admin login error!");
        return "student/login";
    }

    @RequestMapping("/class")
    public String classManage(HttpSession session, Model model) {
        System.out.println("-> teacher -> class");
        ModelUtil.setModelValue(session, model);
        List<Clazz> clazzList = clazzService.getClazzByStudentId((String) session.getAttribute("id"));
        model.addAttribute("classes", clazzList);
        return "student/classManage";
    }

    @RequestMapping("/class/info")
    public String classInfo(String id, HttpSession session, Model model) {
        System.out.println("-> student -> class -> info -> " + id);
        String studentId = (String) session.getAttribute("id");
        if (studentId == null) {
            session.setAttribute("error", "请先登录！");
            return "redirect:/student/class";
        }
        ModelUtil.setModelValue(session, model);
        Clazz clazz = clazzService.getClazzById(id);
        model.addAttribute("clazz", clazz);
        List<ScoreStudent> students = studentService.getStudentsByClazzId2(id);
        System.out.println(students);
        List<ScoreStudent> scoredStudents = studentService.getScoredStudentsByClazzId(studentId, id);
        System.out.println(scoredStudents);
        for (ScoreStudent student : students) {
            for (ScoreStudent scoredStudent : scoredStudents) {
                if (student.getToStudentId().equals(scoredStudent.getToStudentId())) {
                    student.setScore(scoredStudent.getScore());
                }
            }
        }
        System.out.println(students);
        model.addAttribute("students", students);
        return "student/classInfo";
    }

    @RequestMapping("/student/score")
    public String studentScore(String studentId, String clazzId, Model model) {
        System.out.println("-> student -> student -> score");
        Student student = studentService.getStudentById(studentId);
        Clazz clazz = clazzService.getClazzById(clazzId);
        model.addAttribute("student", student);
        model.addAttribute("clazz", clazz);
        return "student/studentScore";
    }

    @RequestMapping(value = "/student/score", method=RequestMethod.POST)
    public String studentUpdate(String studentId, String clazzId, String score, HttpSession session) {
        if (session.getAttribute("id") == null || session.getAttribute("id").equals("")) {
            session.setAttribute("error", "尚未登录！");
            return "redirect:/student/class";
        }
        System.out.println("student student score " + studentId + " " + clazzId);
        if (studentService.getStudentScore((String) session.getAttribute("id"), studentId, clazzId) == null) {
            if (studentService.addStudentScore((String) session.getAttribute("id"), studentId, clazzId, score) > 0) {
                session.setAttribute("message", "评分成功！");
            } else {
                session.setAttribute("error", "评分失败！");
            }
        } else {
            session.setAttribute("error", "重复评分！");
        }
        return "redirect:/student/class/info?id=" + clazzId;
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Result uploadQuestions(@RequestParam(value = "excelFile") MultipartFile excelFile, Model model,
                                  HttpSession session) {
//		if (request.getSession().getAttribute("role") == null || !request.getSession().getAttribute("role").equals("admin")) {
//			return "404";
//		}
        System.out.println("-> upload start");
        if (excelFile == null) {
            session.setAttribute("error", "文件不正确！");
            return ResultUtil.error("文件不正确！");
        }
        String name = excelFile.getOriginalFilename();
        long size = excelFile.getSize();
        if (name == null || ("").equals(name) && size == 0) {
            session.setAttribute("error", "文件不正确！");
            return ResultUtil.error("文件不正确！");
        }

        String extension = name.substring(name.lastIndexOf(".") + 1).toLowerCase();
        if (!Objects.equals("xls", extension) && !Objects.equals("xlsx", extension)) {
            session.setAttribute("error", "文件不正确！");
            return ResultUtil.error("文件不正确！");
        }
        List<Student> studentList = studentService.batchImport(excelFile);
        System.out.println(studentList);
		if (studentList != null) {
			studentList.forEach((student) -> studentService.createStudent(student));
		}
        return ResultUtil.success(studentList);
    }
}
