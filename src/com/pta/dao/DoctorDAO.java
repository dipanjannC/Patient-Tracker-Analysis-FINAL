package com.pta.dao;

import java.util.ArrayList;
import com.pta.java.ApplicationException;
import com.pta.model.DoctorPOJO;

public interface DoctorDAO {

	public String addDoctorDetails(DoctorPOJO pojo) throws ApplicationException;

	public ArrayList fetchDoctorDetails() throws ApplicationException;

	public void updateDoctorDetails(DoctorPOJO pojo) throws ApplicationException;

	public DoctorPOJO fetchDoctorDetails(String doctorId) throws ApplicationException;
}
