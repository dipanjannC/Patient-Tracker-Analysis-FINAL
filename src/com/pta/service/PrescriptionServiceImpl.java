package com.pta.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pta.dao.PrescriptionDAO;
import com.pta.dao.PrescriptionDAOImpl;
import com.pta.java.ApplicationException;
import com.pta.model.PrescriptionPOJO;

@Service ("prescriptionService")
public class PrescriptionServiceImpl implements PrescriptionService{
	
	@Autowired
	public PrescriptionDAO prescriptionDAO;

	public ArrayList getPatientId() throws ApplicationException
	{
		//PrescriptionDAO prescriptionDAO = new PrescriptionDAOImpl();
		ArrayList patientId = prescriptionDAO.getPatientId();
		return patientId;
	}
	
	public ArrayList getDoctorId() throws ApplicationException
	{
		//PrescriptionDAO prescriptionDAO = new PrescriptionDAOImpl();
		ArrayList doctorId = prescriptionDAO.getDoctorId();
		return doctorId;
	}
	
	public ArrayList getMedicinetId() throws ApplicationException
	{
		//PrescriptionDAO prescriptionDAO = new PrescriptionDAOImpl();
		ArrayList medicineId = prescriptionDAO.getMedicineId();
		return medicineId;
	}
	
	public ArrayList fetchPrescriptionDetails() throws ApplicationException {
		
		//PrescriptionDAO clerkDAO = new PrescriptionDAOImpl();
		ArrayList prescriptionDetails = prescriptionDAO.fetchPrescriptionDetails();
		return prescriptionDetails;
	}
	
	public String addPrescriptionDetails(PrescriptionPOJO pojo) throws ApplicationException
	{
		//PrescriptionDAO prescriptionDAO = new PrescriptionDAOImpl();
		String id = prescriptionDAO.addPrescriptionDetails(pojo);
		return id;
	}
	
	public PrescriptionPOJO fetchPrescriptionDetails(String id) throws ApplicationException
	{
		PrescriptionPOJO pojo = prescriptionDAO.fetchPrescriptionDetails(id);
		return pojo;
	}
	
	public void updatePrescriptionDetails(PrescriptionPOJO pojo) throws ApplicationException 
	{
		prescriptionDAO.updatePrescriptionDetails(pojo);
	}
	
}
