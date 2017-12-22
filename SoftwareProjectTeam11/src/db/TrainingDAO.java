package db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import gui.Main;
import logic.Training;

public class TrainingDAO {
	
	public void addTraining(Training training)
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
	
	public List<Training> getAll()
	{
		
	//opening session
	
	Session session = Main.sessionFactory.getCurrentSession();
	session.beginTransaction();
	
	
	@SuppressWarnings("unchecked")
	Query<Training> query = session.createQuery("FROM Training WHERE visibility = 1");
	
	List<Training> lijst = query.list();
		
		
	//closing session
	session.getTransaction().commit();
	System.out.println("Statement Worked!");
	session.close();
	
	
	return lijst;
	}
	
	public Training getTrainingById(int id)
	{
		
	//opening session
	Session session = Main.sessionFactory.getCurrentSession();
	session.beginTransaction();
	Training t = new Training();
	
	@SuppressWarnings("unchecked")
	Query<Training> query = session.createQuery("FROM Training WHERE trainingId = :i");
	

	query.setParameter("i", id);
	
	t = query.uniqueResult();
	
		
		
	//closing session
	session.getTransaction().commit();
	System.out.println("Statement Worked!");
	session.close();

	
	return t;
	}
	
	public Training getTrainingByNameAndDesc(String name, String desc)
	{
		
	//opening session
	Session session = Main.sessionFactory.getCurrentSession();
	session.beginTransaction();
	List<Training> lijst = new ArrayList<Training>();
	
	@SuppressWarnings("unchecked")
	Query<Training> query = session.createQuery("FROM Training WHERE trainingName = :i AND trainingSummary = :e");

	query.setParameter("i", name);
	query.setParameter("e", desc);
	
	lijst = query.list();
	
		
		
	//closing session
	session.getTransaction().commit();
	System.out.println("Statement Worked!");
	session.close();

	
	return lijst.get(lijst.size()-1);
	}

}
