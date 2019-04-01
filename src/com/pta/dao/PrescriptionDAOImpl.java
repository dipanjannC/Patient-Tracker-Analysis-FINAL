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
import com.pta.entity.PrescriptionEntity;
import com.pta.java.ApplicationException;
import com.pta.model.DoctorPOJO;
import com.pta.model.MedicinePOJO;
import com.pta.model.PatientPOJO;
import com.pta.model.PrescriptionPOJO;
import com.pta.service.DoctorService;
import com.pta.service.DoctorServiceImpl;
import com.pta.service.MedicineService;
import com.pta.service.MedicineServiceImpl;
import com.pta.service.PatientService;
import com.pta.service.PatientServiceImpl;

@Repository("prescriptionDAO")
public class PrescriptionDAOImpl implements PrescriptionDAO {

	public ArrayList getPatientId() throws ApplicationException
	{
		ArrayList id=null;
		SessionFactory sessionfactory = null;
		Session session = null;
		StringBuilder builder = new StringBuilder();
		
        try {
    		sessionfactory = HibernateUtil.getSessionFactory();
    		session = sessionfactory.openSession();
    		
    		List list=session.createQuery("from PatientEntity").list();
    		id=new ArrayList();
    		for(int i=0;i< list.size();i++)
    		{
    			PatientEntity patientEntity=(PatientEntity)list.get(i);
    			PatientPOJO pojo = new PatientPOJO();
    			builder.append("PAT");
    			builder.append(Long.toString(patientEntity.getPatientId()));
    			String patientId = builder.toString();
    			pojo.setPatientId(patientId);
    			builder.setLength(0);
    			id.add(pojo);
    		}
    		
		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;

		}

		finally {
			session.close();
		}
		
		return id;
	}
	
	
	
	public ArrayList getDoctorId() throws ApplicationException
	{
		ArrayList doctorId=null;
		SessionFactory sessionfactory = null;
		Session session = null;
		StringBuilder builder = new StringBuilder();
		
        try {
    		sessionfactory = HibernateUtil.getSessionFactory();
    		session = sessionfactory.openSession();
    		
    		List list=session.createQuery("from DoctorEntity").list();
    		doctorId=new ArrayList();
    		for(int i=0;i< list.size();i++)
    		{
    		 DoctorEntity doctorEntity=(DoctorEntity)list.get(i);
    		 DoctorPOJO pojo = new DoctorPOJO();
    		 builder.append("DOC");
    		 builder.append(Long.toString(doctorEntity.getDoctorId()));
    		 String id = builder.toString();
    		 pojo.setDoctorId(id);
    		 builder.setLength(0);
    		 doctorId.add(pojo);
    		}
    		
		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;

		}

		finally {
			session.close();
		}	
        
		return doctorId;
		
	}
	
	
	public ArrayList getMedicineId() throws ApplicationException
	{
		ArrayList medicineId=null;
		SessionFactory sessionfactory = null;
		Session session = null;
		StringBuilder builder = new StringBuilder();
		
        try {
    		sessionfactory = HibernateUtil.getSessionFactory();
    		session = sessionfactory.openSession();
    		
    		List list=session.createQuery("from MedicineEntity").list();
    		medicineId=new ArrayList();
    		for(int i=0;i< list.size();i++)
    		{
    		 MedicineEntity medicineEntity=(MedicineEntity)list.get(i);
    		 MedicinePOJO pojo = new MedicinePOJO();
    		 builder.append("MED");
    		 builder.append(Long.toString(medicineEntity.getMedicineId()));
    		 String id = builder.toString();
    		 pojo.setMedicineId(id);
    		 builder.setLength(0);
    		 medicineId.add(pojo);
    		}
    		
		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;

		}

		finally {
			session.close();
		}
		
		return medicineId;
		
	}
	
	
	
