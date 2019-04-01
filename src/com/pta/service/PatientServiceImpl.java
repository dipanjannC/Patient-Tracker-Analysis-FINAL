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

@Service ("patientService")
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	public PatientDAO patientDAO;
	@Autowired
	public PatientPOJO patientPOJO;
	
	public String addPatientDetails(PatientPOJO pojo) throws ApplicationException {
		//PatientDAO patientDAO = new PatientDAOImpl();
		String id= patientDAO.addPatientDetails(pojo);
		return id;
	}
	
	public  ArrayList fetchPatientDetails() throws ApplicationException {
		
		//PatientDAO patientDAO = new PatientDAOImpl();
		ArrayList patientDetails = patientDAO.fetchPatientDetails();
		return patientDetails;
	}
	
	public void updatePatientDetails(PatientPOJO pojo) throws ApplicationException {
		
		//PatientDAO patientDAO = new PatientDAOImpl();
		patientDAO.updatePatientDetails(pojo);
	}


	public PatientPOJO fetchPatientDetails(String id) throws ApplicationException {
		
		//PatientDAO patientDAO = new PatientDAOImpl();
		patientPOJO = patientDAO.fetchPatientDetails(id);
		return patientPOJO;
	}
	
/*	public PatientEntity fetchPatientDetails(PatientPOJO pojo) throws ApplicationException {
		PatientDAO patientDAO = new PatientDAOImpl();
		PatientEntity patientEntity=patientDAO.fetchPatientDetails(pojo);
		return patientEntity;
	}*/
}
