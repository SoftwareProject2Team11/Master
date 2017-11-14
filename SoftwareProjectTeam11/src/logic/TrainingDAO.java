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
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session s = sessionFactory.openSession();
	public TrainingDAO()
	{
	s.beginTransaction();	
	}
	
	public ArrayList<Training> getAll() {
		ArrayList<Training> trainings = new ArrayList<Training>();
		Training t = new Training();
		t = (Training)s.get(Training.class);
		trainings.add(t);
		return trainings;
	}
	
	public void addTraining(int trainingId, Time duration, String summary, Date date, boolean visibility, String trainingName) {
		Training t = new Training();
		t.setTraining(trainingId, duration, summary, date, visibility, trainingName);
		s.save(t);
	}
	
	public Training getTrainingById(int trainingId) {
		Training t = new Training();
		t = (Training)s.get(Training.class, trainingId);
		return t;
	}
	
	public Training getTrainingByDuration(Time duration) {
		Training t = new Training();
		t = (Training)s.get(Training.class, duration);
		return t;
	}
	
	public Training getTrainingBySummary(String summary) {
		Training t = new Training();
		t = (Training)s.get(Training.class, summary);
		return t;
	}
	
	public Training getTrainingByDate(Date date) {
		Training t = new Training();
		t = (Training)s.get(Training.class, date);
		return t;
	}
	
	public Training getTrainingByVisibility(boolean visibility) {
		Training t = new Training();
		t = (Training)s.get(Training.class, visibility);
		return t;
	}
	
	public Training getTrainingByTrainingName(String trainingName) {
		Training t = new Training();
		t = (Training)s.get(Training.class, trainingName);
		return t;
	}
	
	public void finalize() {
		   s.getTransaction().commit();
		   s.close();
		   sessionFactory.close();
		  }
	
}
