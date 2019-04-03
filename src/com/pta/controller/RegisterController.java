package com.pta.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pta.java.ApplicationException;
import com.pta.model.AdminPOJO;
import com.pta.service.RegisterService;

@Controller
public class RegisterController {

	@Autowired
	public RegisterService registerService;

	static Logger log = Logger.getLogger("patient-tracker-analysis");

	@RequestMapping("/adminRegistration")
	public String adminRegistration(ModelMap map) {
		map.addAttribute("admin", new AdminPOJO());
		return "RegisterAdmin";
	}

	@RequestMapping(value = "/registerAdmin", method = RequestMethod.POST)
	public String registerAdmin(HttpServletRequest request, ModelMap map, @ModelAttribute("admin") AdminPOJO pojo) {
		if (pojo.getPassword().equals(pojo.getConfirmPassword())) {
			String id = null;
			try {
				id = registerService.addAdminDetails(pojo);
			} catch (ApplicationException ae) {
				log.info(ae.getMessage());
				return "ApplicationError";
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
