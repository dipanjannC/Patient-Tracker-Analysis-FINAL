package com.pta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pta.dao.LoginDAO;
import com.pta.java.ApplicationException;
import com.pta.model.AdminPOJO;

@Service ("loginService")
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	public LoginDAO loginDAO;

	public int checkAdmin(AdminPOJO admin) throws ApplicationException
	{
		//LoginDao validateAdmin = new LoginDaoImpl();
		int check = loginDAO.checkAdmin(admin);
		return check;
	}
	
	public String getName(int id) throws ApplicationException
	{
		//LoginDao userName = new LoginDaoImpl();
		String name = loginDAO.getName(id);
		return name;
	}
	
}
