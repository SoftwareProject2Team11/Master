package db;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import logic.Survey;
import logic.TrainingRequest;

public class TrainingRequestDAO {
	
	// 1 = not noted, 2 = accepted, 3 = refused
	
	public List<TrainingRequest> getAllAddress()
	{
		
	//opening session
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	
	
	@SuppressWarnings("unchecked")
	Query<TrainingRequest> query = session.createQuery("FROM TrainingRequest where status = 1");
	List<TrainingRequest> lijst = query.list();
		
		
	//closing session
	session.getTransaction().commit();
	System.out.println("Statement Worked!");
	session.close();
	sessionFactory.close();
	
	return lijst;
	}
	
	public void acceptRequest(Integer requestId) {
		
		 //Open Session
		 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		 Session session = sessionfactory.openSession();
		 session.beginTransaction();
		 
		 //Statement
		 Query<TrainingRequest> query = session.createNativeQuery("UPDATE Training_Requests SET status = 2 WHERE requestId = "+ requestId);
		 query.executeUpdate();

		 
		 //Close Session
		 session.getTransaction().commit();
		 System.out.println("Statement Worked !");
		 session.close();
		 sessionfactory.close();
	}
	
	public void declineRequest(int requestId) {
		
		 //Open Session
		 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		 Session session = sessionfactory.openSession();
		 session.beginTransaction();
		 
		 //Statement
		 Query<TrainingRequest> query = session.createNativeQuery("UPDATE Training_Requests SET status = 3 WHERE requestId = "+ requestId);
		 query.executeUpdate();
		

		 
		 //Close Session
		 session.getTransaction().commit();
		 System.out.println("Statement Worked !");
		 session.close();
		 sessionfactory.close();
	}

}
