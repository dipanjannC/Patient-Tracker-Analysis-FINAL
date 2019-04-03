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
import org.springframework.web.bind.annotation.RequestParam;
import com.pta.java.ApplicationException;
import com.pta.model.AdminPOJO;
import com.pta.model.PrescriptionPOJO;
import com.pta.service.PrescriptionService;

@Controller
public class PrescriptionController {

	@Autowired
	public PrescriptionService prescriptionService;

	static Logger log = Logger.getLogger("patient-tracker-analysis");

	@RequestMapping(value = "/listAllPrescription")
	public String listAllClerk(ModelMap map, HttpServletRequest request, HttpSession session) {
		if (session.getAttribute("name") != null) {
			ArrayList prescriptionDetails = null;

			try {
				prescriptionDetails = prescriptionService.fetchPrescriptionDetails();
			} catch (ApplicationException ae) {
				log.info(ae.getMessage());
				return "ApplicationError";
			}

			request.setAttribute("prescriptionDetails", prescriptionDetails);
			return "ListAllPrescription";
		} else {
			map.addAttribute("admin", new AdminPOJO());
			return "Home";
		}
	}

	@RequestMapping(value = "/prescriptionAddition")
	public String prescriptionAddition(ModelMap map, HttpServletRequest request, HttpSession session) {
		if (session.getAttribute("name") != null) {
			ArrayList patientIds = null;
			ArrayList doctorIds = null;
			ArrayList medicineIds = null;

			try {
				patientIds = prescriptionService.getPatientIds();
				doctorIds = prescriptionService.getDoctorIds();
				medicineIds = prescriptionService.getMedicinetIds();
			} catch (ApplicationException ae) {
				log.info(ae.getMessage());
				return "ApplicationError";
			}

			request.setAttribute("patientIds", patientIds);
			request.setAttribute("doctorIds", doctorIds);
			request.setAttribute("medicineIds", medicineIds);
			map.addAttribute("prescription", new PrescriptionPOJO());
			return "AddPrescription";
		} else {
			map.addAttribute("admin", new AdminPOJO());
			return "Home";
		}
	}

	@RequestMapping(value = "/addPrescription")
	public String addPrescriptionDetails(HttpServletRequest request,
			@ModelAttribute("prescription") PrescriptionPOJO pojo, ModelMap map, HttpSession session) {
		if (session.getAttribute("name") != null) {
			String prescriptionId = null;
			ArrayList prescriptionDetails = null;

			try {
				prescriptionId = prescriptionService.addPrescriptionDetails(pojo);
				prescriptionDetails = prescriptionService.fetchPrescriptionDetails();
			} catch (ApplicationException ae) {
				log.info(ae.getMessage());
				return "ApplicationError";
			}

			request.setAttribute("prescriptionDetails", prescriptionDetails);
			map.addAttribute("prescriptionId", prescriptionId);
			request.setAttribute("success", "success");
			return "ListAllPrescription";
		} else {
			map.addAttribute("admin", new AdminPOJO());
			return "Home";
		}

	}

	@RequestMapping("/prescriptionUpdation")
	public String updatePrescription(@RequestParam("id") String id, ModelMap map, HttpServletRequest request,
			HttpSession session) {
		if (session.getAttribute("name") != null) {
			PrescriptionPOJO pojo = null;
			ArrayList medicineIds = null;

			try {
				pojo = prescriptionService.fetchPrescriptionDetails(id);
				medicineIds = prescriptionService.getMedicinetIds();
			} catch (ApplicationException ae) {
				log.info(ae.getMessage());
				return "ApplicationError";
			}

			request.setAttribute("medicineIds", medicineIds);
			map.addAttribute("prescription", new PrescriptionPOJO());
			request.setAttribute("pojo", pojo);
			return "UpdatePrescription";
		} else {
			map.addAttribute("admin", new AdminPOJO());
			return "Home";
		}
	}

	@RequestMapping("/updatePrescription")
	public String prescriptioUpdation(HttpServletRequest request, @ModelAttribute("prescription") PrescriptionPOJO pojo,
			ModelMap map, HttpSession session) {
		if (session.getAttribute("name") != null) {
			ArrayList prescriptionDetails = null;
			try {
				prescriptionService.updatePrescriptionDetails(pojo);
				prescriptionDetails = prescriptionService.fetchPrescriptionDetails();
			} catch (ApplicationException ae) {
				log.info(ae.getMessage());
				return "ApplicationError";
			}

			request.setAttribute("prescriptionDetails", prescriptionDetails);
			map.addAttribute("prescriptionId", pojo.getRequestId());
			request.setAttribute("update", "update");
			return "ListAllPrescription";
		} else {
			map.addAttribute("admin", new AdminPOJO());
			return "Home";
		}
	}

	@RequestMapping("/viewPrescriptionDetails")
	public String viewPrescriptionDetails(@RequestParam("id") String id, ModelMap map, HttpServletRequest request,
			HttpSession session) {
		if (session.getAttribute("name") != null) {
			PrescriptionPOJO pojo = null;
			try {
				pojo = prescriptionService.fetchPrescriptionDetails(id);
			} catch (ApplicationException ae) {
				log.info(ae.getMessage());
				return "ApplicationError";
			}
			map.addAttribute("prescription", new PrescriptionPOJO());
			request.setAttribute("pojo", pojo);
			return "IDPrescriptionDetails";
		} else {
			map.addAttribute("admin", new AdminPOJO());
			return "Home";
		}
	}

}
