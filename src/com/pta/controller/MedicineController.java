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
import com.pta.model.MedicinePOJO;
import com.pta.service.ClerkService;
import com.pta.service.ClerkServiceImpl;
import com.pta.service.LoginService;
import com.pta.service.MedicineService;
import com.pta.service.MedicineServiceImpl;
import com.pta.service.PatientService;
import com.pta.service.PatientServiceImpl;

@Controller
public class MedicineController {
	
	@Autowired
	public MedicineService medicineService;
	@Autowired
	public MedicinePOJO medicinePOJO;
	
	@RequestMapping("/listAllMedicine")
	public String listAllMedicine(HttpServletRequest request) {
		
		//MedicineService medicineService = new MedicineServiceImpl();		
		ArrayList medicineDetails = null;
		
		try {
			medicineDetails = medicineService.fetchMedicineDetails();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("medicineDetails", medicineDetails);
		return "ListAllMedicine";
	}
	
	
	@RequestMapping("/medicineAddition")
	public String medicineAddition(ModelMap map) {
		map.addAttribute("medicine", medicinePOJO);
		return "AddMedicine";
	}

	

	
	@RequestMapping(value="/addMedicine", method=RequestMethod.POST)
	public String addMedicine(HttpServletRequest request, ModelMap map, @ModelAttribute("admin") MedicinePOJO pojo) {		
		
		//MedicineService medicineService=new MedicineServiceImpl();	
		String id = null;
		ArrayList medicineDetails = null;
		
		try {
			id = medicineService.addMedicineDetails(pojo);
			medicineDetails = medicineService.fetchMedicineDetails();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		map.addAttribute("id", id);
		request.setAttribute("success", "success");		
		request.setAttribute("medicineDetails", medicineDetails);
		
		return "ListAllMedicine";
	}
	
	@RequestMapping("/medicineUpdation")
	public String medicineUpdation(@RequestParam("id") String id, ModelMap map, HttpServletRequest request) {
		//MedicineService clerkService = new MedicineServiceImpl();
		MedicinePOJO pojo = null;
		
		try {
			pojo = medicineService.fetchMedicineDetails(id);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		map.addAttribute("medicine", medicinePOJO);
		request.setAttribute("pojo", pojo);
		return "UpdateMedicine";
		
	}
	
	
	@RequestMapping("/updateMedicine")
	public String updateMedicine(HttpServletRequest request, @ModelAttribute("medicine") MedicinePOJO pojo, ModelMap map) {
		//MedicineService medicineService = new MedicineServiceImpl();
		ArrayList medicineDetails = null;
		
		
		try {
			medicineDetails = medicineService.fetchMedicineDetails();
			medicineService.updateMedicineDetails(pojo);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("medicineDetails", medicineDetails);
		map.addAttribute("id", pojo.getMedicineId());
		request.setAttribute("update", "update");
		return "ListAllMedicine";
	}
	
	
	@RequestMapping("/viewMedicineDetails")
	public String viewMedicineDetails(@RequestParam("id") String id, ModelMap map, HttpServletRequest request)
	{
		//MedicineService medicineService = new MedicineServiceImpl();
		MedicinePOJO pojo = null;
		
		try {
			pojo = medicineService.fetchMedicineDetails(id);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		map.addAttribute("medicine", medicinePOJO);
		request.setAttribute("pojo", pojo);
		return "IDMedicineDetails";
	}

}
	

