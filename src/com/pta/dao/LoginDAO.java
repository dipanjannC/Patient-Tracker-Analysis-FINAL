package com.pta.dao;

import com.pta.java.ApplicationException;
import com.pta.model.AdminPOJO;

public interface LoginDAO {

	public int validateAdmin(AdminPOJO pojo) throws ApplicationException;

	public String getAdminName(int adminId) throws ApplicationException;
}
