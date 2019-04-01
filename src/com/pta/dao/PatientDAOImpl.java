package com.pta.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.pta.entity.PatientEntity;
import com.pta.java.ApplicationException;
import com.pta.model.PatientPOJO;
import com.pta.model.PrescriptionPOJO;

@Repository("patientDAO")
public class PatientDAOImpl implements PatientDAO {

	public String addPatientDetails(PatientPOJO pojo) throws ApplicationException {

		StringBuilder builder = new StringBuilder();

		SessionFactory sessionfactory = null;
		Session session = null;
		String id = null;

		try {
			sessionfactory = HibernateUtil.getSessionFactory();
			session = sessionfactory.openSession();
			Transaction transaction = session.beginTransaction();

			PatientEntity patientEntity = new PatientEntity();
			patientEntity.setFirstName(pojo.getFirstName());
			patientEntity.setLastName(pojo.getLastName());
			patientEntity.setAge(pojo.getAge());
			patientEntity.setAddressLine1(pojo.getAddressLine1());
			patientEntity.setAddressLine2(pojo.getAddressLine2());

			if (Long.toString(pojo.getAlternateContactNumber()) != null) {
				patientEntity.setAlternateContactNumber(pojo.getAlternateContactNumber());
			}

			patientEntity.setCity((pojo.getCity()));
			patientEntity.setContactNumber(pojo.getContactNumber());
			patientEntity.setDateOfBirth(pojo.getDateOfBirth());
			patientEntity.setEmailId(pojo.getEmailId());
			patientEntity.setGender(pojo.getGender());
			patientEntity.setState(pojo.getState());
			patientEntity.setZipCode(pojo.getZipCode());

			session.save(patientEntity);
			transaction.commit();

			patientEntity = session.get(PatientEntity.class, patientEntity.getPatientId());
			builder.append("PAT");
			builder.append(Long.toString(patientEntity.getPatientId()));
			id = builder.toString();

		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;

		}

		finally {
			session.close();
		}

		return id;
	}

	public ArrayList fetchPatientDetails() throws ApplicationException {
		StringBuilder builder = new StringBuilder();

		ArrayList patientDetails = null;
		SessionFactory sessionfactory = null;
		Session session = null;

		try {
			sessionfactory = HibernateUtil.getSessionFactory();
			session = sessionfactory.openSession();

			List list = session.createQuery("from PatientEntity").list();
			patientDetails = new ArrayList();
			for (int i = 0; i < list.size(); i++) {
				PatientEntity patientEntity = (PatientEntity) list.get(i);
				PatientPOJO pojo = new PatientPOJO();
				pojo.setAddressLine1(patientEntity.getAddressLine1());
				pojo.setAddressLine2(patientEntity.getAddressLine2());
				pojo.setAge(patientEntity.getAge());
				pojo.setAlternateContactNumber(patientEntity.getAlternateContactNumber());
				pojo.setCity(patientEntity.getCity());

				builder.append("PAT");
				builder.append(Long.toString(patientEntity.getPatientId()));
				String id = builder.toString();
				pojo.setPatientId(id);
				builder.setLength(0);

				pojo.setContactNumber(patientEntity.getContactNumber());
				pojo.setDateOfBirth(patientEntity.getDateOfBirth());
				pojo.setEmailId(patientEntity.getEmailId());
				pojo.setFirstName(patientEntity.getFirstName());
				pojo.setGender(patientEntity.getGender());
				pojo.setLastName(patientEntity.getLastName());
				pojo.setState(patientEntity.getState());
				pojo.setZipCode(patientEntity.getZipCode());
				patientDetails.add(pojo);
			}

		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;

		}

		finally {
			session.close();
		}

		return patientDetails;
	}

	public void updatePatientDetails(PatientPOJO pojo) throws ApplicationException {

		SessionFactory sessionfactory = null;
		Session session = null;

		try {
			sessionfactory = HibernateUtil.getSessionFactory();
			session = sessionfactory.openSession();
			Transaction transaction = session.beginTransaction();

			PatientEntity patientEntity = session.get(PatientEntity.class,
					Long.parseLong(pojo.getPatientId().substring(3)));
			patientEntity.setFirstName(pojo.getFirstName());
			patientEntity.setLastName(pojo.getLastName());
			patientEntity.setAge(pojo.getAge());
			patientEntity.setAddressLine1(pojo.getAddressLine1());
			patientEntity.setAddressLine2(pojo.getAddressLine2());

			if (Long.toString(pojo.getAlternateContactNumber()) != null) {
				patientEntity.setAlternateContactNumber(pojo.getAlternateContactNumber());
			}

			patientEntity.setCity((pojo.getCity()));
			patientEntity.setContactNumber(pojo.getContactNumber());
			patientEntity.setDateOfBirth(pojo.getDateOfBirth());
			patientEntity.setEmailId(pojo.getEmailId());
			patientEntity.setGender(pojo.getGender());
			patientEntity.setState(pojo.getState());
			patientEntity.setZipCode(pojo.getZipCode());

			transaction.commit();

		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;

		}

		finally {
			session.close();
		}
	}

	public PatientPOJO fetchPatientDetails(String id) throws ApplicationException {

		SessionFactory sessionfactory = null;
		Session session = null;
		PatientPOJO pojo = new PatientPOJO();

        try {
    		sessionfactory = HibernateUtil.getSessionFactory();
    		session = sessionfactory.openSession();
    		// Transaction transaction = session.beginTransaction();

    		PatientEntity patientEntity = new PatientEntity();
    		patientEntity = session.get(PatientEntity.class, Long.parseLong(id.substring(3)));

    		pojo.setAddressLine1(patientEntity.getAddressLine1());
    		pojo.setAddressLine2(patientEntity.getAddressLine2());
    		pojo.setAge(patientEntity.getAge());
    		pojo.setAlternateContactNumber(patientEntity.getAlternateContactNumber());
    		pojo.setCity(patientEntity.getCity());
    		pojo.setPatientId(id);
    		pojo.setContactNumber(patientEntity.getContactNumber());
    		pojo.setDateOfBirth(patientEntity.getDateOfBirth());
    		pojo.setEmailId(patientEntity.getEmailId());
    		pojo.setFirstName(patientEntity.getFirstName());
    		pojo.setGender(patientEntity.getGender());
    		pojo.setLastName(patientEntity.getLastName());
    		pojo.setState(patientEntity.getState());
    		pojo.setZipCode(patientEntity.getZipCode());
    		
		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;

		}

		finally {
			session.close();
		}
		
		return pojo;
	}

/*	public PatientEntity fetchPatientDetails(PatientPOJO pojo) throws ApplicationException {

		SessionFactory sessionfactory = null;
		Session session = null;
		PatientEntity patientEntity = new PatientEntity();

        try {
    		sessionfactory = HibernateUtil.getSessionFactory();
    		session = sessionfactory.openSession();
    		// Transaction transaction = session.beginTransaction();

    		patientEntity = session.get(PatientEntity.class, Long.parseLong(pojo.getPatientId().substring(3)));
    		
		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;

		}

		finally {
			session.close();
		}
        
		return patientEntity;
	}*/

}
