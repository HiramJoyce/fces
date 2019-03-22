package com.fces.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alibaba.druid.util.StringUtils;
import com.fces.domain.Clazz;
import com.fces.domain.Teacher;
import com.fces.service.ClazzService;
import com.fces.service.TeacherService;
import com.fces.util.ModelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fces.domain.Admin;
import com.fces.service.AdminService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;
import org.springframework.web.servlet.view.RedirectView;

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

	@RequestMapping("/login")
	public String adminLogin() {
		return "admin/login";
	}

    @RequestMapping("/class")
    public String classManage(HttpSession session, Model model) {
        ModelUtil.setModelValue(session, model);
        List<Clazz> clazzList = clazzService.getAllClazz();
        model.addAttribute("classes", clazzList);
        return "admin/classManage";
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

    @RequestMapping("/student")
    public String studentManage() {
        return "admin/studentManage";
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
}
