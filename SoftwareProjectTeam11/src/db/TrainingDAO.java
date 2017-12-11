package db;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import logic.Training;

public class TrainingDAO {
	
	public void addTraining(Training training)
	{
		
	//opening session
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	
	
	session.save(training);
		
		
	//closing session
	session.getTransaction().commit();
	System.out.println("Statement Worked!");
	session.close();
	sessionFactory.close();
		
	}
	
	public List<Training> getAll()
	{
		
	//opening session
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	
	
	@SuppressWarnings("unchecked")
	Query<Training> query = session.createQuery("FROM Training WHERE visibility = 1");
	List<Training> lijst = query.list();
		
		
	//closing session
	session.getTransaction().commit();
	System.out.println("Statement Worked!");
	session.close();
	sessionFactory.close();
	
	return lijst;
	}
	
	public Training getTrainingById(int id)
	{
		
	//opening session
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	Training t = new Training();
	
	t = (Training)session.get(Training.class,id);

		
		
	//closing session
	session.getTransaction().commit();
	System.out.println("Statement Worked!");
	session.close();
	sessionFactory.close();
	
	return t;
	}

}
