package com.pta.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pta.dao.MedicineDAO;
import com.pta.java.ApplicationException;
import com.pta.model.MedicinePOJO;

@Service("medicineService")
public class MedicineServiceImpl implements MedicineService {

	@Autowired
	public MedicineDAO medicineDAO;
	@Autowired
	public MedicinePOJO medicinePOJO;

	public String addMedicineDetails(MedicinePOJO pojo) throws ApplicationException {
		String id = medicineDAO.addMedicineDetails(pojo);
		return id;
	}

	public ArrayList fetchMedicineDetails() throws ApplicationException {
		ArrayList medicineDetails = medicineDAO.fetchMedicineDetails();
		return medicineDetails;
	}

	public void updateMedicineDetails(MedicinePOJO pojo) throws ApplicationException {
		medicineDAO.updateMedicineDetails(pojo);
	}

	public MedicinePOJO fetchMedicineDetails(String medicineId) throws ApplicationException {
		medicinePOJO = medicineDAO.fetchMedicineDetails(medicineId);
		return medicinePOJO;
	}
}
