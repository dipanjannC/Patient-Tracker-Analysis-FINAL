package com.pta.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pta.dao.MedicineDAO;
import com.pta.dao.MedicineDAOImpl;
import com.pta.entity.MedicineEntity;
import com.pta.java.ApplicationException;
import com.pta.model.MedicinePOJO;

@Service ("medicineService")
public class MedicineServiceImpl implements MedicineService{
	
	@Autowired
	public MedicineDAO medicineDAO;
	@Autowired
    public MedicinePOJO medicinePOJO;
	
	public String addMedicineDetails(MedicinePOJO pojo) throws ApplicationException {
		//MedicineDAO medicineDAO = new MedicineDAOImpl();
		String id=medicineDAO.addMedicineDetails(pojo);
		return id;
	}

	public ArrayList fetchMedicineDetails() throws ApplicationException {
		
		//MedicineDAO medicineDAO = new MedicineDAOImpl();
		ArrayList medicineDetails = medicineDAO.fetchMedicineDetails();
		return medicineDetails;
	}

	public void updateMedicineDetails(MedicinePOJO pojo) throws ApplicationException {
		//MedicineDAO medicineDAO = new MedicineDAOImpl();
		medicineDAO.updateMedicineDetails(pojo);		
	}

	@Override
	public MedicinePOJO fetchMedicineDetails(String id) throws ApplicationException {
		//MedicineDAO medicineDAO = new MedicineDAOImpl();
		medicinePOJO = medicineDAO.fetchMedicineDetails(id);
		return medicinePOJO;
	}
	
/*	public MedicineEntity fetchMedicineDetails(MedicinePOJO pojo) throws ApplicationException {
		MedicineDAO medicineDAO = new MedicineDAOImpl();
		MedicineEntity medicineEntity=medicineDAO.fetchMedicineDetails(pojo);
		return medicineEntity;
	}*/
	

}
