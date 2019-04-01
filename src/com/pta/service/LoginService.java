package com.pta.service;

import com.pta.java.ApplicationException;
import com.pta.model.AdminPOJO;

public interface LoginService {

	public int checkAdmin(AdminPOJO admin) throws ApplicationException;	
	public String getName(int id) throws ApplicationException;
	
}
