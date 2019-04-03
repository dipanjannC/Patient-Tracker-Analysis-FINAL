package com.pta.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.pta.entity.MedicineEntity;
import com.pta.java.ApplicationException;
import com.pta.model.MedicinePOJO;

@Repository("medicineDAO")
public class MedicineDAOImpl implements MedicineDAO {


	public String addMedicineDetails(MedicinePOJO pojo) throws ApplicationException {

		StringBuilder builder = new StringBuilder();

		SessionFactory sessionfactory = null;
		Session session = null;
		String medicineId = null;

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
			medicineId = builder.toString();

		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;

		}

		finally {
			session.close();
		}
		return medicineId;
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
				MedicinePOJO medicinePOJO = new MedicinePOJO();

				builder.append("MED");
				builder.append(Long.toString(medicineEntity.getMedicineId()));
				String id = builder.toString();
				medicinePOJO.setMedicineId(id);
				builder.setLength(0);

				medicinePOJO.setAmount(medicineEntity.getAmount());
				medicinePOJO.setCureFor(medicineEntity.getCureFor());
				medicinePOJO.setDosage(medicineEntity.getDosage());
				medicinePOJO.setManufacturingCompany(medicineEntity.getManufacturingCompany());
				medicinePOJO.setMedicineDescription(medicineEntity.getMedicineDescription());
				medicinePOJO.setPrescribedFor(medicineEntity.getPrescribedFor());
				medicineDetails.add(medicinePOJO);
			}

		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
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
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;

		}

		finally {
			session.close();
		}
	}

	public MedicinePOJO fetchMedicineDetails(String medicineId) throws ApplicationException {

		SessionFactory sessionfactory = null;
		Session session = null;
		MedicinePOJO medicinePOJO = new MedicinePOJO();

		try {
			sessionfactory = HibernateUtil.getSessionFactory();
			session = sessionfactory.openSession();
			Transaction transaction = session.beginTransaction();

			MedicineEntity medicineEntity = new MedicineEntity();
			medicineEntity = session.get(MedicineEntity.class, Long.parseLong(medicineId.substring(3)));

			medicinePOJO.setMedicineId(medicineId);
			medicinePOJO.setAmount(medicineEntity.getAmount());
			medicinePOJO.setCureFor(medicineEntity.getCureFor());
			medicinePOJO.setDosage(medicineEntity.getDosage());
			medicinePOJO.setManufacturingCompany(medicineEntity.getManufacturingCompany());
			medicinePOJO.setMedicineDescription(medicineEntity.getMedicineDescription());
			medicinePOJO.setPrescribedFor(medicineEntity.getPrescribedFor());

		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;

		}

		finally {
			session.close();
		}

		return medicinePOJO;

	}

}
