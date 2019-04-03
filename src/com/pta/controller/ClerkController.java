package com.pta.controller;

import java.util.ArrayList;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pta.java.ApplicationException;
import com.pta.model.AdminPOJO;
import com.pta.model.ClerkPOJO;
import com.pta.service.ClerkService;

@Controller
public class ClerkController {

	@Autowired
	public ClerkService clerkService;

	static Logger log = Logger.getLogger("patient-tracker-analysis");

	@RequestMapping(value = "/listAllClerk")
	public String listAllClerk(HttpServletRequest request, HttpSession session, ModelMap map) {
		if (session.getAttribute("name") != null) {
			ArrayList clerkDetails = null;

			try {
				clerkDetails = clerkService.fetchClerkDetails();
			} catch (ApplicationException ae) {
				log.info(ae.getMessage());
				return "ApplicationError";
			}

			request.setAttribute("clerkDetails", clerkDetails);
			return "ListAllClerk";
		} else {
			map.addAttribute("admin", new AdminPOJO());
			return "Home";
		}
	}

	@RequestMapping("/clerkAddition")
	public String clerkAddition(ModelMap map, HttpSession session, HttpServletRequest request) {
		if (session.getAttribute("name") != null) {
			map.addAttribute("clerk", new ClerkPOJO());
			return "AddClerk";
		} else {
			map.addAttribute("admin", new AdminPOJO());
			return "Home";
		}
	}

	@RequestMapping(value = "/addClerk", method = RequestMethod.POST)
	public String addClerk(HttpServletRequest request, ModelMap map, @ModelAttribute("clerk") ClerkPOJO pojo,
			HttpSession session) {
		if (session.getAttribute("name") != null) {
			ArrayList clerkDetails = null;
			String clerkId = null;

			try {
				clerkId = clerkService.addClerkDetails(pojo);
				clerkDetails = clerkService.fetchClerkDetails();
			} catch (ApplicationException ae) {
				log.info(ae.getMessage());
				return "ApplicationError";
			}

			map.addAttribute("clerkId", clerkId);
			request.setAttribute("success", "success");
			request.setAttribute("clerkDetails", clerkDetails);

			return "ListAllClerk";
		} else {
			map.addAttribute("admin", new AdminPOJO());
			return "Home";
		}
	}

	@RequestMapping("/clerkUpdation")
	public String clerkUpdation(@RequestParam("id") String id, ModelMap map, HttpServletRequest request,
			HttpSession session) {
		if (session.getAttribute("name") != null) {
			ClerkPOJO pojo = null;

			try {
				pojo = clerkService.fetchClerkDetails(id);
			} catch (ApplicationException ae) {
				log.info(ae.getMessage());
				return "ApplicationError";
			}

			map.addAttribute("clerk", new ClerkPOJO());
			request.setAttribute("pojo", pojo);
			return "UpdateClerk";
		} else {
			map.addAttribute("admin", new AdminPOJO());
			return "Home";
		}

	}

	@RequestMapping("/updateClerk")
	public String updateClerk(HttpServletRequest request, @ModelAttribute("clerk") ClerkPOJO pojo, ModelMap map,
			HttpSession session) {
		if (session.getAttribute("name") != null) {
			ArrayList clerkDetails = null;

			try {
				clerkService.updateClerkDetails(pojo);
				clerkDetails = clerkService.fetchClerkDetails();
			} catch (ApplicationException ae) {
				log.info(ae.getMessage());
				return "ApplicationError";
			}

			request.setAttribute("clerkDetails", clerkDetails);
			map.addAttribute("clerkId", pojo.getClerkId());
			request.setAttribute("update", "update");
			return "ListAllClerk";
		} else {
			map.addAttribute("admin", new AdminPOJO());
			return "Home";
		}
	}

	@RequestMapping("/viewClerkDetails")
	public String viewClerkDetails(@RequestParam("id") String id, ModelMap map, HttpServletRequest request,
			HttpSession session) {
		if (session.getAttribute("name") != null) {
			ClerkPOJO pojo = null;

			try {
				pojo = clerkService.fetchClerkDetails(id);
			} catch (ApplicationException ae) {
				log.info(ae.getMessage());
				return "ApplicationError";
			}

			map.addAttribute("clerk", new ClerkPOJO());
			request.setAttribute("pojo", pojo);
			return "IDClerkDetails";
		} else {
			map.addAttribute("admin", new AdminPOJO());
			return "Home";
		}
	}

}
