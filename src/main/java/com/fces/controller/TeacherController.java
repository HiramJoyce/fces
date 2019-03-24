package com.fces.controller;

import com.alibaba.druid.util.StringUtils;
import com.fces.domain.Clazz;
import com.fces.domain.Student;
import com.fces.domain.Teacher;
import com.fces.domain.dto.ScoreStudent;
import com.fces.domain.dto.ScoreTeacher;
import com.fces.service.ClazzService;
import com.fces.service.StudentService;
import com.fces.service.TeacherService;
import com.fces.util.ModelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
    @Autowired
    private ClazzService clazzService;
    @Autowired
    private StudentService studentService;

	@RequestMapping("/login")
	public String teacherLogin(Model model, HttpSession session) {
        ModelUtil.setModelValue(session, model);
		return "teacher/login";
	}

	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String teacherLogin(String teacherNum, String password, HttpSession session) {
		System.out.println("teacher login -> teacherNUm : " + teacherNum + " password : " + password);
		Teacher teacher = teacherService.login(teacherNum, password);
		if (teacher != null) {
            session.setAttribute("id", teacher.getId());
            session.setAttribute("realName", teacher.getRealName());
            session.setAttribute("role", "teacher");
            session.setAttribute("message", "登录成功！");
			System.out.println("teacher login success!");
            return "redirect:/teacher/class";
		}
        session.setAttribute("error", "登录失败，请检查教职工编号或密码！");
		System.out.println("admin login error!");
		return "redirect:/teacher/login";
	}

    @RequestMapping("/class")
    public String classManage(HttpSession session, Model model) {
        System.out.println("-> teacher -> class");
        ModelUtil.setModelValue(session, model);
        List<Clazz> clazzList = clazzService.getClazzesByTeacherId((String) session.getAttribute("id"));
        model.addAttribute("classes", clazzList);
        return "teacher/classManage";
    }

    @RequestMapping("/student")
    public String studentManage(HttpSession session, Model model) {
        System.out.println("-> teacher -> student");
        ModelUtil.setModelValue(session, model);
        List<Student> studentList = studentService.getAllStudent();
        model.addAttribute("students", studentList);
        return "teacher/studentManage";
    }

    @RequestMapping("/student/score")
    public String studentScore(String studentId, String clazzId, Model model) {
        System.out.println("-> teacher -> student -> score");
        Student student = studentService.getStudentById(studentId);
        Clazz clazz = clazzService.getClazzById(clazzId);
        model.addAttribute("student", student);
        model.addAttribute("clazz", clazz);
        return "teacher/studentScore";
    }

    @RequestMapping(value = "/student/score", method=RequestMethod.POST)
    public String studentUpdate(String studentId, String clazzId, String score, HttpSession session) {
	    if (session.getAttribute("id") == null || session.getAttribute("id").equals("")) {
            session.setAttribute("error", "尚未登录！");
            return "redirect:/teacher/class/info";
        }
        System.out.println("teacher student score " + studentId + " " + clazzId);
        if (studentService.getTeacherScore((String) session.getAttribute("id"), studentId, clazzId) == null) {
            if (studentService.addTeacherScore((String) session.getAttribute("id"), studentId, clazzId, score) > 0) {
                session.setAttribute("message", "评分成功！");
            } else {
                session.setAttribute("error", "评分失败！");
            }
        } else {
            session.setAttribute("error", "重复评分！");
        }
        return "redirect:/teacher/class/info?id=" + clazzId;
    }

    @RequestMapping("/class/info")
    public String classInfo(String id, HttpSession session, Model model) {
        System.out.println("-> teacher -> class -> info -> " + id);
        ModelUtil.setModelValue(session, model);
        Clazz clazz = clazzService.getClazzById(id);
        model.addAttribute("clazz", clazz);
        List<ScoreTeacher> students = studentService.getStudentsByClazzId(id);
        model.addAttribute("students", students);
        List<Student> allStudents = studentService.getAllStudent();
        model.addAttribute("allStudents", allStudents);
        // 平均分计算
        List<ScoreTeacher> scores = new ArrayList<>();
        ScoreTeacher score;
        for (ScoreTeacher scoreTeacher : students) {
            score = new ScoreTeacher();
            score.setStudentName(scoreTeacher.getStudentName());
            List<ScoreStudent> scoreStudents = studentService.getToStudentScore(scoreTeacher.getStudentId(), id);
            double totalStudentScore = 0;
            for (ScoreStudent scoreStudent : scoreStudents) {
                totalStudentScore += scoreStudent.getScore();
            }
            totalStudentScore = scoreStudents.size() > 0 ? totalStudentScore/scoreStudents.size() : 0;
            score.setScore(new BigDecimal(totalStudentScore*0.4 + scoreTeacher.getScore()*0.6).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
            scores.add(score);
        }
        scores.sort(Comparator.comparing(data -> ((ScoreTeacher) data).getScore()).thenComparing(data -> ((ScoreTeacher) data).getScore()).reversed());
        System.out.println(scores);
        model.addAttribute("scores", scores);
        return "teacher/classInfo";
    }

    @RequestMapping("/class/addStudent")
    public String classInfo(String studentId, String clazzId, HttpSession session) {
        System.out.println("-> teacher -> class -> addStudent " + studentId + " -> " + clazzId);
        if (studentId != null) {
            String ids[] = studentId.split(",");
            for (String id1 : ids) {
                if (studentService.isStudentInClazz(id1, clazzId) == null) {
                    studentService.addStudentToClazz(id1, clazzId);
                }
            }
            session.setAttribute("message", "添加成功！");
        }
        return "redirect:/teacher/class/info?id=" + clazzId;
    }

    @RequestMapping(value = "/student/update", method = RequestMethod.GET)
    public String studentUpdate(String id, Model model) {
        System.out.println("-> teacher -> student -> update " + id);
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "teacher/studentNewOrUpdate";
    }

    @RequestMapping(value = "/student/update", method=RequestMethod.POST)
    public String studentUpdate(Student student, HttpSession session) {
        System.out.println("teacher student update student " + student.toString());
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
        return "redirect:/teacher/student";
    }

    @RequestMapping(value = "/student/delete", method=RequestMethod.POST)
    public String studentUpdate(String studentId, String clazzId, HttpSession session) {
        System.out.println("-> teacher -> student -> delete " + studentId + " -> " + clazzId);
        if (studentId != null) {
            String ids[] = studentId.split(",");
            for (String id1 : ids) {
                studentService.removeStudentFromClazz(id1, clazzId);
            }
            session.setAttribute("message", "删除成功！");
        }
        return "redirect:/teacher/class/info?id=" + clazzId;
    }
}
