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
import com.pta.entity.MedicineEntity;
import com.pta.entity.PatientEntity;
import com.pta.entity.PrescriptionEntity;
import com.pta.java.ApplicationException;
import com.pta.model.DoctorPOJO;
import com.pta.model.MedicinePOJO;
import com.pta.model.PatientPOJO;
import com.pta.model.PrescriptionPOJO;

@Repository("prescriptionDAO")
public class PrescriptionDAOImpl implements PrescriptionDAO {


	public ArrayList getPatientIds() throws ApplicationException {
		ArrayList patientIds = null;
		SessionFactory sessionfactory = null;
		Session session = null;
		StringBuilder builder = new StringBuilder();

		try {
			sessionfactory = HibernateUtil.getSessionFactory();
			session = sessionfactory.openSession();

			List list = session.createQuery("from PatientEntity").list();
			patientIds = new ArrayList();
			for (int i = 0; i < list.size(); i++) {
				PatientEntity patientEntity = (PatientEntity) list.get(i);
				
				PatientPOJO patientPOJO = new PatientPOJO();
				builder.append("PAT");
				builder.append(Long.toString(patientEntity.getPatientId()));
				String patientId = builder.toString();
				patientPOJO.setPatientId(patientId);
				builder.setLength(0);
				patientIds.add(patientPOJO);
			}

		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;

		}

		finally {
			session.close();
		}

		return patientIds;
	}

	public ArrayList getDoctorIds() throws ApplicationException {
		ArrayList doctorIds = null;
		SessionFactory sessionfactory = null;
		Session session = null;
		StringBuilder builder = new StringBuilder();

		try {
			sessionfactory = HibernateUtil.getSessionFactory();
			session = sessionfactory.openSession();

			List list = session.createQuery("from DoctorEntity").list();
			doctorIds = new ArrayList();
			for (int i = 0; i < list.size(); i++) {
				DoctorEntity doctorEntity = (DoctorEntity) list.get(i);

				DoctorPOJO doctorPOJO = new DoctorPOJO();
				builder.append("DOC");
				builder.append(Long.toString(doctorEntity.getDoctorId()));
				String doctorId = builder.toString();
				doctorPOJO.setDoctorId(doctorId);
				builder.setLength(0);
				doctorIds.add(doctorPOJO);
			}

		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;

		}

		finally {
			session.close();
		}

		return doctorIds;

	}

	public ArrayList getMedicineIds() throws ApplicationException {
		ArrayList medicineIds = null;
		SessionFactory sessionfactory = null;
		Session session = null;
		StringBuilder builder = new StringBuilder();

		try {
			sessionfactory = HibernateUtil.getSessionFactory();
			session = sessionfactory.openSession();

			List list = session.createQuery("from MedicineEntity").list();
			medicineIds = new ArrayList();
			for (int i = 0; i < list.size(); i++) {
				MedicineEntity medicineEntity = (MedicineEntity) list.get(i);

				MedicinePOJO medicinePOJO = new MedicinePOJO();
				builder.append("MED");
				builder.append(Long.toString(medicineEntity.getMedicineId()));
				String medicineId = builder.toString();
				medicinePOJO.setMedicineId(medicineId);
				builder.setLength(0);
				medicineIds.add(medicinePOJO);
			}

		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;

		}

		finally {
			session.close();
		}

		return medicineIds;

	}

	public ArrayList fetchPrescriptionDetails() throws ApplicationException {
		StringBuilder builder = new StringBuilder();

		ArrayList prescriptionDetails = null;
		SessionFactory sessionfactory = null;
		Session session = null;

		try {
			sessionfactory = HibernateUtil.getSessionFactory();
			session = sessionfactory.openSession();

			List list = session.createQuery("from PrescriptionEntity").list();
			prescriptionDetails = new ArrayList();
			for (int i = 0; i < list.size(); i++) {
				PrescriptionEntity prescriptionEntity = (PrescriptionEntity) list.get(i);

				PrescriptionPOJO prescriptionPOJO = new PrescriptionPOJO();
				builder.append("REQ");
				builder.append(Long.toString(prescriptionEntity.getRequestId()));
				String requestId = builder.toString();
				prescriptionPOJO.setRequestId(requestId);
				builder.setLength(0);
				prescriptionPOJO.setPatientId(Long.toString(prescriptionEntity.getPatientEntity().getPatientId()));
				prescriptionPOJO.setDoctorId(Long.toString(prescriptionEntity.getDoctorEntity().getDoctorId()));
				prescriptionPOJO.setRequestDate(prescriptionEntity.getRequestDate());
				prescriptionDetails.add(prescriptionPOJO);

			}

		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;

		}

		finally {
			session.close();
		}

		return prescriptionDetails;
	}

