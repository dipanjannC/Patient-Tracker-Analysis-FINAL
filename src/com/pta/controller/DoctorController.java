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
import com.pta.model.DoctorPOJO;
import com.pta.service.DoctorService;

@Controller
public class DoctorController {

	@Autowired
	public DoctorService doctorService;
	
	static Logger log = Logger.getLogger("patient-tracker-analysis");

	@RequestMapping(value = "/listAllDoctor")
	public String listAllClerk(HttpServletRequest request, HttpSession session, ModelMap map) {
		if (session.getAttribute("name") != null) {
    		ArrayList doctorDetails = null;

    		try {
    			doctorDetails = doctorService.fetchDoctorDetails();
    		} catch (ApplicationException ae) {
    			log.info(ae.getMessage());
    			return "ApplicationError";
    		}

    		request.setAttribute("doctorDetails", doctorDetails);
    		return "ListAllDoctor";
        }
		else {
			map.addAttribute("admin", new AdminPOJO());
			return "Home";
		}
	}

	@RequestMapping("/doctorAddition")
	public String doctorAddition(ModelMap map, HttpSession session) {
        if (session.getAttribute("name")!=null) {
    		map.addAttribute("doctor", new DoctorPOJO());
    		return "AddDoctor";
        }
		else {
			map.addAttribute("admin", new AdminPOJO());
			return "Home";
		}
	}

	@RequestMapping(value = "/addDoctor", method = RequestMethod.POST)
	public String addClerk(HttpServletRequest request, ModelMap map, @ModelAttribute("doctor") DoctorPOJO pojo, HttpSession session) {
        if (session.getAttribute("name")!=null) {
    		String doctorId = null;
    		ArrayList doctorDetails = null;

    		try {
    			doctorId = doctorService.addDoctorDetails(pojo);
    			doctorDetails = doctorService.fetchDoctorDetails();
    		} catch (ApplicationException ae) {
    			log.info(ae.getMessage());
    			return "ApplicationError";
    		}

    		map.addAttribute("doctorId", doctorId);
    		request.setAttribute("success", "success");
    		request.setAttribute("doctorDetails", doctorDetails);

    		return "ListAllDoctor";
        }
		else {
			map.addAttribute("admin", new AdminPOJO());
			return "Home";
		}
	}

	@RequestMapping("/doctorUpdation")
	public String doctorUpdation(@RequestParam("id") String id, ModelMap map, HttpServletRequest request, HttpSession session) {
        if (session.getAttribute("name")!=null) {
    		DoctorPOJO pojo = null;

    		try {
    			pojo = doctorService.fetchDoctorDetails(id);
    		} catch (ApplicationException ae) {
    			log.info(ae.getMessage());
    			return "ApplicationError";
    		}

    		map.addAttribute("doctor", new DoctorPOJO());
    		request.setAttribute("pojo", pojo);
    		return "UpdateDoctor";
        }
		else {
			map.addAttribute("admin", new AdminPOJO());
			return "Home";
		}

	}

	@RequestMapping("/updateDoctor")
	public String updateDoctor(HttpServletRequest request, @ModelAttribute("doctor") DoctorPOJO pojo, ModelMap map, HttpSession session) {
        if (session.getAttribute("name")!=null) {
    		ArrayList doctorDetails = null;

    		try {
    			doctorDetails = doctorService.fetchDoctorDetails();
    			doctorService.updateDoctorDetails(pojo);
    		} catch (ApplicationException ae) {
    			log.info(ae.getMessage());
    			return "ApplicationError";
    		}

    		request.setAttribute("doctorDetails", doctorDetails);
    		map.addAttribute("doctorId", pojo.getDoctorId());
    		request.setAttribute("update", "update");
    		return "ListAllDoctor";
        }
		else {
			map.addAttribute("admin", new AdminPOJO());
			return "Home";
		}
	}

	@RequestMapping("/viewDoctorDetails")
	public String viewDoctorDetails(@RequestParam("id") String id, ModelMap map, HttpServletRequest request, HttpSession session) {
        if (session.getAttribute("name")!=null) {
    		DoctorPOJO pojo = null;

    		try {
    			pojo = doctorService.fetchDoctorDetails(id);
    		} catch (ApplicationException ae) {
    			log.info(ae.getMessage());
    			return "ApplicationError";
    		}

    		map.addAttribute("doctor", new DoctorPOJO());
    		request.setAttribute("pojo", pojo);
    		return "IDDoctorDetails";
        }
		else {
			map.addAttribute("admin", new AdminPOJO());
			return "Home";
		}
	}

}
