package com.pta.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.pta.entity.AdminEntity;
import com.pta.java.ApplicationException;
import com.pta.model.AdminPOJO;

@Repository("registerDAO")
public class RegisterDAOImpl implements RegisterDAO {

	public String addAdminDetails(AdminPOJO pojo) throws ApplicationException {

		StringBuilder builder = new StringBuilder();

		SessionFactory sessionfactory = null;
		Session session = null;
		String adminId = null;

		try {
			sessionfactory = HibernateUtil.getSessionFactory();
			session = sessionfactory.openSession();
			Transaction transaction = session.beginTransaction();

			AdminEntity adminEntity = new AdminEntity();

			adminEntity.setFirstName(pojo.getFirstName());
			adminEntity.setLastName(pojo.getLastName());
			adminEntity.setAge(pojo.getAge());
			adminEntity.setGender(pojo.getGender());
			adminEntity.setDateOfBirth(pojo.getDateOfBirth());
			adminEntity.setContactNumber(pojo.getContactNumber());

			if (Long.toString(pojo.getAlternateContactNumber()) != null) {
				adminEntity.setAlternateContactNumber(pojo.getAlternateContactNumber());
			}

			adminEntity.setEmailId(pojo.getEmailId());
			adminEntity.setPassword(pojo.getPassword());

			session.save(adminEntity);
			transaction.commit();

			adminEntity = session.get(AdminEntity.class, adminEntity.getAdminId());
			builder.append("ADN");
			builder.append(Long.toString(adminEntity.getAdminId()));
			adminId = builder.toString();

		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;

		}

		finally {
			session.close();
		}

		return adminId;
	}
}
