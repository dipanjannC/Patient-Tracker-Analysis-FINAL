package com.pta.dao;

import com.pta.java.ApplicationException;
import com.pta.model.AdminPOJO;

public interface RegisterDAO {

	public String addAdmin(AdminPOJO admin) throws ApplicationException;
	
}
