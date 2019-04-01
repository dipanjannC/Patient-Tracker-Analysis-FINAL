package com.pta.service;

import com.pta.java.ApplicationException;
import com.pta.model.AdminPOJO;

public interface RegisterService {

	public String addAdmin(AdminPOJO admin) throws ApplicationException;
	
}
