package com.pta.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pta.java.ApplicationException;
import com.pta.model.ClerkPOJO;
import com.pta.service.ClerkService;
import com.pta.service.ClerkServiceImpl;

@Controller
public class ClerkController {
	
	@Autowired
	public ClerkService clerkService;
	@Autowired
	public ClerkPOJO clerkPOJO;
	
	
	@RequestMapping(value="/listAllClerk")
	public String listAllClerk(HttpServletRequest request) {
		
		//ClerkService clerkService = new ClerkServiceImpl();
		ArrayList clerkDetails = null;
		
		try {
			clerkDetails = clerkService.fetchClerkDetails();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("clerkDetails", clerkDetails);
		return "ListAllClerk";
	}
	
	
	@RequestMapping("/clerkAddition")
	public String clerkAddition(ModelMap map) {
		map.addAttribute("clerk", clerkPOJO);
		return "AddClerk";
	}
	
	
	@RequestMapping(value="/addClerk", method=RequestMethod.POST)
	public String addClerk(HttpServletRequest request, ModelMap map, @ModelAttribute("clerk") ClerkPOJO pojo) {
		
		//ClerkService clerkService=new ClerkServiceImpl();		
		ArrayList clerkDetails = null;		
		String id = null;
		
		try {
			id = clerkService.addClerkDetails(pojo);
			clerkDetails = clerkService.fetchClerkDetails();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		map.addAttribute("id", id);
		request.setAttribute("success", "success");
		request.setAttribute("clerkDetails", clerkDetails);
		
		return "ListAllClerk";
	}
	
	@RequestMapping("/clerkUpdation")
	public String clerkUpdation(@RequestParam("id") String id, ModelMap map, HttpServletRequest request) {
		
		//ClerkService clerkService = new ClerkServiceImpl();		
		ClerkPOJO pojo = null;
		
		try {
			pojo = clerkService.fetchClerkDetails(id);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		map.addAttribute("clerk", clerkPOJO);
		request.setAttribute("pojo", pojo);
		return "UpdateClerk";
		
	}
	
	
	@RequestMapping("/updateClerk")
	public String updateClerk(HttpServletRequest request, @ModelAttribute("clerk") ClerkPOJO pojo, ModelMap map) {
		
		//ClerkService clerkService = new ClerkServiceImpl();
		ArrayList clerkDetails = null;
		
		try {
			clerkService.updateClerkDetails(pojo);
			clerkDetails = clerkService.fetchClerkDetails();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("clerkDetails", clerkDetails);
		map.addAttribute("id", pojo.getClerkId());
		request.setAttribute("update", "update");
		return "ListAllClerk";
	}
	
	@RequestMapping("/viewClerkDetails")
	public String viewClerkDetails(@RequestParam("id") String id, ModelMap map, HttpServletRequest request)
	{
		//ClerkService clerkService = new ClerkServiceImpl();
		ClerkPOJO pojo = null;
		
		try {
			pojo = clerkService.fetchClerkDetails(id);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		map.addAttribute("clerk", clerkPOJO);
		request.setAttribute("pojo", pojo);
		return "IDClerkDetails";
	}


}
