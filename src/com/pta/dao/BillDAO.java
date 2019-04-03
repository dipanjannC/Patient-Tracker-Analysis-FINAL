package com.pta.dao;

import com.pta.java.ApplicationException;
import com.pta.model.BillPOJO;

public interface BillDAO {

	public BillPOJO billDetails(String requestId) throws ApplicationException;

	public String addBillDetails(String requestId) throws ApplicationException;
}