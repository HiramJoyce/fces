package com.fces.controller;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.druid.util.StringUtils;
import com.fces.domain.Clazz;
import com.fces.domain.Teacher;
import com.fces.service.ClazzService;
import com.fces.service.TeacherService;
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
    public String classManage(HttpServletRequest request, Model model) {
	    String message = (String) request.getSession().getAttribute("message");
	    if (message != null) {
	        model.addAttribute("message", message);
	        request.getSession().removeAttribute("message");
        }
        String error = (String) request.getSession().getAttribute("error");
        if (error != null) {
            model.addAttribute("error", error);
            request.getSession().removeAttribute("error");
        }
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
    public String classUpdate(Clazz clazz, Model model, HttpServletRequest request) {
        System.out.println("admin class update clazz " + clazz.toString());
        if (clazz.getId()!= null && !StringUtils.equals(clazz.getId(), "")) {
            if (clazzService.updateClazz(clazz) != null) {
                request.getSession().setAttribute("message", "修改成功！");
//                model.addAttribute("message", "修改成功！");
            } else {
                request.getSession().setAttribute("error", "修改失败！");
//                model.addAttribute("error", "修改失败！");
            }
        } else {
            if (clazzService.createClazz(clazz) != null) {
                request.getSession().setAttribute("message", "添加成功！");
//                model.addAttribute("message", "添加成功！");
            } else {
                request.getSession().setAttribute("error", "添加失败！");
//                model.addAttribute("error", "添加失败！");
            }
        }
        return "redirect:/admin/class";
    }
}
