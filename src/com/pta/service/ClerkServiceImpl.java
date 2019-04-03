package com.pta.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pta.dao.ClerkDAO;
import com.pta.java.ApplicationException;
import com.pta.model.ClerkPOJO;

@Service("clerkService")
public class ClerkServiceImpl implements ClerkService {

	@Autowired
	public ClerkDAO clerkDAO;

	public String addClerkDetails(ClerkPOJO pojo) throws ApplicationException {
		String clerkId = clerkDAO.addClerkDetails(pojo);
		return clerkId;
	}

	public ArrayList fetchClerkDetails() throws ApplicationException {
		ArrayList clerkDetails = clerkDAO.fetchClerkDetails();
		return clerkDetails;
	}

	public void updateClerkDetails(ClerkPOJO pojo) throws ApplicationException {
		clerkDAO.updateClerkDetails(pojo);
	}

	public ClerkPOJO fetchClerkDetails(String clerkId) throws ApplicationException {
		ClerkPOJO pojo = clerkDAO.fetchClerkDetails(clerkId);
		return pojo;
	}

}
