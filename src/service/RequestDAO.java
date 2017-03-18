package service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Request;

public class RequestDAO {

	public void addRequest(Request r){
		Session session = SessionFactoryUtil.getInstance().openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();		
			session.save(r);
			session.getTransaction().commit();
		}
		catch(RuntimeException e){
			if(transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}
		finally{
			//session.flush();
			session.close();
		}
		
	}
	public List <Request> getRequestList(){
		List <Request> requestList = new ArrayList<Request>();
		Session session = SessionFactoryUtil.getInstance().openSession();
		try{
			Transaction tx = null;
			tx = session.beginTransaction();
			Query query = session.createQuery("from Request");
			requestList = (List <Request>) query.list();
			session.getTransaction().commit();
		}
		catch(RuntimeException e){
			e.printStackTrace();
		}
		finally{
		//	session.flush();
			session.close();
		}
		return requestList;
	}
	
	public void addData(BigDecimal cost){
		Request r = new Request();
		r.setCost(cost);
		addRequest(r);
	}
}


/*	public Request getRequestById(int id){
Session session = SessionFactoryUtil.getInstance().openSession();
Transaction tx = null;
Request r = null;
try{
	tx = session.beginTransaction();
	Query query = session.createQuery("from Request where id=:id");
	query.setInteger("id", id);
	r = (Request) query.uniqueResult();
	session.getTransaction().commit();
	
}
catch( RuntimeException e){
	if(tx!=null)
		tx.rollback();
	e.printStackTrace();
}
finally{
	session.close();
}
return r;
}*/
