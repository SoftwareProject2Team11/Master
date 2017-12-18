package db;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import gui.Main;
import logic.Answer;
import logic.Question;

public class AnswerDAO {

	public void addAnswer(Answer a)
	{
		
	//opening session
	Session session = Main.sessionFactory.getCurrentSession();
	session.beginTransaction();
	
	
	session.save(a);
		
		
	//closing session
	session.getTransaction().commit();
	System.out.println("Statement Worked!");
	session.close();
	}
	
	public List<Answer> getAnswers(int id)
	{
		
	//opening session
	Session session = Main.sessionFactory.getCurrentSession();
	session.beginTransaction();
	
	
	@SuppressWarnings("unchecked")
	Query<Answer> query = session.createQuery("FROM Answer WHERE questionId = :i");
	query.setParameter("i", id);
	List<Answer> lijst = query.list();	
		
		
	//closing session
	session.getTransaction().commit();
	System.out.println("Statement Worked!");
	session.close();

	
	return lijst;
	}
}
