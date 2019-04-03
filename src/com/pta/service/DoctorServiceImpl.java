package com.pta.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pta.dao.DoctorDAO;
import com.pta.java.ApplicationException;
import com.pta.model.DoctorPOJO;

@Service("doctorService")
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	public DoctorDAO doctorDAO;

	public ArrayList fetchDoctorDetails() throws ApplicationException {
		ArrayList doctorDetails = doctorDAO.fetchDoctorDetails();
		return doctorDetails;
	}

	public void updateDoctorDetails(DoctorPOJO pojo) throws ApplicationException {
		doctorDAO.updateDoctorDetails(pojo);
	}

	public String addDoctorDetails(DoctorPOJO pojo) throws ApplicationException {
		String doctorId = doctorDAO.addDoctorDetails(pojo);
		return doctorId;
	}

	public DoctorPOJO fetchDoctorDetails(String doctorId) throws ApplicationException {
		DoctorPOJO pojo = doctorDAO.fetchDoctorDetails(doctorId);
		return pojo;
	}

}
