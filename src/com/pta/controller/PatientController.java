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
import com.pta.model.AdminPOJO;
import com.pta.model.ClerkPOJO;
import com.pta.model.PatientPOJO;
import com.pta.service.ClerkService;
import com.pta.service.ClerkServiceImpl;
import com.pta.service.LoginService;
import com.pta.service.PatientService;
import com.pta.service.PatientServiceImpl;

@Controller
public class PatientController {
	
	@Autowired
	public PatientService patientService;
	@Autowired
	public PatientPOJO patientPOJO;
	
	@RequestMapping(value="/listAllPatient")
	public String listAllPatient(HttpServletRequest request) {
		
		//PatientService patientService = new PatientServiceImpl();
		ArrayList patientDetails = null;
		
		try {
			patientDetails = patientService.fetchPatientDetails();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("patientDetails", patientDetails);
		return "ListAllPatient";
	}
	
	
	@RequestMapping("/patientAddition")
	public String patientAddition(ModelMap map) {
		map.addAttribute("patient", patientPOJO);
		return "AddPatient";
	}
	
	
	@RequestMapping(value="/addPatient", method=RequestMethod.POST)
	public String addPatient(HttpServletRequest request, ModelMap map, @ModelAttribute("patient") PatientPOJO pojo) {
		
		//PatientService patientService=new PatientServiceImpl();	
		ArrayList patientDetails= null;
		String id = null;
		
		try {
			patientDetails = patientService.fetchPatientDetails();
			id = patientService.addPatientDetails(pojo);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		map.addAttribute("id", id);
		request.setAttribute("success", "success");
		
		
		request.setAttribute("patientDetails", patientDetails);
		
		return "ListAllPatient";
	}
	
	@RequestMapping("/patientUpdation")
	public String patientUpdation(@RequestParam("id") String id, ModelMap map, HttpServletRequest request) {
		//PatientService patientService = new PatientServiceImpl();
		PatientPOJO pojo = null;
		
		try {
			pojo = patientService.fetchPatientDetails(id);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		map.addAttribute("patient", patientPOJO);
		request.setAttribute("pojo", pojo);
		return "UpdatePatient";
		
	}
	
	
	@RequestMapping("/updatePatient")
	public String updatePatient(HttpServletRequest request, @ModelAttribute("patient") PatientPOJO pojo, ModelMap map) {
		//PatientService patientService = new PatientServiceImpl();
		ArrayList patientDetails = null;
		
		try {
			patientService.updatePatientDetails(pojo);
			patientDetails = patientService.fetchPatientDetails();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("patientDetails", patientDetails);
		map.addAttribute("id", pojo.getPatientId());
		request.setAttribute("update", "update");
		return "ListAllPatient";
	}
	
	@RequestMapping("/viewPatientDetails")
	public String viewPatientDetails(@RequestParam("id") String id, ModelMap map, HttpServletRequest request)
	{
		//PatientService patientService = new PatientServiceImpl();
		PatientPOJO pojo = null;
		
		try {
			pojo = patientService.fetchPatientDetails(id);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		map.addAttribute("patient", patientPOJO);
		request.setAttribute("pojo", pojo);
		return "IDPatientDetails";
	}

}
