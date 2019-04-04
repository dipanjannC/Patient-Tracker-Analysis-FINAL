package com.pta.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.pta.entity.BillEntity;
import com.pta.entity.PrescriptionEntity;
import com.pta.java.ApplicationException;
import com.pta.model.BillPOJO;

@Repository("billDAO")
public class BillDAOImpl implements BillDAO {

	public BillPOJO billDetails(String billId) throws ApplicationException {
		SessionFactory sessionfactory = null;
		Session session = null;

		StringBuilder builder = new StringBuilder();

		sessionfactory = HibernateUtil.getSessionFactory();
		session = sessionfactory.openSession();

		BillPOJO billPojo = new BillPOJO();

		try {

			BillEntity billEntity = new BillEntity();
			billEntity = session.get(BillEntity.class, Long.parseLong(billId.substring(4)));

			billPojo.setBillId(billId);

			builder.append("DOC");
			builder.append(billEntity.getDoctorEntity().getDoctorId());
			String doctorId = builder.toString();
			billPojo.setDoctorId(doctorId);
			builder.setLength(0);

			builder.append("PAT");
			builder.append(billEntity.getPatientEntity().getPatientId());
			String patientId = builder.toString();
			billPojo.setPatientId(patientId);
			builder.setLength(0);

			builder.append("MED");
			builder.append(billEntity.getMedicineEntity1().getMedicineId());
			String medicineId1 = builder.toString();
			billPojo.setMedicineId1(medicineId1);
			builder.setLength(0);

			int medicineQuantity1 = billEntity.getQuantity1();
			int medicineAmount1 = billEntity.getAmount1();
			int medicineTotalAmount1 = medicineQuantity1 * medicineAmount1;
			billPojo.setQuantity1(medicineQuantity1);

			billPojo.setAmount1(medicineAmount1);

			billPojo.setTotalAmountMedicine1(medicineTotalAmount1);

			int medicineTotalAmount2 = 0;
			int medicineTotalAmount3 = 0;
			int medicineTotalAmount4 = 0;
			int medicineTotalAmount5 = 0;

			if (billEntity.getMedicineEntity2() != null) {
				builder.append("MED");
				builder.append(billEntity.getMedicineEntity2().getMedicineId());
				String medicineId2 = builder.toString();
				billPojo.setMedicineId2(medicineId2);
				builder.setLength(0);
				int medicineQuantity2 = billEntity.getQuantity2();
				int medicineAmount2 = billEntity.getAmount2();
				medicineTotalAmount2 = medicineQuantity2 * medicineAmount2;
				billPojo.setQuantity2(medicineQuantity2);
				billPojo.setAmount2(medicineAmount2);
				billPojo.setTotalAmountMedicine2(medicineTotalAmount2);
			}

			if (billEntity.getMedicineEntity3() != null) {
				builder.append("MED");
				builder.append(billEntity.getMedicineEntity3().getMedicineId());
				String medicineId3 = builder.toString();
				billPojo.setMedicineId3(medicineId3);
				builder.setLength(0);
				int medicineQuantity3 = billEntity.getQuantity3();
				int medicineAmount3 = billEntity.getAmount3();
				medicineTotalAmount3 = medicineQuantity3 * medicineAmount3;
				billPojo.setQuantity3(medicineQuantity3);
				billPojo.setAmount3(medicineAmount3);
				billPojo.setTotalAmountMedicine3(medicineTotalAmount3);
			}

			if (billEntity.getMedicineEntity4() != null) {
				builder.append("MED");
				builder.append(billEntity.getMedicineEntity4().getMedicineId());
				String medicineId4 = builder.toString();
				billPojo.setMedicineId4(medicineId4);
				builder.setLength(0);
				int medicineQuantity4 = billEntity.getQuantity4();
				int medicineAmount4 = billEntity.getAmount4();
				medicineTotalAmount4 = medicineQuantity4 * medicineAmount4;
				billPojo.setQuantity4(medicineQuantity4);
				billPojo.setAmount4(medicineAmount4);
				billPojo.setTotalAmountMedicine4(medicineTotalAmount4);
			}

			if (billEntity.getMedicineEntity5() != null) {
				builder.append("MED");
				builder.append(billEntity.getMedicineEntity5().getMedicineId());
				String medicineId5 = builder.toString();
				billPojo.setMedicineId5(medicineId5);
				builder.setLength(0);
				int medicineQuantity5 = billEntity.getQuantity5();
				int medicineAmount5 = billEntity.getAmount5();
				medicineTotalAmount5 = medicineQuantity5 * medicineAmount5;
				billPojo.setQuantity5(medicineQuantity5);
				billPojo.setAmount5(medicineAmount5);
				billPojo.setTotalAmountMedicine5(medicineTotalAmount5);
			}

			billPojo.setBillDate(billEntity.getBillDate());

			// Calculating Total Bill Amount and Setting details in POJO
			int totalBillAmount = medicineTotalAmount1 + medicineTotalAmount2 + medicineTotalAmount3
					+ medicineTotalAmount4 + medicineTotalAmount5;
			billPojo.setTotalAmount(totalBillAmount);

			String doctorFristName = billEntity.getDoctorEntity().getFirstName();
			String doctorLastName = billEntity.getDoctorEntity().getLastName();
			String doctorName = doctorFristName + " " + doctorLastName;
			billPojo.setDoctorName(doctorName);

			String patientFristName = billEntity.getPatientEntity().getFirstName();
			String patientLastName = billEntity.getPatientEntity().getLastName();
			String patientName = patientFristName + " " + patientLastName;
			billPojo.setPatientName(patientName);

		} catch (HibernateException he) {

			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;

		} finally {

			session.close();
		}
		return billPojo;
	}

