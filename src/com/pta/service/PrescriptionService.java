package com.pta.service;

import java.util.ArrayList;

import com.pta.java.ApplicationException;
import com.pta.model.PrescriptionPOJO;

public interface PrescriptionService {

	public ArrayList getPatientIds() throws ApplicationException;

	public ArrayList getDoctorIds() throws ApplicationException;

	public ArrayList getMedicinetIds() throws ApplicationException;

	public String addPrescriptionDetails(PrescriptionPOJO pojo) throws ApplicationException;

	public ArrayList fetchPrescriptionDetails() throws ApplicationException;

	public PrescriptionPOJO fetchPrescriptionDetails(String prescriptionId) throws ApplicationException;

	public void updatePrescriptionDetails(PrescriptionPOJO pojo) throws ApplicationException;
}