	public  ArrayList fetchPrescriptionDetails() throws ApplicationException {
		StringBuilder builder = new StringBuilder();
		
		ArrayList prescriptionDetails=null;
		SessionFactory sessionfactory = null;
		Session session = null;
		
        try {
    		sessionfactory = HibernateUtil.getSessionFactory();
    		session = sessionfactory.openSession();
    		
    		List list=session.createQuery("from PrescriptionEntity").list();
    		prescriptionDetails=new ArrayList();
    		for(int i=0;i< list.size();i++)
    			{
    			 PrescriptionEntity prescriptionEntity=(PrescriptionEntity)list.get(i);
    			 PrescriptionPOJO pojo = new PrescriptionPOJO();
    			 builder.append("REQ");
    			 builder.append(Long.toString(prescriptionEntity.getRequestId()));
    			 String requestId = builder.toString();
    			 pojo.setRequestId(requestId);
    			 builder.setLength(0);
    			 pojo.setPatientId(Long.toString(prescriptionEntity.getPatientEntity().getPatientId()));
    			 pojo.setDoctorId(Long.toString(prescriptionEntity.getDoctorEntity().getDoctorId()));
    			 pojo.setRequestDate(prescriptionEntity.getRequestDate());
    			 prescriptionDetails.add(pojo);

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
    		
            if(pojo.getMedicineId2()!=null && pojo.getQuantity2()!=0) {
        		MedicineEntity medicineEntity2 = new MedicineEntity();
        		medicineEntity2 = session.get(MedicineEntity.class, Long.parseLong(pojo.getMedicineId2().substring(3)));
        		prescriptionEntity.setMedicineEntity2(medicineEntity2);
        		prescriptionEntity.setQuantity2(pojo.getQuantity2());
            }
    		
            if(pojo.getMedicineId3()!=null && pojo.getQuantity3()!=0) {
        		MedicineEntity medicineEntity3 = new MedicineEntity();
        		medicineEntity3 = session.get(MedicineEntity.class, Long.parseLong(pojo.getMedicineId3().substring(3)));
        		prescriptionEntity.setMedicineEntity3(medicineEntity3);
        		prescriptionEntity.setQuantity3(pojo.getQuantity3());
            }
    		
            if(pojo.getMedicineId4()!=null && pojo.getQuantity4()!=0) {
        		MedicineEntity medicineEntity4 = new MedicineEntity();
        		medicineEntity4 = session.get(MedicineEntity.class, Long.parseLong(pojo.getMedicineId4().substring(3)));
        		prescriptionEntity.setMedicineEntity4(medicineEntity4);
        		prescriptionEntity.setQuantity4(pojo.getQuantity4());
            }
    		
            if(pojo.getMedicineId5()!=null && pojo.getQuantity5()!=0) {
        		MedicineEntity medicineEntity5 = new MedicineEntity();
        		medicineEntity5 = session.get(MedicineEntity.class, Long.parseLong(pojo.getMedicineId5().substring(3)));
        		prescriptionEntity.setMedicineEntity5(medicineEntity5);
        		prescriptionEntity.setQuantity5(pojo.getQuantity5());  
            }
    		
    		prescriptionEntity.setRequestDate(pojo.getRequestDate());
    		prescriptionEntity.setOtherInfo(pojo.getOtherInfo());    		
    		prescriptionEntity.setStatus(pojo.getStatus());
    		
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
		System.out.println(id);
		return id;		
	}
	
	
	
	public PrescriptionPOJO fetchPrescriptionDetails(String id) throws ApplicationException {

		SessionFactory sessionfactory = null;
		Session session = null;
		PrescriptionPOJO pojo = new PrescriptionPOJO();
		
        try {
    		sessionfactory = HibernateUtil.getSessionFactory();
    		session = sessionfactory.openSession();
    		Transaction transaction = session.beginTransaction();
    		
    		PrescriptionEntity prescriptionEntity = new PrescriptionEntity();
    		prescriptionEntity = session.get(PrescriptionEntity.class, Long.parseLong(id.substring(3)));
    		
    		//System.out.println(Long.parseLong(id.substring(3)));
    		
    		
    		 pojo.setRequestId(id);
    		 pojo.setPatientId(Long.toString(prescriptionEntity.getPatientEntity().getPatientId()));
    		 pojo.setDoctorId(Long.toString(prescriptionEntity.getDoctorEntity().getDoctorId()));
    		 pojo.setRequestDate(prescriptionEntity.getRequestDate());
    		 pojo.setMedicineId1(Long.toString(prescriptionEntity.getMedicineEntity1().getMedicineId()));
    		 pojo.setQuantity1(prescriptionEntity.getQuantity1());
    		 pojo.setMedicineId2(Long.toString(prescriptionEntity.getMedicineEntity2().getMedicineId()));
    		 pojo.setQuantity2(prescriptionEntity.getQuantity2());
    		 pojo.setMedicineId3(Long.toString(prescriptionEntity.getMedicineEntity3().getMedicineId()));
    		 pojo.setQuantity3(prescriptionEntity.getQuantity3());
    		 pojo.setMedicineId4(Long.toString(prescriptionEntity.getMedicineEntity4().getMedicineId()));
    		 pojo.setQuantity4(prescriptionEntity.getQuantity4());
    		 pojo.setMedicineId5(Long.toString(prescriptionEntity.getMedicineEntity5().getMedicineId()));
    		 pojo.setQuantity5(prescriptionEntity.getQuantity5());
    		 pojo.setOtherInfo(prescriptionEntity.getOtherInfo());
    		 pojo.setStatus(prescriptionEntity.getStatus());
    		 
		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;

		}

		finally {
			session.close();
		}
		 
		 return pojo;
	}
	
	
	
	public void updatePrescriptionDetails(PrescriptionPOJO pojo) throws ApplicationException {
		
		//StringBuilder builder = new StringBuilder();
		
		SessionFactory sessionfactory = null;
		Session session = null;
		//String id = null;
		
        try {
    		sessionfactory = HibernateUtil.getSessionFactory();
    		session = sessionfactory.openSession();
    		Transaction transaction = session.beginTransaction();    		
    		
    		System.out.println(pojo.getRequestId().substring(3));
    		PrescriptionEntity prescriptionEntity = session.get(PrescriptionEntity.class , Long.parseLong(pojo.getRequestId().substring(3)));
    		
    		
    		MedicineEntity medicineEntity1 = new MedicineEntity();
    		medicineEntity1 = session.get(MedicineEntity.class, Long.parseLong(pojo.getMedicineId1().substring(3)));
    		prescriptionEntity.setMedicineEntity1(medicineEntity1);
    		prescriptionEntity.setQuantity1(pojo.getQuantity1());
    		
            if(pojo.getMedicineId2()!=null && pojo.getQuantity2()!=0) {
        		MedicineEntity medicineEntity2 = new MedicineEntity();
        		medicineEntity2 = session.get(MedicineEntity.class, Long.parseLong(pojo.getMedicineId2().substring(3)));
        		prescriptionEntity.setMedicineEntity2(medicineEntity2);
        		prescriptionEntity.setQuantity2(pojo.getQuantity2());
            }
    		
            if(pojo.getMedicineId3()!=null && pojo.getQuantity3()!=0) {
        		MedicineEntity medicineEntity3 = new MedicineEntity();
        		medicineEntity3 = session.get(MedicineEntity.class, Long.parseLong(pojo.getMedicineId3().substring(3)));
        		prescriptionEntity.setMedicineEntity3(medicineEntity3);
        		prescriptionEntity.setQuantity3(pojo.getQuantity3());
            }
    		
            if(pojo.getMedicineId4()!=null && pojo.getQuantity4()!=0) {
        		MedicineEntity medicineEntity4 = new MedicineEntity();
        		medicineEntity4 = session.get(MedicineEntity.class, Long.parseLong(pojo.getMedicineId4().substring(3)));
        		prescriptionEntity.setMedicineEntity4(medicineEntity4);
        		prescriptionEntity.setQuantity4(pojo.getQuantity4());
            }
    		
            if(pojo.getMedicineId5()!=null && pojo.getQuantity5()!=0) {
        		MedicineEntity medicineEntity5 = new MedicineEntity();
        		medicineEntity5 = session.get(MedicineEntity.class, Long.parseLong(pojo.getMedicineId5().substring(3)));
        		prescriptionEntity.setMedicineEntity5(medicineEntity5);
        		prescriptionEntity.setQuantity5(pojo.getQuantity5());  
            }
    		
    		prescriptionEntity.setRequestDate(pojo.getRequestDate());
    		prescriptionEntity.setOtherInfo(pojo.getOtherInfo());    		
    		
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