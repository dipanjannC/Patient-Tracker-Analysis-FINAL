package com.pta.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.pta.entity.PatientEntity;
import com.pta.java.ApplicationException;
import com.pta.model.PatientPOJO;

@Repository("patientDAO")
public class PatientDAOImpl implements PatientDAO {


	public String addPatientDetails(PatientPOJO pojo) throws ApplicationException {

		StringBuilder builder = new StringBuilder();

		SessionFactory sessionfactory = null;
		Session session = null;
		String patientId = null;

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
			patientId = builder.toString();

		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;

		}

		finally {
			session.close();
		}

		return patientId;
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
				
                PatientPOJO patientPOJO = new PatientPOJO();
				patientPOJO.setAddressLine1(patientEntity.getAddressLine1());
				patientPOJO.setAddressLine2(patientEntity.getAddressLine2());
				patientPOJO.setAge(patientEntity.getAge());
				patientPOJO.setAlternateContactNumber(patientEntity.getAlternateContactNumber());
				patientPOJO.setCity(patientEntity.getCity());

				builder.append("PAT");
				builder.append(Long.toString(patientEntity.getPatientId()));
				String id = builder.toString();
				patientPOJO.setPatientId(id);
				builder.setLength(0);

				patientPOJO.setContactNumber(patientEntity.getContactNumber());
				patientPOJO.setDateOfBirth(patientEntity.getDateOfBirth());
				patientPOJO.setEmailId(patientEntity.getEmailId());
				patientPOJO.setFirstName(patientEntity.getFirstName());
				patientPOJO.setGender(patientEntity.getGender());
				patientPOJO.setLastName(patientEntity.getLastName());
				patientPOJO.setState(patientEntity.getState());
				patientPOJO.setZipCode(patientEntity.getZipCode());
				patientDetails.add(patientPOJO);
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

	public PatientPOJO fetchPatientDetails(String patientId) throws ApplicationException {

		SessionFactory sessionfactory = null;
		Session session = null;
		PatientPOJO patientPOJO = new PatientPOJO();

		try {
			sessionfactory = HibernateUtil.getSessionFactory();
			session = sessionfactory.openSession();

			PatientEntity patientEntity = new PatientEntity();
			patientEntity = session.get(PatientEntity.class, Long.parseLong(patientId.substring(3)));

			patientPOJO.setAddressLine1(patientEntity.getAddressLine1());
			patientPOJO.setAddressLine2(patientEntity.getAddressLine2());
			patientPOJO.setAge(patientEntity.getAge());
			patientPOJO.setAlternateContactNumber(patientEntity.getAlternateContactNumber());
			patientPOJO.setCity(patientEntity.getCity());
			patientPOJO.setPatientId(patientId);
			patientPOJO.setContactNumber(patientEntity.getContactNumber());
			patientPOJO.setDateOfBirth(patientEntity.getDateOfBirth());
			patientPOJO.setEmailId(patientEntity.getEmailId());
			patientPOJO.setFirstName(patientEntity.getFirstName());
			patientPOJO.setGender(patientEntity.getGender());
			patientPOJO.setLastName(patientEntity.getLastName());
			patientPOJO.setState(patientEntity.getState());
			patientPOJO.setZipCode(patientEntity.getZipCode());

		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;

		}

		finally {
			session.close();
		}

		return patientPOJO;
	}

}
