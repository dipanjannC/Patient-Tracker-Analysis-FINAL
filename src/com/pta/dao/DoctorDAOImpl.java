package com.pta.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.pta.entity.ClerkEntity;
import com.pta.entity.DoctorEntity;
import com.pta.entity.PatientEntity;
import com.pta.java.ApplicationException;
import com.pta.model.ClerkPOJO;
import com.pta.model.DoctorPOJO;
import com.pta.model.PatientPOJO;

@Repository("doctorDAO")
public class DoctorDAOImpl implements DoctorDAO {

	public String addDoctorDetails(DoctorPOJO pojo) throws ApplicationException {
		
		StringBuilder builder = new StringBuilder();

		SessionFactory sessionfactory = null;
		Session session = null;
		String id = null;

        try {
    		sessionfactory = HibernateUtil.getSessionFactory();
    		session = sessionfactory.openSession();
    		Transaction transaction = session.beginTransaction();

    		DoctorEntity doctorEntity = new DoctorEntity();
    		doctorEntity.setFirstName(pojo.getFirstName());
    		doctorEntity.setLastName(pojo.getLastName());
    		doctorEntity.setAge(pojo.getAge());
    		doctorEntity.setAddressLine1(pojo.getAddressLine1());
    		doctorEntity.setAddressLine2(pojo.getAddressLine2());

    		if (Long.toString(pojo.getAlternateContactNumber()) != null) {
    			doctorEntity.setAlternateContactNumber(pojo.getAlternateContactNumber());
    		}

    		doctorEntity.setCity((pojo.getCity()));
    		doctorEntity.setContactNumber(pojo.getContactNumber());
    		doctorEntity.setDateOfBirth(pojo.getDateOfBirth());
    		doctorEntity.setEmailId(pojo.getEmailId());
    		doctorEntity.setGender(pojo.getGender());
    		doctorEntity.setState(pojo.getState());
    		doctorEntity.setZipCode(pojo.getZipCode());
    		doctorEntity.setDegree(pojo.getDegree());
    		doctorEntity.setSpeciality(pojo.getSpeciality());
    		doctorEntity.setWorkHours(pojo.getWorkHours());
    		doctorEntity.setHospitalName(pojo.getHospitalName());

    		session.save(doctorEntity);
    		transaction.commit();

    		doctorEntity = session.get(DoctorEntity.class, doctorEntity.getDoctorId());
    		builder.append("DOC");
    		builder.append(Long.toString(doctorEntity.getDoctorId()));
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

	public ArrayList fetchDoctorDetails() throws ApplicationException {
		StringBuilder builder = new StringBuilder();
		ArrayList doctorDetails = null;
		SessionFactory sessionfactory = null;
		Session session = null;

        try {
    		sessionfactory = HibernateUtil.getSessionFactory();
    		session = sessionfactory.openSession();

    		List list = session.createQuery("from DoctorEntity").list();
    		doctorDetails = new ArrayList();
    		for (int i = 0; i < list.size(); i++) {
    			DoctorEntity doctorEntity = (DoctorEntity) list.get(i);
    			DoctorPOJO pojo = new DoctorPOJO();
    			pojo.setAddressLine1(doctorEntity.getAddressLine1());
    			pojo.setAddressLine2(doctorEntity.getAddressLine2());
    			pojo.setAge(doctorEntity.getAge());
    			pojo.setAlternateContactNumber(doctorEntity.getAlternateContactNumber());
    			pojo.setCity(doctorEntity.getCity());

    			builder.append("DOC");
    			builder.append(Long.toString(doctorEntity.getDoctorId()));
    			String id = builder.toString();
    			pojo.setDoctorId(id);
    			builder.setLength(0);

    			pojo.setContactNumber(doctorEntity.getContactNumber());
    			pojo.setDateOfBirth(doctorEntity.getDateOfBirth());
    			pojo.setEmailId(doctorEntity.getEmailId());
    			pojo.setFirstName(doctorEntity.getFirstName());
    			pojo.setGender(doctorEntity.getGender());
    			pojo.setLastName(doctorEntity.getLastName());
    			pojo.setState(doctorEntity.getState());
    			pojo.setZipCode(doctorEntity.getZipCode());
    			pojo.setDegree(doctorEntity.getDegree());
    			pojo.setSpeciality(doctorEntity.getSpeciality());
    			pojo.setWorkHours(doctorEntity.getWorkHours());
    			pojo.setHospitalName(doctorEntity.getHospitalName());
    			doctorDetails.add(pojo);
    		}
    		
		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1,he.getMessage());
			throw ae;
			
		}

	    	finally {
	    		session.close();
	    	}	
        
		return doctorDetails;
	}

	public void updateDoctorDetails(DoctorPOJO pojo) throws ApplicationException {

		SessionFactory sessionfactory = null;
		Session session = null;

        try {
    		sessionfactory = HibernateUtil.getSessionFactory();
    		session = sessionfactory.openSession();
    		Transaction transaction = session.beginTransaction();

    		DoctorEntity doctorEntity = session.get(DoctorEntity.class, Long.parseLong(pojo.getDoctorId().substring(3)));

    		doctorEntity.setFirstName(pojo.getFirstName());
    		doctorEntity.setLastName(pojo.getLastName());
    		doctorEntity.setAge(pojo.getAge());
    		doctorEntity.setAddressLine1(pojo.getAddressLine1());
    		doctorEntity.setAddressLine2(pojo.getAddressLine2());

    		if (Long.toString(pojo.getAlternateContactNumber()) != null) {
    			doctorEntity.setAlternateContactNumber(pojo.getAlternateContactNumber());
    		}

    		doctorEntity.setCity((pojo.getCity()));
    		doctorEntity.setContactNumber(pojo.getContactNumber());
    		doctorEntity.setDateOfBirth(pojo.getDateOfBirth());
    		doctorEntity.setEmailId(pojo.getEmailId());
    		doctorEntity.setGender(pojo.getGender());
    		doctorEntity.setState(pojo.getState());
    		doctorEntity.setZipCode(pojo.getZipCode());
    		doctorEntity.setDegree(pojo.getDegree());
    		doctorEntity.setSpeciality(pojo.getSpeciality());
    		doctorEntity.setWorkHours(pojo.getWorkHours());
    		doctorEntity.setHospitalName(pojo.getHospitalName());

    		transaction.commit();
    		
		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1,he.getMessage());
			throw ae;
			
		}

	    	finally {
	    		session.close();
	    	}	
	}

