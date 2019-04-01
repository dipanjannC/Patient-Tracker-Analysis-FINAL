package com.pta.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.pta.entity.DoctorEntity;
import com.pta.entity.MedicineEntity;
import com.pta.entity.PatientEntity;
import com.pta.java.ApplicationException;
import com.pta.model.MedicinePOJO;
import com.pta.model.PatientPOJO;

@Repository("medicineDAO")
public class MedicineDAOImpl implements MedicineDAO {
	
	public String addMedicineDetails(MedicinePOJO pojo) throws ApplicationException {

		StringBuilder builder = new StringBuilder();

		SessionFactory sessionfactory = null;
		Session session = null;
		String id = null;

        try {
    		sessionfactory = HibernateUtil.getSessionFactory();
    		session = sessionfactory.openSession();
    		Transaction transaction = session.beginTransaction();

    		MedicineEntity medicineEntity = new MedicineEntity();
    		medicineEntity.setAmount(pojo.getAmount());
    		medicineEntity.setCureFor(pojo.getCureFor());
    		medicineEntity.setDosage(pojo.getDosage());
    		medicineEntity.setManufacturingCompany(pojo.getManufacturingCompany());
    		medicineEntity.setMedicineDescription(pojo.getMedicineDescription());
    		medicineEntity.setPrescribedFor(pojo.getPrescribedFor());

    		session.save(medicineEntity);
    		transaction.commit();

    		medicineEntity = session.get(MedicineEntity.class, medicineEntity.getMedicineId());
    		builder.append("MED");
    		builder.append(Long.toString(medicineEntity.getMedicineId()));
    		id = builder.toString();
    		
		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1,he.getMessage());
			throw ae;
			
		}

	    	finally {
	    		session.close();
	    	}		
		return id;
	}
	
	
	

	public ArrayList fetchMedicineDetails() throws ApplicationException {
		StringBuilder builder = new StringBuilder();

		ArrayList medicineDetails = null;
		SessionFactory sessionfactory = null;
		Session session = null;

        try {
    		sessionfactory = HibernateUtil.getSessionFactory();
    		session = sessionfactory.openSession();

    		List list = session.createQuery("from MedicineEntity").list();
    		medicineDetails = new ArrayList();
    		for (int i = 0; i < list.size(); i++) {

    			MedicineEntity medicineEntity = (MedicineEntity) list.get(i);
    			MedicinePOJO pojo = new MedicinePOJO();

    			builder.append("MED");
    			builder.append(Long.toString(medicineEntity.getMedicineId()));
    			String id = builder.toString();
    			pojo.setMedicineId(id);
    			builder.setLength(0);

    			pojo.setAmount(medicineEntity.getAmount());
    			pojo.setCureFor(medicineEntity.getCureFor());
    			pojo.setDosage(medicineEntity.getDosage());
    			pojo.setManufacturingCompany(medicineEntity.getManufacturingCompany());
    			pojo.setMedicineDescription(medicineEntity.getMedicineDescription());
    			pojo.setPrescribedFor(medicineEntity.getPrescribedFor());
    			medicineDetails.add(pojo);
    		}
    		
		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1,he.getMessage());
			throw ae;
			
		}

	    	finally {
	    		session.close();
	    	}	
		
		return medicineDetails;
	}

	public void updateMedicineDetails(MedicinePOJO pojo) throws ApplicationException {

		SessionFactory sessionfactory = null;
		Session session = null;

        try {
    		sessionfactory = HibernateUtil.getSessionFactory();
    		session = sessionfactory.openSession();
    		Transaction transaction = session.beginTransaction();

    		MedicineEntity medicineEntity = session.get(MedicineEntity.class,
    				Long.parseLong(pojo.getMedicineId().substring(3)));
    		medicineEntity.setAmount(pojo.getAmount());
    		medicineEntity.setCureFor(pojo.getCureFor());
    		medicineEntity.setDosage(pojo.getDosage());
    		medicineEntity.setManufacturingCompany(pojo.getManufacturingCompany());
    		medicineEntity.setMedicineDescription(pojo.getMedicineDescription());
    		medicineEntity.setPrescribedFor(pojo.getPrescribedFor());

    		transaction.commit();
    		
		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1,he.getMessage());
			throw ae;
			
		}

	    	finally {
	    		session.close();
	    	}	
	}

	public MedicinePOJO fetchMedicineDetails(String id) throws ApplicationException {

		SessionFactory sessionfactory = null;
		Session session = null;
		MedicinePOJO pojo = new MedicinePOJO();

        try {
    		sessionfactory = HibernateUtil.getSessionFactory();
    		session = sessionfactory.openSession();
    		Transaction transaction = session.beginTransaction();

    		MedicineEntity medicineEntity = new MedicineEntity();
    		medicineEntity = session.get(MedicineEntity.class, Long.parseLong(id.substring(3)));
    		System.out.println( Long.parseLong(id.substring(3)));

    		pojo.setMedicineId(id);
    		pojo.setAmount(medicineEntity.getAmount());
    		pojo.setCureFor(medicineEntity.getCureFor());
    		pojo.setDosage(medicineEntity.getDosage());
    		pojo.setManufacturingCompany(medicineEntity.getManufacturingCompany());
    		pojo.setMedicineDescription(medicineEntity.getMedicineDescription());
    		pojo.setPrescribedFor(medicineEntity.getPrescribedFor());
    		
		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1,he.getMessage());
			throw ae;
			
		}

	    	finally {
	    		session.close();
	    	}

		return pojo;

	}
	
/*	public MedicineEntity fetchMedicineDetails(MedicinePOJO pojo) throws ApplicationException {
		
		SessionFactory sessionfactory = null;
		Session session = null;
		MedicineEntity medicineEntity = new MedicineEntity();
		
        try {
    		sessionfactory = HibernateUtil.getSessionFactory();
    		session = sessionfactory.openSession();
    		//Transaction transaction = session.beginTransaction();
    		
    		medicineEntity = session.get(MedicineEntity.class, Long.parseLong(pojo.getMedicineId().substring(3)));
        
		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1,he.getMessage());
			throw ae;
			
		}

	    	finally {
	    		session.close();
	    	}
        
		return medicineEntity;
	}*/
}
