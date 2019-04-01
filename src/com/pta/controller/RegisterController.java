package com.pta.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pta.java.ApplicationException;
import com.pta.model.AdminPOJO;
import com.pta.service.LoginService;
import com.pta.service.RegisterService;
import com.pta.service.RegisterServiceImpl;

@Controller
public class RegisterController {
	
	@Autowired
	public RegisterService registerService;
	@Autowired
	public AdminPOJO adminPOJO;
	
	@RequestMapping("/register")
	public String register(ModelMap map) {
		map.addAttribute("admin", adminPOJO);
		return "Registration";
	}
	
	@RequestMapping(value="/registerAdmin", method=RequestMethod.POST)
	public String registerAdmin(HttpServletRequest request, ModelMap map, @ModelAttribute("admin") AdminPOJO pojo) {
		

			if(pojo.getPassword().equals(pojo.getConfirmPassword())) {
				
				//RegisterService newAdmin = new RegisterServiceImpl();
				String id = null;
				try {
					id = registerService.addAdmin(pojo);
				} catch (ApplicationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				map.addAttribute("id", id);
				request.setAttribute("success", "successs");
				return "Home";
			}
			
			else {
				request.setAttribute("passwordError", "passwordError");
				return "PasswordError";
			}
		}
	}
