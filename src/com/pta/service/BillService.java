package com.pta.service;

import com.pta.java.ApplicationException;
import com.pta.model.BillPOJO;

public interface BillService {

	public BillPOJO billDetails(String requestId) throws ApplicationException;

	public String addBillDetails(String requestId) throws ApplicationException;
}