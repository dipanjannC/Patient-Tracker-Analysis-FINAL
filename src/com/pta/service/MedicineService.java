package com.pta.service;

import java.util.ArrayList;
import com.pta.java.ApplicationException;
import com.pta.model.MedicinePOJO;

public interface MedicineService {
	public String addMedicineDetails(MedicinePOJO pojo) throws ApplicationException;

	public ArrayList fetchMedicineDetails() throws ApplicationException;

	public void updateMedicineDetails(MedicinePOJO pojo) throws ApplicationException;

	public MedicinePOJO fetchMedicineDetails(String medicineId) throws ApplicationException;

}
