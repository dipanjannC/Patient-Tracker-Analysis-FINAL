package com.pta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pta.dao.RegisterDAO;
import com.pta.java.ApplicationException;
import com.pta.model.AdminPOJO;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	public RegisterDAO registerDAO;

	public String addAdminDetails(AdminPOJO pojo) throws ApplicationException {
		String adminId = registerDAO.addAdminDetails(pojo);
		return adminId;
	}

}
