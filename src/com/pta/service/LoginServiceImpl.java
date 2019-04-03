package com.pta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pta.dao.LoginDAO;
import com.pta.java.ApplicationException;
import com.pta.model.AdminPOJO;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	public LoginDAO loginDAO;

	public int validateAdmin(AdminPOJO admin) throws ApplicationException {
		int check = loginDAO.validateAdmin(admin);
		return check;
	}

	public String getAdminName(int adminId) throws ApplicationException {
		String name = loginDAO.getAdminName(adminId);
		return name;
	}

}
