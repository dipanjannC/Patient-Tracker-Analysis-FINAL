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
import com.pta.model.MedicinePOJO;
import com.pta.service.MedicineService;

@Controller
public class MedicineController {

	@Autowired
	public MedicineService medicineService;

	static Logger log = Logger.getLogger("patient-tracker-analysis");

	@RequestMapping("/listAllMedicine")
	public String listAllMedicine(ModelMap map, HttpServletRequest request, HttpSession session) {
		if (session.getAttribute("name") != null) {
			ArrayList medicineDetails = null;

			try {
				medicineDetails = medicineService.fetchMedicineDetails();
			} catch (ApplicationException ae) {
				log.info(ae.getMessage());
				return "ApplicationError";
			}

			request.setAttribute("medicineDetails", medicineDetails);
			return "ListAllMedicine";
		} else {
			map.addAttribute("admin", new AdminPOJO());
			return "Home";
		}
	}

	@RequestMapping("/medicineAddition")
	public String medicineAddition(ModelMap map, HttpSession session) {
		if (session.getAttribute("name") != null) {
			map.addAttribute("medicine", new MedicinePOJO());
			return "AddMedicine";
		} else {
			map.addAttribute("admin", new AdminPOJO());
			return "Home";
		}
	}

	@RequestMapping(value = "/addMedicine", method = RequestMethod.POST)
	public String addMedicine(HttpServletRequest request, ModelMap map, @ModelAttribute("admin") MedicinePOJO pojo,
			HttpSession session) {
		if (session.getAttribute("name") != null) {
			String medicineId = null;
			ArrayList medicineDetails = null;

			try {
				medicineId = medicineService.addMedicineDetails(pojo);
				medicineDetails = medicineService.fetchMedicineDetails();
			} catch (ApplicationException ae) {
				log.info(ae.getMessage());
				return "ApplicationError";
			}

			map.addAttribute("medicineId", medicineId);
			request.setAttribute("success", "success");
			request.setAttribute("medicineDetails", medicineDetails);

			return "ListAllMedicine";
		} else {
			map.addAttribute("admin", new AdminPOJO());
			return "Home";
		}
	}

	@RequestMapping("/medicineUpdation")
	public String medicineUpdation(@RequestParam("id") String id, ModelMap map, HttpServletRequest request,
			HttpSession session) {
		if (session.getAttribute("name") != null) {
			MedicinePOJO pojo = null;

			try {
				pojo = medicineService.fetchMedicineDetails(id);
			} catch (ApplicationException ae) {
				log.info(ae.getMessage());
				return "ApplicationError";
			}

			map.addAttribute("medicine", new MedicinePOJO());
			request.setAttribute("pojo", pojo);
			return "UpdateMedicine";
		} else {
			map.addAttribute("admin", new AdminPOJO());
			return "Home";
		}

	}

	@RequestMapping("/updateMedicine")
	public String updateMedicine(HttpServletRequest request, @ModelAttribute("medicine") MedicinePOJO pojo,
			ModelMap map, HttpSession session) {
		if (session.getAttribute("name") != null) {
			ArrayList medicineDetails = null;

			try {
				medicineDetails = medicineService.fetchMedicineDetails();
				medicineService.updateMedicineDetails(pojo);
			} catch (ApplicationException ae) {
				log.info(ae.getMessage());
				return "ApplicationError";
			}

			request.setAttribute("medicineDetails", medicineDetails);
			map.addAttribute("medicineId", pojo.getMedicineId());
			request.setAttribute("update", "update");
			return "ListAllMedicine";
		} else {
			map.addAttribute("admin", new AdminPOJO());
			return "Home";
		}
	}

	@RequestMapping("/viewMedicineDetails")
	public String viewMedicineDetails(@RequestParam("id") String id, ModelMap map, HttpServletRequest request,
			HttpSession session) {
		if (session.getAttribute("name") != null) {
			MedicinePOJO pojo = null;

			try {
				pojo = medicineService.fetchMedicineDetails(id);
			} catch (ApplicationException ae) {
				log.info(ae.getMessage());
				return "ApplicationError";
			}

			map.addAttribute("medicine", new MedicinePOJO());
			request.setAttribute("pojo", pojo);
			return "IDMedicineDetails";
		} else {
			map.addAttribute("admin", new AdminPOJO());
			return "Home";
		}
	}

}
