package com.pta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pta.dao.LoginDAO;
import com.pta.dao.LoginDAOImpl;
import com.pta.dao.RegisterDAO;
import com.pta.dao.RegisterDAOImpl;
import com.pta.java.ApplicationException;
import com.pta.model.AdminPOJO;

@Service ("registerService")
public class RegisterServiceImpl implements RegisterService{
	
	@Autowired
	public RegisterDAO registerDAO; 

	public String addAdmin(AdminPOJO admin) throws ApplicationException
	{
			//RegisterDao newAdmin = new RegisterDaoImpl();
			String id = registerDAO.addAdmin(admin);
			return id;
	}
	
}
