package com.pta.service;

import java.util.ArrayList;

import com.pta.entity.MedicineEntity;
import com.pta.java.ApplicationException;
import com.pta.model.MedicinePOJO;

public interface MedicineService {
	public String addMedicineDetails(MedicinePOJO pojo) throws ApplicationException;
	public ArrayList fetchMedicineDetails() throws ApplicationException;
	public void updateMedicineDetails(MedicinePOJO pojo) throws ApplicationException;
	public MedicinePOJO fetchMedicineDetails(String id) throws ApplicationException;
	/*public MedicineEntity fetchMedicineDetails(MedicinePOJO pojo) throws ApplicationException;*/

}
