package logic;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.CriteriaQuery;

public class TrainingDAO {
	
	public ArrayList<Training> getAll() {
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();	
		
		ArrayList<Training> trainings = new ArrayList<Training>();
		Training t = new Training();
		t = (Training)session.get(Training.class,session);
		trainings.add(t);
		
		session.getTransaction().commit();
		session.close();
		sessionfactory.close();
		
		return trainings;
	}
	
	public void addTraining(int trainingId, Time duration, String summary, Date date, boolean visibility, String trainingName) {
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();	
		
		Training t = new Training();
		t.setTraining(trainingId, duration, summary, date, visibility, trainingName);
		session.save(t);
		
		session.getTransaction().commit();
		session.close();
		sessionfactory.close();
	}
	
	public Training getTrainingById(int trainingId) {
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();	
		
		Training t = new Training();
		t = (Training)session.get(Training.class, trainingId);
		
		session.getTransaction().commit();
		session.close();
		sessionfactory.close();
		
		return t;
	}
	
	public Training getTrainingByDuration(Time duration) {
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();	
		
		Training t = new Training();
		t = (Training)session.get(Training.class, duration);
		
		session.getTransaction().commit();
		session.close();
		sessionfactory.close();
		
		return t;
	}
	
	public Training getTrainingBySummary(String summary) {
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();	
		
		Training t = new Training();
		t = (Training)session.get(Training.class, summary);
		
		session.getTransaction().commit();
		session.close();
		sessionfactory.close();
		
		return t;
	}
	
	public Training getTrainingByDate(Date date) {
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();	
		
		Training t = new Training();
		t = (Training)session.get(Training.class, date);
		
		session.getTransaction().commit();
		session.close();
		sessionfactory.close();
		
		return t;
	}
	
	public Training getTrainingByVisibility(boolean visibility) {
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();	
		
		Training t = new Training();
		t = (Training)session.get(Training.class, visibility);
		
		session.getTransaction().commit();
		session.close();
		sessionfactory.close();
		
		return t;
	}
	
	public Training getTrainingByTrainingName(String trainingName) {
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();	
		
		Training t = new Training();
		t = (Training)session.get(Training.class, trainingName);
		
		session.getTransaction().commit();
		session.close();
		sessionfactory.close();
		
		return t;
	}
	
	// Voor gui
	public void addTrainingWithConstructor(Training t) {
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();	
		
		
		session.save(t);
		
		session.getTransaction().commit();
		session.close();
		sessionfactory.close();
	}
}
