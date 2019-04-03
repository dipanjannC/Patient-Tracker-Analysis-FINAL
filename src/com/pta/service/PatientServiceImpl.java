package com.pta.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pta.dao.PatientDAO;
import com.pta.dao.PatientDAOImpl;
import com.pta.entity.PatientEntity;
import com.pta.java.ApplicationException;
import com.pta.model.PatientPOJO;
import com.pta.model.PrescriptionPOJO;

@Service("patientService")
public class PatientServiceImpl implements PatientService {

	@Autowired
	public PatientDAO patientDAO;
	@Autowired
	public PatientPOJO patientPOJO;

	public String addPatientDetails(PatientPOJO pojo) throws ApplicationException {
		String id = patientDAO.addPatientDetails(pojo);
		return id;
	}

	public ArrayList fetchPatientDetails() throws ApplicationException {
		ArrayList patientDetails = patientDAO.fetchPatientDetails();
		return patientDetails;
	}

	public void updatePatientDetails(PatientPOJO pojo) throws ApplicationException {
		patientDAO.updatePatientDetails(pojo);
	}

	public PatientPOJO fetchPatientDetails(String patientId) throws ApplicationException {
		patientPOJO = patientDAO.fetchPatientDetails(patientId);
		return patientPOJO;
	}
}
