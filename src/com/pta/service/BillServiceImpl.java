package com.pta.service;

import org.springframework.stereotype.Service;
import com.pta.dao.BillDAO;
import com.pta.dao.BillDAOImpl;
import com.pta.java.ApplicationException;
import com.pta.model.BillPOJO;

@Service("billService")
public class BillServiceImpl implements BillService {

	public BillPOJO billDetails(String requestId) throws ApplicationException {
		BillDAO billDAO = new BillDAOImpl();
		BillPOJO pojo = billDAO.billDetails(requestId);
		return pojo;
	}

	public String addBillDetails(String requestId) throws ApplicationException {
		BillDAO billDAO = new BillDAOImpl();
		String billId = billDAO.addBillDetails(requestId);
		return billId;
	}

}