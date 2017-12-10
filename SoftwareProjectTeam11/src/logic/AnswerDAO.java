package logic;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class AnswerDAO {

	
	public List<Answer> getAnswerAll(){
		
		//Open Session
		
		 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		 Session session = sessionfactory.openSession();
		 session.beginTransaction();
		 
		 //Statement
		 
		 Query query = session.createQuery("from Answer");
		 List<Answer> answers = query.list();
		 
		 
		 //Close Session
		 
		 session.getTransaction().commit();
		 System.out.println("Statement Worked !");
		 session.close();
		 sessionfactory.close();

		 return answers;
	}
	
	public void addNewAnswer(Answer answer) {

		
		//Open Session
		
		 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		 Session session = sessionfactory.openSession();
		 session.beginTransaction();
		
		//Statement
		 
		 session.save(answer);
		 
		 //Close Session
		 
		 session.getTransaction().commit();
		 System.out.println("Statement Worked !");
		 session.close();
		 sessionfactory.close();
		
	}
	
	public Answer getAnswerById(int id)
	{
		//Open Session
		
		 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		 Session session = sessionfactory.openSession();
		 session.beginTransaction();
		 
		 //Statement
		 
		 Answer answer = new Answer();
		 answer = (Answer) session.get(Answer.class,id);
		 
		//Close Session
		 
		 session.getTransaction().commit();
		 System.out.println("Statement Worked !");
		 session.close();
		 sessionfactory.close();
		
		 return answer;
		
	}

	public void updateAnswer(int answerId, String newAnswer) {
		
		 //Open Session
		
		 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		 Session session = sessionfactory.openSession();
		 session.beginTransaction();
		 
		 //Statement
		 
		 Answer answer = new Answer();
		 answer = (Answer) session.get(Answer.class, answerId);
		 answer.setAnswer(newAnswer);
		 session.update(answer);
		 
		 //Close Session
		 
		 session.getTransaction().commit();
		 System.out.println("Statement Worked !");
		 session.close();
		 sessionfactory.close();
	}
}
