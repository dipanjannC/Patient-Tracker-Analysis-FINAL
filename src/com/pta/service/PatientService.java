package com.pta.service;

import java.util.ArrayList;
import com.pta.java.ApplicationException;
import com.pta.model.PatientPOJO;

public interface PatientService {

	public String addPatientDetails(PatientPOJO pojo) throws ApplicationException;

	public ArrayList fetchPatientDetails() throws ApplicationException;

	public void updatePatientDetails(PatientPOJO pojo) throws ApplicationException;

	public PatientPOJO fetchPatientDetails(String patientId) throws ApplicationException;
}
