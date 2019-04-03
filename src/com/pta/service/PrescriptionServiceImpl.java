package com.pta.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pta.dao.PrescriptionDAO;
import com.pta.java.ApplicationException;
import com.pta.model.PrescriptionPOJO;

@Service("prescriptionService")
public class PrescriptionServiceImpl implements PrescriptionService {

	@Autowired
	public PrescriptionDAO prescriptionDAO;

	public ArrayList getPatientIds() throws ApplicationException {
		ArrayList patientIds = prescriptionDAO.getPatientIds();
		return patientIds;
	}

	public ArrayList getDoctorIds() throws ApplicationException {
		ArrayList doctorIds = prescriptionDAO.getDoctorIds();
		return doctorIds;
	}

	public ArrayList getMedicinetIds() throws ApplicationException {
		;
		ArrayList medicineIds = prescriptionDAO.getMedicineIds();
		return medicineIds;
	}

	public ArrayList fetchPrescriptionDetails() throws ApplicationException {
		ArrayList prescriptionDetails = prescriptionDAO.fetchPrescriptionDetails();
		return prescriptionDetails;
	}

	public String addPrescriptionDetails(PrescriptionPOJO pojo) throws ApplicationException {
		String id = prescriptionDAO.addPrescriptionDetails(pojo);
		return id;
	}

	public PrescriptionPOJO fetchPrescriptionDetails(String prescriptionId) throws ApplicationException {
		PrescriptionPOJO pojo = prescriptionDAO.fetchPrescriptionDetails(prescriptionId);
		return pojo;
	}

	public void updatePrescriptionDetails(PrescriptionPOJO pojo) throws ApplicationException {
		prescriptionDAO.updatePrescriptionDetails(pojo);
	}

}
