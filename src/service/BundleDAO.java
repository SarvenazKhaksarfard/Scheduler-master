package service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Bundle;
import model.Request;

public class BundleDAO {

	public void addBundle(Bundle b){
		Session session = SessionFactoryUtil.getInstance().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(b);
			session.getTransaction().commit();
		}
		catch(RuntimeException e){
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		finally{
			//session.flush();
			session.close();
		}
	
	}
	//*********bundle.getRequestList to initialize Lazy
	public List <Bundle> getAllBundles(){
		List <Bundle> bundleList = new ArrayList <Bundle> ();
		Session session = SessionFactoryUtil.getInstance().openSession();
		try{
			Transaction tx = null;
			tx = session.beginTransaction();
			bundleList = session.createQuery("from Bundle").list();
		}
		catch(RuntimeException e){
			e.printStackTrace();
		}
		finally{
			//session.flush();
			session.close();
		}
		return bundleList;
	}
	
	public void addData(BigDecimal cost, int nurseID, List <Request> patientRequestList){
		Bundle b = new Bundle();
		b.setAssigned(false);
		b.setCost(cost);
		b.setNurseID(nurseID);
		b.setPatientRequestList(patientRequestList);
		addBundle(b);
	}
	
	public void setAssigned(int id){
		Session session = SessionFactoryUtil.getInstance().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Bundle b = (Bundle) session.get(Bundle.class, id);
			b.setAssigned(true);
			session.update(b);
			session.getTransaction().commit();
		}
		catch(RuntimeException e){
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		
		
	}
	
}




//before transient
//save: after that persist, changes updated
//close: detached