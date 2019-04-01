package com.pta.service;

import java.util.ArrayList;

import com.pta.entity.PatientEntity;
import com.pta.java.ApplicationException;
import com.pta.model.PatientPOJO;
import com.pta.model.PrescriptionPOJO;

public interface PatientService {
	
	public String addPatientDetails(PatientPOJO pojo) throws ApplicationException;
	public  ArrayList fetchPatientDetails() throws ApplicationException;
	public void updatePatientDetails(PatientPOJO pojo) throws ApplicationException;
	public PatientPOJO fetchPatientDetails(String id) throws ApplicationException;
	/*public PatientEntity fetchPatientDetails(PatientPOJO pojo) throws ApplicationException;*/
}
