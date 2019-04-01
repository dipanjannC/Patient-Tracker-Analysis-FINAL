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
import com.pta.model.DoctorPOJO;
import com.pta.service.ClerkService;
import com.pta.service.ClerkServiceImpl;
import com.pta.service.DoctorService;
import com.pta.service.DoctorServiceImpl;

@Controller
public class DoctorController {
	
	@Autowired
	public DoctorService doctorService;
	@Autowired
	public DoctorPOJO doctorPOJO;

	@RequestMapping(value="/listAllDoctor")
	public String listAllClerk(HttpServletRequest request) {
		
		//DoctorService doctorService = new DoctorServiceImpl();
		ArrayList doctorDetails = null;
		
		try {
			doctorDetails = doctorService.fetchDoctorDetails();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("doctorDetails", doctorDetails);
		return "ListAllDoctor";
	}
	
	
	@RequestMapping("/doctorAddition")
	public String doctorAddition(ModelMap map) {
		map.addAttribute("doctor", doctorPOJO);
		return "AddDoctor";
	}
	
	
	@RequestMapping(value="/addDoctor", method=RequestMethod.POST)
	public String addClerk(HttpServletRequest request, ModelMap map, @ModelAttribute("doctor") DoctorPOJO pojo) {
		
		//DoctorService doctorService=new DoctorServiceImpl();	
		String id = null;
		ArrayList doctorDetails = null;
		
		try {
			id = doctorService.addDoctorDetails(pojo);
			doctorDetails = doctorService.fetchDoctorDetails();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		map.addAttribute("id", id);
		request.setAttribute("success", "success");
		request.setAttribute("doctorDetails", doctorDetails);
		
		return "ListAllDoctor";
	}
	
	
	@RequestMapping("/doctorUpdation")
	public String doctorUpdation(@RequestParam("id") String id, ModelMap map, HttpServletRequest request) {
		//DoctorService doctorService = new DoctorServiceImpl();
		DoctorPOJO pojo = null;
		
		try {
			pojo = doctorService.fetchDoctorDetails(id);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		map.addAttribute("doctor", doctorPOJO);
		request.setAttribute("pojo", pojo);
		return "UpdateDoctor";
		
	}
	
	
	@RequestMapping("/updateDoctor")
	public String updateDoctor(HttpServletRequest request, @ModelAttribute("doctor") DoctorPOJO pojo, ModelMap map) {
		//DoctorService doctorService = new DoctorServiceImpl();
		ArrayList doctorDetails = null;
		
		
		try {
			doctorDetails = doctorService.fetchDoctorDetails();
			doctorService.updateDoctorDetails(pojo);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("doctorDetails", doctorDetails);
		map.addAttribute("id", pojo.getDoctorId());
		request.setAttribute("update", "update");
		return "ListAllDoctor";
	}
	
	@RequestMapping("/viewDoctorDetails")
	public String viewDoctorDetails(@RequestParam("id") String id, ModelMap map, HttpServletRequest request)
	{
		//DoctorService doctorService = new DoctorServiceImpl();		
		DoctorPOJO pojo = null;
		
		try {
			pojo = doctorService.fetchDoctorDetails(id);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		map.addAttribute("doctor", doctorPOJO);
		request.setAttribute("pojo", pojo);
		return "IDDoctorDetails";
	}
	
}
