package com.pta.dao;

import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.pta.entity.AdminEntity;
import com.pta.java.ApplicationException;
import com.pta.model.AdminPOJO;

@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO {

	public int validateAdmin(AdminPOJO admin) throws ApplicationException {
		int flag = 0;
		SessionFactory sessionfactory = null;
		Session session = null;

		try {
			sessionfactory = HibernateUtil.getSessionFactory();
			session = sessionfactory.openSession();

			AdminEntity adminEntity = new AdminEntity();

			adminEntity.setAdminId(Integer.parseInt(admin.getAdminId()));
			adminEntity.setPassword(admin.getPassword());

			List l1 = (List) session.createQuery("from AdminEntity where Admin_Id='" + adminEntity.getAdminId()
					+ "' and password='" + adminEntity.getPassword() + "'").list();

			Iterator iterator = l1.iterator();

			if (iterator.hasNext()) {
				flag = 1;
			}

			else {
				flag = 0;
			}

		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;

		}

		finally {
			session.close();
		}

		return flag;
	}

	public String getAdminName(int adminId) throws ApplicationException {
		String adminName = null;
		SessionFactory sessionfactory = null;
		Session session = null;
		StringBuilder builder = new StringBuilder();

		try {
			sessionfactory = HibernateUtil.getSessionFactory();
			session = sessionfactory.openSession();

			AdminEntity adminEntity = new AdminEntity();

			adminEntity.setAdminId(adminId);

			List l1 = (List) session.createQuery("from AdminEntity where Admin_Id='" + adminEntity.getAdminId() + "'")
					.list();

			Iterator iterator = l1.iterator();

			if (iterator.hasNext()) {
				AdminEntity adminEntityName = (AdminEntity) l1.get(0);
				builder.append(adminEntityName.getFirstName());
			}

			adminName = builder.toString();

		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;

		}

		finally {
			session.close();
		}

		return adminName;
	}

}
