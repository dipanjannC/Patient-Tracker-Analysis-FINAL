package com.pta.service;

import com.pta.java.ApplicationException;
import com.pta.model.AdminPOJO;

public interface LoginService {

	public int validateAdmin(AdminPOJO pojo) throws ApplicationException;

	public String getAdminName(int adminId) throws ApplicationException;

}
