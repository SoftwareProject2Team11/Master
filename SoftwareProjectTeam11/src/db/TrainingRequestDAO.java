package db;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import gui.Main;
import logic.TrainingRequest;

public class TrainingRequestDAO {
	
	// 1 = not noted, 2 = accepted, 3 = refused
	
	public void addTraining(TrainingRequest training)
	{
		
	//opening session
	Session session = Main.sessionFactory.getCurrentSession();
	session.beginTransaction();
	
	
	session.save(training);
		
		
	//closing session
	session.getTransaction().commit();
	System.out.println("Statement Worked!");
	session.close();
	}
	
	
	public List<TrainingRequest> getAllRequests()
	{
		
	//opening session
	Session session = Main.sessionFactory.getCurrentSession();
	session.beginTransaction();
	
	
	@SuppressWarnings("unchecked")
	Query<TrainingRequest> query = session.createQuery("FROM TrainingRequest where status = 1");
	List<TrainingRequest> lijst = query.list();
		
		
	//closing session
	session.getTransaction().commit();
	System.out.println("Statement Worked!");
	session.close();
	
	
	return lijst;
	}
	
	
	public List<TrainingRequest> getAllRequestsForStats()
	{
		
	//opening session
	Session session = Main.sessionFactory.getCurrentSession();
	session.beginTransaction();
	
	
	@SuppressWarnings("unchecked")
	Query<TrainingRequest> query = session.createQuery("FROM TrainingRequest");
	List<TrainingRequest> lijst = query.list();
		
		
	//closing session
	session.getTransaction().commit();
	System.out.println("Statement Worked!");
	session.close();
	
	
	return lijst;
	}
	
	public List<TrainingRequest> getAllFollowing()
	{
		
	//opening session
	Session session = Main.sessionFactory.getCurrentSession();
	session.beginTransaction();
	
	
	@SuppressWarnings("unchecked")
	Query<TrainingRequest> query = session.createQuery("FROM TrainingRequest where status = 2");
	List<TrainingRequest> lijst = query.list();
		
		
	//closing session
	session.getTransaction().commit();
	System.out.println("Statement Worked!");
	session.close();
	
	
	return lijst;
	}
	
	public void acceptRequest(Integer requestId) {
		
		 //Open Session
		Session session = Main.sessionFactory.getCurrentSession();
		 session.beginTransaction();
		 
		 //Statement
		 Query<TrainingRequest> query = session.createNativeQuery("UPDATE Training_Requests SET status = 2 WHERE requestId = "+ requestId);
		 query.executeUpdate();

		 
		 //Close Session
		 session.getTransaction().commit();
		 System.out.println("Statement Worked !");
		 session.close();

	}
	
	public void declineRequest(int requestId) {
		
		 //Open Session
		 Session session = Main.sessionFactory.getCurrentSession();
		 session.beginTransaction();
		 
		 //Statement
		 Query<TrainingRequest> query = session.createNativeQuery("UPDATE Training_Requests SET status = 3 WHERE requestId = "+ requestId);
		 query.executeUpdate();
		

		 
		 //Close Session
		 session.getTransaction().commit();
		 System.out.println("Statement Worked !");
		 session.close();

	}

}
