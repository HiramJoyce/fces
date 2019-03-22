package com.fces.controller;

import com.fces.domain.Teacher;
import com.fces.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;

	@RequestMapping("/login")
	public String teacherLogin() {
		return "teacher/login";
	}

	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String teacherLogin(String teacherNUm, String password, HttpServletRequest request) {
		System.out.println("teacher login -> teacherNUm : " + teacherNUm + " password : " + password);
		Teacher teacher = teacherService.login(teacherNUm, password);
		if (teacher != null) {
			request.getSession().setAttribute("id", teacher.getId());
			request.getSession().setAttribute("realName", teacher.getRealName());
			request.getSession().setAttribute("role", "teacher");
			System.out.println("teacher login success!");
			return "teacher/teacherPage";
		}
		System.out.println("admin login error!");
		return "teacher/login";
	}
}
