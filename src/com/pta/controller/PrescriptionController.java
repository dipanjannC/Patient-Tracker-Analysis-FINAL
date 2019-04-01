package com.pta.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pta.java.ApplicationException;
import com.pta.model.AdminPOJO;
import com.pta.model.PrescriptionPOJO;
import com.pta.service.ClerkService;
import com.pta.service.ClerkServiceImpl;
import com.pta.service.LoginService;
import com.pta.service.PrescriptionService;
import com.pta.service.PrescriptionServiceImpl;

@Controller
public class PrescriptionController {
	
	@Autowired
	public PrescriptionService prescriptionService;
	@Autowired
	public PrescriptionPOJO prescriptionPOJO;
	
	

	@RequestMapping(value="/listAllPrescription")
	public String listAllClerk(HttpServletRequest request) {
		
		//PrescriptionService prescriptionService = new PrescriptionServiceImpl();
		ArrayList prescriptionDetails = null;
		
		try {
			prescriptionDetails = prescriptionService.fetchPrescriptionDetails();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("prescriptionDetails", prescriptionDetails);
		return "ListAllPrescription";
	}
	
	
	
	@RequestMapping(value="/addPrescriptionForm")
	public String addClerkForm(ModelMap map,HttpServletRequest request) {
		
		//PrescriptionService prescriptionService = new PrescriptionServiceImpl();		
		ArrayList patientId = null;
		ArrayList doctorId = null;
		ArrayList medicineId = null;
		
		try {
			patientId = prescriptionService.getPatientId();
	        doctorId = prescriptionService.getDoctorId();
			medicineId = prescriptionService.getMedicinetId();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		request.setAttribute("patientId", patientId);
		request.setAttribute("doctorId", doctorId);
		request.setAttribute("medicineId", medicineId);
		map.addAttribute("prescription", prescriptionPOJO);
		return "AddPrescription";
	}
	
	
	
	@RequestMapping(value="/addPrescription")
	public String addPrescriptionDetails(HttpServletRequest request, @ModelAttribute("prescription") PrescriptionPOJO pojo, ModelMap map)
	{
		//PrescriptionService prescriptionService = new PrescriptionServiceImpl();
		String prescriptionId = null;
		ArrayList prescriptionDetails = null;
		
		try {
			prescriptionDetails = prescriptionService.fetchPrescriptionDetails();
			prescriptionId =  prescriptionService.addPrescriptionDetails(pojo);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("prescriptionDetails", prescriptionDetails);
		map.addAttribute("prescriptionId", prescriptionId);
		request.setAttribute("success", "success");
		return "ListAllPrescription";
		
	}
	
	
	
	@RequestMapping("/updatePrescriptionForm")
	public String updatePrescription(HttpServletRequest request, @ModelAttribute("prescription") PrescriptionPOJO pojo, ModelMap map) {
		//PrescriptionService prescriptionService = new PrescriptionServiceImpl();
		ArrayList prescriptionDetails = null;
		try {
			prescriptionService.updatePrescriptionDetails(pojo);
			prescriptionDetails = prescriptionService.fetchPrescriptionDetails();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		request.setAttribute("prescriptionDetails", prescriptionDetails);
		map.addAttribute("id", pojo.getRequestId());
		request.setAttribute("update", "update");
		return "ListAllPrescription";
	}
	
	
	@RequestMapping("/viewPrescriptionDetails")
	public String viewPrescriptionDetails(@RequestParam("id") String id, ModelMap map, HttpServletRequest request)
	{
		//PrescriptionService prescriptionService = new PrescriptionServiceImpl();
		PrescriptionPOJO pojo = null;
		try {
			pojo = prescriptionService.fetchPrescriptionDetails(id);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.addAttribute("prescription", new PrescriptionPOJO());
		request.setAttribute("pojo", pojo);
		return "IDPrescriptionDetails";
	}
	
	@RequestMapping("/updatePrescription")
	public String updatePrescription(@RequestParam("id") String id, ModelMap map, HttpServletRequest request) {
		//PrescriptionService prescriptionService = new PrescriptionServiceImpl();
		PrescriptionPOJO pojo = null;
		ArrayList medicineId = null;
		
		try {
			pojo = prescriptionService.fetchPrescriptionDetails(id);
			medicineId = prescriptionService.getMedicinetId();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("medicineId", medicineId);
		/*request.setAttribute("id",id);*/
		map.addAttribute("prescription", new PrescriptionPOJO());
		request.setAttribute("pojo", pojo);
		return "UpdatePrescription";
		
	}
}
