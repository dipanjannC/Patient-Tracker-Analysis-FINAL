package com.pta.dao;

import java.util.ArrayList;

import com.pta.java.ApplicationException;
import com.pta.model.ClerkPOJO;

public interface ClerkDAO {

	public String addClerkDetails(ClerkPOJO pojo) throws ApplicationException;

	public ArrayList fetchClerkDetails() throws ApplicationException;

	public void updateClerkDetails(ClerkPOJO pojo) throws ApplicationException;

	public ClerkPOJO fetchClerkDetails(String clerkId) throws ApplicationException;
}
