package db;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import gui.Main;
import logic.Question;
import logic.Training;

public class QuestionDAO {

	public void addQuestion(Question q)
	{
		
	//opening session
	Session session = Main.sessionFactory.getCurrentSession();
	session.beginTransaction();
	
	
	session.save(q);
		
		
	//closing session
	session.getTransaction().commit();
	System.out.println("Statement Worked!");
	session.close();
	}
	
	public List<Question> getQuestionsByTrainingId(int id)
	{
		
	//opening session
	Session session = Main.sessionFactory.getCurrentSession();
	session.beginTransaction();
	
	
	@SuppressWarnings("unchecked")
	Query<Question> query = session.createQuery("FROM Question WHERE trainingId = :i");
	query.setParameter("i", id);
	List<Question> lijst = query.list();	
		
		
	//closing session
	session.getTransaction().commit();
	System.out.println("Statement Worked!");
	session.close();

	
	return lijst;
	}


}