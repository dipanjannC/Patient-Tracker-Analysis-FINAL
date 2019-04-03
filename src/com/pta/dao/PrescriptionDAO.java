package com.pta.dao;

import java.util.ArrayList;

import com.pta.java.ApplicationException;
import com.pta.model.PrescriptionPOJO;

public interface PrescriptionDAO {

	public ArrayList getPatientIds() throws ApplicationException;
	public ArrayList getDoctorIds() throws ApplicationException;
	public ArrayList getMedicineIds() throws ApplicationException;
	public String addPrescriptionDetails(PrescriptionPOJO pojo) throws ApplicationException;
	public  ArrayList fetchPrescriptionDetails() throws ApplicationException;
	public PrescriptionPOJO fetchPrescriptionDetails(String prescriptionId) throws ApplicationException;
	public void updatePrescriptionDetails(PrescriptionPOJO pojo) throws ApplicationException;
}