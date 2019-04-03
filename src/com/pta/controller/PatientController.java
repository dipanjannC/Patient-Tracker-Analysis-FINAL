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
import com.pta.model.PatientPOJO;
import com.pta.service.PatientService;

@Controller
public class PatientController {

	@Autowired
	public PatientService patientService;

	static Logger log = Logger.getLogger("patient-tracker-analysis");

	@RequestMapping(value = "/listAllPatient")
	public String listAllPatient(ModelMap map, HttpServletRequest request, HttpSession session) {
		if (session.getAttribute("name") != null) {
			ArrayList patientDetails = null;

			try {
				patientDetails = patientService.fetchPatientDetails();
			} catch (ApplicationException ae) {
				log.info(ae.getMessage());
				return "ApplicationError";
			}

			request.setAttribute("patientDetails", patientDetails);
			return "ListAllPatient";
		} else {
			map.addAttribute("admin", new AdminPOJO());
			return "Home";
		}
	}

	@RequestMapping("/patientAddition")
	public String patientAddition(ModelMap map, HttpSession session) {
		if (session.getAttribute("name") != null) {
			map.addAttribute("patient", new PatientPOJO());
			return "AddPatient";
		} else {
			map.addAttribute("admin", new AdminPOJO());
			return "Home";
		}
	}

	@RequestMapping(value = "/addPatient", method = RequestMethod.POST)
	public String addPatient(HttpServletRequest request, ModelMap map, @ModelAttribute("patient") PatientPOJO pojo,
			HttpSession session) {
		if (session.getAttribute("name") != null) {
			ArrayList patientDetails = null;
			String patientId = null;

			try {
				patientDetails = patientService.fetchPatientDetails();
				patientId = patientService.addPatientDetails(pojo);
			} catch (ApplicationException ae) {
				log.info(ae.getMessage());
				return "ApplicationError";
			}

			map.addAttribute("patientId", patientId);
			request.setAttribute("success", "success");

			request.setAttribute("patientDetails", patientDetails);

			return "ListAllPatient";
		} else {
			map.addAttribute("admin", new AdminPOJO());
			return "Home";
		}
	}

	@RequestMapping("/patientUpdation")
	public String patientUpdation(@RequestParam("id") String id, ModelMap map, HttpServletRequest request,
			HttpSession session) {
		if (session.getAttribute("name") != null) {
			PatientPOJO pojo = null;

			try {
				pojo = patientService.fetchPatientDetails(id);
			} catch (ApplicationException ae) {
				log.info(ae.getMessage());
				return "ApplicationError";
			}

			map.addAttribute("patient", new PatientPOJO());
			request.setAttribute("pojo", pojo);
			return "UpdatePatient";
		} else {
			map.addAttribute("admin", new AdminPOJO());
			return "Home";
		}

	}

	@RequestMapping("/updatePatient")
	public String updatePatient(HttpServletRequest request, @ModelAttribute("patient") PatientPOJO pojo, ModelMap map,
			HttpSession session) {
		if (session.getAttribute("name") != null) {
			ArrayList patientDetails = null;

			try {
				patientService.updatePatientDetails(pojo);
				patientDetails = patientService.fetchPatientDetails();
			} catch (ApplicationException ae) {
				log.info(ae.getMessage());
				return "ApplicationError";
			}

			request.setAttribute("patientDetails", patientDetails);
			map.addAttribute("patientId", pojo.getPatientId());
			request.setAttribute("update", "update");
			return "ListAllPatient";
		} else {
			map.addAttribute("admin", new AdminPOJO());
			return "Home";
		}
	}

	@RequestMapping("/viewPatientDetails")
	public String viewPatientDetails(@RequestParam("id") String id, ModelMap map, HttpServletRequest request,
			HttpSession session) {
		if (session.getAttribute("name") != null) {
			PatientPOJO pojo = null;

			try {
				pojo = patientService.fetchPatientDetails(id);
			} catch (ApplicationException ae) {
				log.info(ae.getMessage());
				return "ApplicationError";
			}

			map.addAttribute("patient", new PatientPOJO());
			request.setAttribute("pojo", pojo);
			return "IDPatientDetails";
		} else {
			map.addAttribute("admin", new AdminPOJO());
			return "Home";
		}
	}

}
