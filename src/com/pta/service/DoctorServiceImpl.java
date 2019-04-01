package com.pta.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pta.dao.ClerkDAO;
import com.pta.dao.DoctorDAO;
import com.pta.dao.DoctorDAOImpl;
import com.pta.entity.DoctorEntity;
import com.pta.java.ApplicationException;
import com.pta.model.DoctorPOJO;

@Service ("doctorService")
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	public DoctorDAO doctorDAO;
	
	
	public  ArrayList fetchDoctorDetails() throws ApplicationException {
		
		//DoctorDAO doctorDAO = new DoctorDAOImpl();
		ArrayList doctorDetails=doctorDAO.fetchDoctorDetails();
		return doctorDetails;
	}
	
	
	public void updateDoctorDetails(DoctorPOJO pojo) throws ApplicationException {
		
		//DoctorDAO doctorDAO = new DoctorDAOImpl();
		doctorDAO.updateDoctorDetails(pojo);
	}


	public String addDoctorDetails(DoctorPOJO pojo) throws ApplicationException {
		
		//DoctorDAO doctorDAO = new DoctorDAOImpl();
		String id=doctorDAO.addDoctorDetails(pojo);
		return id;
	}


	public DoctorPOJO fetchDoctorDetails(String id) throws ApplicationException {
		
		//DoctorDAO doctorDAO = new DoctorDAOImpl();
		DoctorPOJO pojo=doctorDAO.fetchDoctorDetails(id);
		return pojo;
	}
	
/*	public DoctorEntity fetchDoctorDetails(DoctorPOJO pojo) throws ApplicationException {
		DoctorDAO doctorDAO = new DoctorDAOImpl();
		DoctorEntity doctorEntity=doctorDAO.fetchDoctorDetails(pojo);
		return doctorEntity;
	}*/

}
