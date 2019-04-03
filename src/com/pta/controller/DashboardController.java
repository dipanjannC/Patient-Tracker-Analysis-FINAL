package com.pta.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pta.model.AdminPOJO;

@Controller
public class DashboardController {
	
	@RequestMapping("/dashboard")
	public String viewDashboard(ModelMap map, HttpSession session) {
		if (session.getAttribute("name")!=null) {
			return "Dashboard";
		}
		else {
			map.addAttribute("admin", new AdminPOJO());
			return "Home";
		}
	}
	
}