	public DoctorPOJO fetchDoctorDetails(String id) throws ApplicationException {

		SessionFactory sessionfactory = null;
		Session session = null;
		DoctorPOJO pojo = new DoctorPOJO();

        try {
    		sessionfactory = HibernateUtil.getSessionFactory();
    		session = sessionfactory.openSession();
    		//Transaction transaction = session.beginTransaction();

    		DoctorEntity doctorEntity = new DoctorEntity();
    		doctorEntity = session.get(DoctorEntity.class, Long.parseLong(id.substring(3)));

    		pojo.setContactNumber(doctorEntity.getContactNumber());
    		pojo.setAddressLine1(doctorEntity.getAddressLine1());
    		pojo.setAddressLine2(doctorEntity.getAddressLine2());
    		pojo.setAge(doctorEntity.getAge());
    		pojo.setCity(doctorEntity.getCity());
    		pojo.setAlternateContactNumber(doctorEntity.getAlternateContactNumber());
    		pojo.setDateOfBirth(doctorEntity.getDateOfBirth());
    		pojo.setEmailId(doctorEntity.getEmailId());
    		pojo.setFirstName(doctorEntity.getFirstName());
    		pojo.setGender(doctorEntity.getGender());
    		pojo.setDoctorId(id);
    		pojo.setLastName(doctorEntity.getLastName());
    		pojo.setState(doctorEntity.getState());
    		pojo.setZipCode(doctorEntity.getZipCode());
    		pojo.setDegree(doctorEntity.getDegree());
    		pojo.setSpeciality(doctorEntity.getSpeciality());
    		pojo.setWorkHours(doctorEntity.getWorkHours());
    		pojo.setHospitalName(doctorEntity.getHospitalName());
    		
		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1,he.getMessage());
			throw ae;
			
		}

	    	finally {
	    		session.close();
	    	}	
		
		return pojo;

	}
	
/*	public DoctorEntity fetchDoctorDetails(DoctorPOJO pojo) throws ApplicationException {
		
		SessionFactory sessionfactory = null;
		Session session = null;
		DoctorEntity doctorEntity = new DoctorEntity();
		
        try {
    		sessionfactory = HibernateUtil.getSessionFactory();
    		session = sessionfactory.openSession();
    		//Transaction transaction = session.beginTransaction();
    		
    		doctorEntity = session.get(DoctorEntity.class, Long.parseLong(pojo.getDoctorId().substring(3)));
    		
		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1,he.getMessage());
			throw ae;
			
		}

	    	finally {
	    		session.close();
	    	}	
		
		return doctorEntity;
	}*/

}
