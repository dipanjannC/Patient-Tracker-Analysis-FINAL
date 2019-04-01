package com.pta.dao;
import com.pta.java.ApplicationException;
import com.pta.model.AdminPOJO;

public interface LoginDAO 
{

	public int checkAdmin(AdminPOJO admin) throws ApplicationException;
	public String getName(int id) throws ApplicationException;
}
