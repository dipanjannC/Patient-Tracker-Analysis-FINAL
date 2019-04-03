package com.pta.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pta.model.AdminPOJO;

@Controller
public class HomeController {

	@Autowired
	public AdminPOJO adminPOJO;

	@RequestMapping("/home")
	public String viewHome(ModelMap map) {
		map.addAttribute("admin", adminPOJO);
		return "Home";
	}

}
