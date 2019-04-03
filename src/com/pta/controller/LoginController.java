package com.pta.controller;

import java.util.logging.Logger;

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
import com.pta.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	public LoginService loginService;

	static Logger log = Logger.getLogger("patient-tracker-analysis");

	@RequestMapping("/")
	public String login(ModelMap map) {
		map.addAttribute("admin", new AdminPOJO());
		return "Home";
	}

	@RequestMapping(value = "/loginAdmin", method = RequestMethod.POST)
	public String loginAdmin(HttpServletRequest request, @ModelAttribute("admin") AdminPOJO pojo, ModelMap map) {
		int id = Integer.parseInt(pojo.getAdminId().substring(3));

		pojo.setAdminId(pojo.getAdminId().substring(3));
		pojo.setPassword(pojo.getPassword());

		int check = 0;
		String name = null;

		try {
			check = loginService.validateAdmin(pojo);
		} catch (ApplicationException ae) {
			log.info(ae.getMessage());
			return "ApplicationError";
		}

		if (check != 0) {
			try {
				name = loginService.getAdminName(id);
			} catch (ApplicationException ae) {
				log.info(ae.getMessage());
				return "ApplicationError";
			}

			HttpSession session = request.getSession();
			session.setAttribute("name", name);

			return "Dashboard";
		}

		else {
			request.setAttribute("failure", "failure");
			return "Home";
		}

	}

}
