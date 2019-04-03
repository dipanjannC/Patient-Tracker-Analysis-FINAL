package com.pta.controller;

import java.util.ArrayList;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.pta.java.ApplicationException;
import com.pta.model.AdminPOJO;
import com.pta.model.BillPOJO;
import com.pta.model.PrescriptionPOJO;
import com.pta.service.BillService;
import com.pta.service.PrescriptionService;

@Controller
public class BillController {

	@Autowired
	public PrescriptionService prescriptionService;
	@Autowired
	public BillService billService;
	@Autowired
	public PrescriptionPOJO prescriptionPOJO;

	static Logger log = Logger.getLogger("patient-tracker-analysis");

	@RequestMapping(value = "/listAllBill")
	public String viewBills(HttpServletRequest request, HttpSession session, ModelMap map) {
		if (session.getAttribute("name") != null) {
			ArrayList billDetails = null;
			try {
				billDetails = prescriptionService.fetchPrescriptionDetails();

			} catch (ApplicationException ae) {
				log.info(ae.getMessage());
				return "ApplicationError";
			}
			request.setAttribute("billDetails", billDetails);
			return "ListAllBill";
		} else {
			map.addAttribute("admin", new AdminPOJO());
			return "Home";
		}
	}

	@RequestMapping(value = "/generateBill")
	public String generateBill(@RequestParam("id") String id, ModelMap map, HttpServletRequest request,
			HttpSession session) {
		if (session.getAttribute("name") != null) {
			PrescriptionPOJO pojo = null;
			BillPOJO billDetailsPojo = null;

			try {
				String billId = billService.addBillDetails(id);
				map.addAttribute("billId", billId);
				billDetailsPojo = billService.billDetails(billId);
				request.setAttribute("billDetailsPojo", billDetailsPojo);
			} catch (ApplicationException ae) {
				log.info(ae.getMessage());
				return "ApplicationError";
			}

			return "Bill";
		} else {
			map.addAttribute("admin", new AdminPOJO());
			return "Home";
		}
	}

}