package com.pta.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.pta.entity.ClerkEntity;
import com.pta.java.ApplicationException;
import com.pta.model.ClerkPOJO;

@Repository("clerkDAO")
public class ClerkDAOImpl implements ClerkDAO {
	
	public String addClerkDetails(ClerkPOJO pojo) throws ApplicationException {
		StringBuilder builder = new StringBuilder();
			
		SessionFactory sessionfactory = null;
		Session session = null;
		String id = null;
		
        try {
    		sessionfactory = HibernateUtil.getSessionFactory();
    		session = sessionfactory.openSession();
    		Transaction transaction = session.beginTransaction();
    		
    		ClerkEntity clerkEntity = new ClerkEntity();
    		clerkEntity.setFirstName(pojo.getFirstName());
    		clerkEntity.setLastName(pojo.getLastName());
    		clerkEntity.setAge(pojo.getAge());
    		clerkEntity.setAddressLine1(pojo.getAddressLine1());
    		clerkEntity.setAddressLine2(pojo.getAddressLine2());
    		
    		if(Long.toString(pojo.getAlternateContactNumber())!=null) {
    			clerkEntity.setAlternateContactNumber(pojo.getAlternateContactNumber());
    		}
    		
    		clerkEntity.setCity((pojo.getCity()));
    		clerkEntity.setContactNumber(pojo.getContactNumber());
    		clerkEntity.setDateOfBirth(pojo.getDateOfBirth());
    		clerkEntity.setEmailId(pojo.getEmailId());
    		clerkEntity.setGender(pojo.getGender());
    		clerkEntity.setState(pojo.getState());
    		clerkEntity.setZipCode(pojo.getZipCode());

    		session.save(clerkEntity);
    		transaction.commit();

    		clerkEntity = session.get(ClerkEntity.class, clerkEntity.getClerkId());
    		builder.append("CLK");
    		builder.append(Long.toString(clerkEntity.getClerkId()));
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
	
	
	public  ArrayList fetchClerkDetails() throws ApplicationException {
		StringBuilder builder = new StringBuilder();
		
		ArrayList clerkDetails=null;
		SessionFactory sessionfactory = null;
		Session session = null;
		
        try {
    		sessionfactory = HibernateUtil.getSessionFactory();
    		session = sessionfactory.openSession();
    		
    		List list=session.createQuery("from ClerkEntity").list();
    		clerkDetails=new ArrayList();
    		for(int i=0;i< list.size();i++)
    			{
    			 ClerkEntity clerkEntity=(ClerkEntity)list.get(i);
    			 ClerkPOJO pojo = new ClerkPOJO();
    			 pojo.setAddressLine1(clerkEntity.getAddressLine1());
    			 pojo.setAddressLine2(clerkEntity.getAddressLine2());
    			 pojo.setAge(clerkEntity.getAge());
    			 pojo.setAlternateContactNumber(clerkEntity.getAlternateContactNumber());
    			 pojo.setCity(clerkEntity.getCity());
    			 
    			 builder.append("CLK");
    			 builder.append(Long.toString(clerkEntity.getClerkId()));	
    		     String id = builder.toString();
    			 pojo.setClerkId(id);
    			 builder.setLength(0);
    			 
    			 pojo.setContactNumber(clerkEntity.getContactNumber());
    			 pojo.setDateOfBirth(clerkEntity.getDateOfBirth());
    			 pojo.setEmailId(clerkEntity.getEmailId());
    			 pojo.setFirstName(clerkEntity.getFirstName());
    			 pojo.setGender(clerkEntity.getGender());
    			 pojo.setLastName(clerkEntity.getLastName());
    			 pojo.setState(clerkEntity.getState());
    			 pojo.setZipCode(clerkEntity.getZipCode());
    			 clerkDetails.add(pojo);
    			}
    		
		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1,he.getMessage());
			throw ae;
			
		}

	    	finally {
	    		session.close();
	    	}
		return clerkDetails;
	}
	
	
	public void updateClerkDetails(ClerkPOJO pojo) throws ApplicationException {
		
		SessionFactory sessionfactory = null;
		Session session = null;
		
		//StringBuilder builder = new StringBuilder();
		
        try {
    		sessionfactory = HibernateUtil.getSessionFactory();
    		session = sessionfactory.openSession();
    		Transaction transaction = session.beginTransaction();
    		
    		ClerkEntity clerkEntity = session.get(ClerkEntity.class, Long.parseLong(pojo.getClerkId().substring(3)));
    		clerkEntity.setFirstName(pojo.getFirstName());
    		clerkEntity.setLastName(pojo.getLastName());
    		clerkEntity.setAge(pojo.getAge());
    		clerkEntity.setAddressLine1(pojo.getAddressLine1());
    		clerkEntity.setAddressLine2(pojo.getAddressLine2());
    		
    		if(Long.toString(pojo.getAlternateContactNumber())!=null) {
    			clerkEntity.setAlternateContactNumber(pojo.getAlternateContactNumber());
    		}
    		
    		clerkEntity.setCity((pojo.getCity()));
    		clerkEntity.setContactNumber(pojo.getContactNumber());
    		clerkEntity.setDateOfBirth(pojo.getDateOfBirth());
    		clerkEntity.setEmailId(pojo.getEmailId());
    		clerkEntity.setGender(pojo.getGender());
    		clerkEntity.setState(pojo.getState());
    		clerkEntity.setZipCode(pojo.getZipCode());
    		
    		transaction.commit();
    		
		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1,he.getMessage());
			throw ae;
			
		}

	    	finally {
	    		session.close();
	    	}		
	}
	
	public ClerkPOJO fetchClerkDetails(String id) throws ApplicationException {
		
		SessionFactory sessionfactory = null;
		Session session = null;
		ClerkPOJO pojo = new ClerkPOJO();
		
        try {
    		sessionfactory = HibernateUtil.getSessionFactory();
    		session = sessionfactory.openSession();
    		Transaction transaction = session.beginTransaction();
    		
    		ClerkEntity clerkEntity = new ClerkEntity();
    		clerkEntity = session.get(ClerkEntity.class, Long.parseLong(id.substring(3)));
    		
    		pojo.setAddressLine1(clerkEntity.getAddressLine1());
    		pojo.setAddressLine2(clerkEntity.getAddressLine2());
    		pojo.setAge(clerkEntity.getAge());
    		pojo.setAlternateContactNumber(clerkEntity.getAlternateContactNumber());
    		pojo.setCity(clerkEntity.getCity());		 
    		pojo.setClerkId(id);		 
    		pojo.setContactNumber(clerkEntity.getContactNumber());
    		pojo.setDateOfBirth(clerkEntity.getDateOfBirth());
    		pojo.setEmailId(clerkEntity.getEmailId());
    		pojo.setFirstName(clerkEntity.getFirstName());
    		pojo.setGender(clerkEntity.getGender());
    		pojo.setLastName(clerkEntity.getLastName());
    		pojo.setState(clerkEntity.getState());
    		pojo.setZipCode(clerkEntity.getZipCode());
    		
		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1,he.getMessage());
			throw ae;
			
		}

	    	finally {
	    		session.close();
	    	}	
        
		return pojo;
	}
	
	
}
