package com.pta.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pta.model.AdminPOJO;

@Controller
public class LogoutController {

	@RequestMapping("/logout")
	public String logoutAdmin(HttpServletRequest request, ModelMap map, HttpSession session) {
		if (session.getAttribute("name") != null) {
			session.invalidate();
			map.addAttribute("admin", new AdminPOJO());
			return "Home";
		} else {
			map.addAttribute("admin", new AdminPOJO());
			return "Home";
		}
	}
}
