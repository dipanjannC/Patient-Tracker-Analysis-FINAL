package com.pta.service;

import java.util.ArrayList;

import com.pta.java.ApplicationException;
import com.pta.model.PrescriptionPOJO;

public interface PrescriptionService {

	public ArrayList getPatientId() throws ApplicationException;
	public ArrayList getDoctorId() throws ApplicationException;
	public ArrayList getMedicinetId() throws ApplicationException;
	public String addPrescriptionDetails(PrescriptionPOJO pojo) throws ApplicationException;
	public ArrayList fetchPrescriptionDetails() throws ApplicationException;
	public PrescriptionPOJO fetchPrescriptionDetails(String id) throws ApplicationException;
	public void updatePrescriptionDetails(PrescriptionPOJO pojo) throws ApplicationException;
}