	public String addPrescriptionDetails(PrescriptionPOJO pojo) throws ApplicationException {
		StringBuilder builder = new StringBuilder();

		SessionFactory sessionfactory = null;
		Session session = null;
		String id = null;

		try {
			sessionfactory = HibernateUtil.getSessionFactory();
			session = sessionfactory.openSession();
			Transaction transaction = session.beginTransaction();

			PrescriptionEntity prescriptionEntity = new PrescriptionEntity();

			PatientEntity patientEntity = new PatientEntity();
			patientEntity = session.get(PatientEntity.class, Long.parseLong(pojo.getPatientId().substring(3)));
			prescriptionEntity.setPatientEntity(patientEntity);

			DoctorEntity doctorEntity = new DoctorEntity();
			doctorEntity = session.get(DoctorEntity.class, Long.parseLong(pojo.getDoctorId().substring(3)));
			prescriptionEntity.setDoctorEntity(doctorEntity);

			MedicineEntity medicineEntity1 = new MedicineEntity();
			medicineEntity1 = session.get(MedicineEntity.class, Long.parseLong(pojo.getMedicineId1().substring(3)));
			prescriptionEntity.setMedicineEntity1(medicineEntity1);
			prescriptionEntity.setQuantity1(pojo.getQuantity1());

			if (pojo.getMedicineId2() != null && pojo.getQuantity2() != 0) {
				MedicineEntity medicineEntity2 = new MedicineEntity();
				medicineEntity2 = session.get(MedicineEntity.class, Long.parseLong(pojo.getMedicineId2().substring(3)));
				prescriptionEntity.setMedicineEntity2(medicineEntity2);
				prescriptionEntity.setQuantity2(pojo.getQuantity2());
			}

			if (pojo.getMedicineId3() != null && pojo.getQuantity3() != 0) {
				MedicineEntity medicineEntity3 = new MedicineEntity();
				medicineEntity3 = session.get(MedicineEntity.class, Long.parseLong(pojo.getMedicineId3().substring(3)));
				prescriptionEntity.setMedicineEntity3(medicineEntity3);
				prescriptionEntity.setQuantity3(pojo.getQuantity3());
			}

			if (pojo.getMedicineId4() != null && pojo.getQuantity4() != 0) {
				MedicineEntity medicineEntity4 = new MedicineEntity();
				medicineEntity4 = session.get(MedicineEntity.class, Long.parseLong(pojo.getMedicineId4().substring(3)));
				prescriptionEntity.setMedicineEntity4(medicineEntity4);
				prescriptionEntity.setQuantity4(pojo.getQuantity4());
			}

			if (pojo.getMedicineId5() != null && pojo.getQuantity5() != 0) {
				MedicineEntity medicineEntity5 = new MedicineEntity();
				medicineEntity5 = session.get(MedicineEntity.class, Long.parseLong(pojo.getMedicineId5().substring(3)));
				prescriptionEntity.setMedicineEntity5(medicineEntity5);
				prescriptionEntity.setQuantity5(pojo.getQuantity5());
			}

			prescriptionEntity.setRequestDate(pojo.getRequestDate());
			prescriptionEntity.setOtherInfo(pojo.getOtherInfo());
			
			if(pojo.getStatus().equals("Bill Pending")) {
				prescriptionEntity.setStatus("P");
			}

			session.save(prescriptionEntity);
			transaction.commit();

			prescriptionEntity = session.get(PrescriptionEntity.class, prescriptionEntity.getRequestId());
			builder.append("REQ");
			builder.append(prescriptionEntity.getRequestId());
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

	public PrescriptionPOJO fetchPrescriptionDetails(String prescriptionId) throws ApplicationException {

		SessionFactory sessionfactory = null;
		Session session = null;
		PrescriptionPOJO prescriptionPOJO = new PrescriptionPOJO();
		StringBuilder builder = new StringBuilder();

		try {
			sessionfactory = HibernateUtil.getSessionFactory();
			session = sessionfactory.openSession();
			Transaction transaction = session.beginTransaction();

			PrescriptionEntity prescriptionEntity = new PrescriptionEntity();
			prescriptionEntity = session.get(PrescriptionEntity.class, Long.parseLong(prescriptionId.substring(3)));

			prescriptionPOJO.setRequestId(prescriptionId);
			
			builder.append("PAT");
			builder.append(Long.toString(prescriptionEntity.getPatientEntity().getPatientId()));
			String patientId = builder.toString();
			prescriptionPOJO.setPatientId(patientId);
			builder.setLength(0);
			
			builder.append("DOC");
			builder.append(Long.toString(prescriptionEntity.getDoctorEntity().getDoctorId()));
			String doctorId = builder.toString();
			prescriptionPOJO.setDoctorId(doctorId);
			builder.setLength(0);
			
			prescriptionPOJO.setRequestDate(prescriptionEntity.getRequestDate());
			
			builder.append("MED");
			builder.append(Long.toString(prescriptionEntity.getMedicineEntity1().getMedicineId()));
			String medicineId1 = builder.toString();
			prescriptionPOJO.setMedicineId1(medicineId1);
			builder.setLength(0);
			prescriptionPOJO.setQuantity1(prescriptionEntity.getQuantity1());
			
			
            if (prescriptionEntity.getMedicineEntity2()!=null) {
    			builder.append("MED");
    			builder.append(Long.toString(prescriptionEntity.getMedicineEntity2().getMedicineId()));
    			String medicineId2 = builder.toString();
    			prescriptionPOJO.setMedicineId2(medicineId2);
    			builder.setLength(0);
    			prescriptionPOJO.setQuantity2(prescriptionEntity.getQuantity2());
            }
			
			
            if (prescriptionEntity.getMedicineEntity3()!=null) {
    			builder.append("MED");
    			builder.append(Long.toString(prescriptionEntity.getMedicineEntity3().getMedicineId()));
    			String medicineId3 = builder.toString();
    			prescriptionPOJO.setMedicineId3(medicineId3);
    			builder.setLength(0);
    			prescriptionPOJO.setQuantity3(prescriptionEntity.getQuantity3());
            }
			
			
            if (prescriptionEntity.getMedicineEntity4()!=null) {
    			builder.append("MED");
    			builder.append(Long.toString(prescriptionEntity.getMedicineEntity4().getMedicineId()));
    			String medicineId4 = builder.toString();
    			prescriptionPOJO.setMedicineId4(medicineId4);
    			builder.setLength(0);
    			prescriptionPOJO.setQuantity4(prescriptionEntity.getQuantity4());
            }
			
			
            if (prescriptionEntity.getMedicineEntity5()!=null) {
    			builder.append("MED");
    			builder.append(Long.toString(prescriptionEntity.getMedicineEntity5().getMedicineId()));
    			String medicineId5 = builder.toString();
    			prescriptionPOJO.setMedicineId5(medicineId5);
    			builder.setLength(0);
    			prescriptionPOJO.setQuantity5(prescriptionEntity.getQuantity5());
            }
			
			
			prescriptionPOJO.setOtherInfo(prescriptionEntity.getOtherInfo());
			prescriptionPOJO.setStatus(prescriptionEntity.getStatus());

		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;

		}

		finally {
			session.close();
		}

		return prescriptionPOJO;
	}

	public void updatePrescriptionDetails(PrescriptionPOJO pojo) throws ApplicationException {

		SessionFactory sessionfactory = null;
		Session session = null;

		try {
			sessionfactory = HibernateUtil.getSessionFactory();
			session = sessionfactory.openSession();
			Transaction transaction = session.beginTransaction();

			System.out.println(pojo.getRequestId().substring(3));
			PrescriptionEntity prescriptionEntity = session.get(PrescriptionEntity.class,
					Long.parseLong(pojo.getRequestId().substring(3)));

			MedicineEntity medicineEntity1 = new MedicineEntity();
			medicineEntity1 = session.get(MedicineEntity.class, Long.parseLong(pojo.getMedicineId1().substring(3)));
			prescriptionEntity.setMedicineEntity1(medicineEntity1);
			prescriptionEntity.setQuantity1(pojo.getQuantity1());

			if (pojo.getMedicineId2() != null) {
				MedicineEntity medicineEntity2 = new MedicineEntity();
				medicineEntity2 = session.get(MedicineEntity.class, Long.parseLong(pojo.getMedicineId2().substring(3)));
				prescriptionEntity.setMedicineEntity2(medicineEntity2);
				prescriptionEntity.setQuantity2(pojo.getQuantity2());
			}

			if (pojo.getMedicineId3() != null) {
				MedicineEntity medicineEntity3 = new MedicineEntity();
				medicineEntity3 = session.get(MedicineEntity.class, Long.parseLong(pojo.getMedicineId3().substring(3)));
				prescriptionEntity.setMedicineEntity3(medicineEntity3);
				prescriptionEntity.setQuantity3(pojo.getQuantity3());
			}

			if (pojo.getMedicineId4() != null) {
				MedicineEntity medicineEntity4 = new MedicineEntity();
				medicineEntity4 = session.get(MedicineEntity.class, Long.parseLong(pojo.getMedicineId4().substring(3)));
				prescriptionEntity.setMedicineEntity4(medicineEntity4);
				prescriptionEntity.setQuantity4(pojo.getQuantity4());
			}

			if (pojo.getMedicineId5() != null) {
				MedicineEntity medicineEntity5 = new MedicineEntity();
				medicineEntity5 = session.get(MedicineEntity.class, Long.parseLong(pojo.getMedicineId5().substring(3)));
				prescriptionEntity.setMedicineEntity5(medicineEntity5);
				prescriptionEntity.setQuantity5(pojo.getQuantity5());
			}

			prescriptionEntity.setRequestDate(pojo.getRequestDate());
			prescriptionEntity.setOtherInfo(pojo.getOtherInfo());
			
			if(pojo.getStatus().equals("Bill Pending")) {
				prescriptionEntity.setStatus("P");
			}

			session.save(prescriptionEntity);
			transaction.commit();

		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;

		}

		finally {
			session.close();
		}

	}
}