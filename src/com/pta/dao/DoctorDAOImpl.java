package com.pta.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.pta.entity.DoctorEntity;
import com.pta.java.ApplicationException;
import com.pta.model.DoctorPOJO;

@Repository("doctorDAO")
public class DoctorDAOImpl implements DoctorDAO {


	public String addDoctorDetails(DoctorPOJO pojo) throws ApplicationException {

		StringBuilder builder = new StringBuilder();

		SessionFactory sessionfactory = null;
		Session session = null;
		String doctorId = null;

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
			doctorId = builder.toString();

		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;

		}

		finally {
			session.close();
		}

		return doctorId;
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

				DoctorPOJO doctorPOJO = new DoctorPOJO();
				doctorPOJO.setAddressLine1(doctorEntity.getAddressLine1());
				doctorPOJO.setAddressLine2(doctorEntity.getAddressLine2());
				doctorPOJO.setAge(doctorEntity.getAge());
				doctorPOJO.setAlternateContactNumber(doctorEntity.getAlternateContactNumber());
				doctorPOJO.setCity(doctorEntity.getCity());

				builder.append("DOC");
				builder.append(Long.toString(doctorEntity.getDoctorId()));
				String id = builder.toString();
				doctorPOJO.setDoctorId(id);
				builder.setLength(0);

				doctorPOJO.setContactNumber(doctorEntity.getContactNumber());
				doctorPOJO.setDateOfBirth(doctorEntity.getDateOfBirth());
				doctorPOJO.setEmailId(doctorEntity.getEmailId());
				doctorPOJO.setFirstName(doctorEntity.getFirstName());
				doctorPOJO.setGender(doctorEntity.getGender());
				doctorPOJO.setLastName(doctorEntity.getLastName());
				doctorPOJO.setState(doctorEntity.getState());
				doctorPOJO.setZipCode(doctorEntity.getZipCode());
				doctorPOJO.setDegree(doctorEntity.getDegree());
				doctorPOJO.setSpeciality(doctorEntity.getSpeciality());
				doctorPOJO.setWorkHours(doctorEntity.getWorkHours());
				doctorPOJO.setHospitalName(doctorEntity.getHospitalName());
				doctorDetails.add(doctorPOJO);
			}

		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
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

			DoctorEntity doctorEntity = session.get(DoctorEntity.class,
					Long.parseLong(pojo.getDoctorId().substring(3)));

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
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;

		}

		finally {
			session.close();
		}
	}

	public DoctorPOJO fetchDoctorDetails(String doctorId) throws ApplicationException {

		SessionFactory sessionfactory = null;
		Session session = null;
		DoctorPOJO doctorPOJO = new DoctorPOJO();

		try {
			sessionfactory = HibernateUtil.getSessionFactory();
			session = sessionfactory.openSession();

			DoctorEntity doctorEntity = new DoctorEntity();
			doctorEntity = session.get(DoctorEntity.class, Long.parseLong(doctorId.substring(3)));

			doctorPOJO.setContactNumber(doctorEntity.getContactNumber());
			doctorPOJO.setAddressLine1(doctorEntity.getAddressLine1());
			doctorPOJO.setAddressLine2(doctorEntity.getAddressLine2());
			doctorPOJO.setAge(doctorEntity.getAge());
			doctorPOJO.setCity(doctorEntity.getCity());
			doctorPOJO.setAlternateContactNumber(doctorEntity.getAlternateContactNumber());
			doctorPOJO.setDateOfBirth(doctorEntity.getDateOfBirth());
			doctorPOJO.setEmailId(doctorEntity.getEmailId());
			doctorPOJO.setFirstName(doctorEntity.getFirstName());
			doctorPOJO.setGender(doctorEntity.getGender());
			doctorPOJO.setDoctorId(doctorId);
			doctorPOJO.setLastName(doctorEntity.getLastName());
			doctorPOJO.setState(doctorEntity.getState());
			doctorPOJO.setZipCode(doctorEntity.getZipCode());
			doctorPOJO.setDegree(doctorEntity.getDegree());
			doctorPOJO.setSpeciality(doctorEntity.getSpeciality());
			doctorPOJO.setWorkHours(doctorEntity.getWorkHours());
			doctorPOJO.setHospitalName(doctorEntity.getHospitalName());

		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;

		}

		finally {
			session.close();
		}

		return doctorPOJO;

	}

}
