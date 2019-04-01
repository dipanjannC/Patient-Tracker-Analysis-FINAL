package com.pta.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pta.model.AdminPOJO;

@Controller
public class LogoutController {
	
	@Autowired
	public AdminPOJO adminPOJO;
	
	@RequestMapping("/logout")
	public String logoutAdmin(HttpServletRequest request, ModelMap map){
		
		HttpSession session = request.getSession(false);
		session.invalidate();
		map.addAttribute("admin", adminPOJO);
		return "Home";
	}
}