	public String addBillDetails(String requestId) throws ApplicationException {

		StringBuilder builder = new StringBuilder();

		SessionFactory sessionfactory = null;
		Session session = null;
		String id = null;

		try {
			sessionfactory = HibernateUtil.getSessionFactory();
			session = sessionfactory.openSession();
			Transaction transaction = session.beginTransaction();

			PrescriptionEntity prescriptionEntity = session.get(PrescriptionEntity.class,
					Long.parseLong(requestId.substring(3)));

			BillEntity billEntity = new BillEntity();

			billEntity.setBillDate(prescriptionEntity.getRequestDate());
			billEntity.setPatientEntity(prescriptionEntity.getPatientEntity());
			billEntity.setDoctorEntity(prescriptionEntity.getDoctorEntity());

			billEntity.setMedicineEntity1(prescriptionEntity.getMedicineEntity1());
			billEntity.setAmount1(prescriptionEntity.getMedicineEntity1().getAmount());
			billEntity.setQuantity1(prescriptionEntity.getQuantity1());

			if (prescriptionEntity.getMedicineEntity2() != null) {
				billEntity.setMedicineEntity2(prescriptionEntity.getMedicineEntity2());
				billEntity.setAmount2(prescriptionEntity.getMedicineEntity2().getAmount());
				billEntity.setQuantity2(prescriptionEntity.getQuantity2());
			}
			if (prescriptionEntity.getMedicineEntity3() != null) {
				billEntity.setMedicineEntity3(prescriptionEntity.getMedicineEntity3());
				billEntity.setAmount3(prescriptionEntity.getMedicineEntity3().getAmount());
				billEntity.setQuantity3(prescriptionEntity.getQuantity3());
			}
			if (prescriptionEntity.getMedicineEntity4() != null) {
				billEntity.setMedicineEntity4(prescriptionEntity.getMedicineEntity4());
				billEntity.setAmount4(prescriptionEntity.getMedicineEntity4().getAmount());
				billEntity.setQuantity4(prescriptionEntity.getQuantity4());
			}
			if (prescriptionEntity.getMedicineEntity5() != null) {
				billEntity.setMedicineEntity5(prescriptionEntity.getMedicineEntity5());
				billEntity.setAmount5(prescriptionEntity.getMedicineEntity5().getAmount());
				billEntity.setQuantity5(prescriptionEntity.getQuantity5());
			}
			
			prescriptionEntity.setStatus("B");
            session.save(prescriptionEntity);
			session.save(billEntity);
			transaction.commit();

			billEntity = session.get(BillEntity.class, billEntity.getBillId());
			builder.append("BILL");
			builder.append(Long.toString(billEntity.getBillId()));
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

}