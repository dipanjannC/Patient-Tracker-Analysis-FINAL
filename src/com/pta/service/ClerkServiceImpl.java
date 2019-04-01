package com.pta.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pta.dao.ClerkDAO;
import com.pta.dao.ClerkDAOImpl;
import com.pta.java.ApplicationException;
import com.pta.model.AdminPOJO;
import com.pta.model.ClerkPOJO;

@Service ("clerkService")
public class ClerkServiceImpl implements ClerkService{
	
	@Autowired
	public ClerkDAO clerkDAO;
	
	public String addClerkDetails(ClerkPOJO pojo) throws ApplicationException {
		//ClerkDAO clerkDAO = new ClerkDAOImpl();
		String id = clerkDAO.addClerkDetails(pojo);
	    return id;
	}
	
	public ArrayList fetchClerkDetails() throws ApplicationException {
		//ClerkDAO clerkDAO = new ClerkDAOImpl();
		ArrayList clerkDetails=clerkDAO.fetchClerkDetails();
		return clerkDetails;
	}
	
	public void updateClerkDetails(ClerkPOJO pojo) throws ApplicationException {
		//ClerkDAO clerkDAO = new ClerkDAOImpl();
		clerkDAO.updateClerkDetails(pojo);		
	}

	@Override
	public ClerkPOJO fetchClerkDetails(String id) throws ApplicationException {
		//ClerkDAO clerkDAO = new ClerkDAOImpl();
		ClerkPOJO pojo=clerkDAO.fetchClerkDetails(id);
		return pojo;
	}
	
}
