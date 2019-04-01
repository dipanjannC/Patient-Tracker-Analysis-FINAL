package com.pta.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pta.java.ApplicationException;
import com.pta.model.AdminPOJO;
import com.pta.model.ClerkPOJO;
import com.pta.service.ClerkService;
import com.pta.service.LoginService;
import com.pta.service.LoginServiceImpl;
import com.pta.validation.LoginValidation;
import com.pta.validation.LoginValidationImpl;

@Controller
public class LoginController {
	
	@Autowired
	public LoginService loginService;
	@Autowired
	public AdminPOJO adminPOJO;
	
	@RequestMapping("/")
	public String login(ModelMap map) {
	    map.addAttribute("admin", adminPOJO);
		return "Home";
	}

	@RequestMapping(value="/loginAdmin", method=RequestMethod.POST)
	public String loginAdmin(HttpServletRequest request, @ModelAttribute("admin") AdminPOJO pojo, ModelMap map) {
		
		//LoginValidation loginValidation = new LoginValidationImpl();
		//if(loginValidation.loginValidation(pojo)) {
			//AdminPOJO admin = new AdminPOJO();
			
			int id = Integer.parseInt(pojo.getAdminId().substring(3));
			
			/*
			 * admin.setAdminId(pojo.getAdminId().substring(3));
			 * admin.setPassword(pojo.getPassword());
			 */
			
			pojo.setAdminId(pojo.getAdminId().substring(3));
			pojo.setPassword(pojo.getPassword());
			
			//LoginService userLogin = new LoginServiceImpl();
			int check = 0;
			String name = null;
			
			try {
				check = loginService.checkAdmin(pojo);
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			if(check != 0)
			{
				try {
					name = loginService.getName(id);
				} catch (ApplicationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				HttpSession session = request.getSession();
				session.setAttribute("name", name);
				
				return "Dashboard";
			}
			
			else
			{
				request.setAttribute("failure", "failure");
				return "Home";
			}	
			
		}
		
	/*
	 * else { request.setAttribute("failure", "failure"); return "Home"; }
	 * 
	 * }
	 */
}
