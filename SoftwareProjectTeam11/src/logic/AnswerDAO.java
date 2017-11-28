package logic;

import java.util.Iterator;
import java.util.List;

//REMARKS!
//In de database moet result omgezet worden naar een BOOLEAN, momenteel is dit een DOUBLE!
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class AnswerDAO {
	
	
	 void getAnswerNameById(int answerId) { 
		 
		 //Open Session
		 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		 Session session = sessionfactory.openSession();
		 session.beginTransaction();
		 
		 //Statement
		 Answer answer = new Answer();
		 answer = (Answer) session.get(Answer.class, answerId);
		 System.out.println("The Answere with id " + answerId + " is " + answer.getAnswerName()); 
		 
		 //Close Session
		 session.getTransaction().commit();
		 System.out.println("Statement Worked !");
		 session.close();
		 sessionfactory.close();
	 }
	 
	 void addNewAnswer(String answerName, boolean result) { 
		 
		 //Open Session
		 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		 Session session = sessionfactory.openSession();
		 session.beginTransaction();
		 
		//Statement
		 Answer newAnswer = new Answer(answerName, result);
		 session.save(newAnswer);
		 
		//Close Session
		 session.getTransaction().commit();
		 System.out.println("Statement Worked !");
		 session.close();
		 sessionfactory.close();
	 }
	 

	
	public List<Answer> getAnswerAll(){
		 
		 //Open Session
		 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		 Session session = sessionfactory.openSession();
		 session.beginTransaction();
		 
		 //Statement
		 Query query = session.createQuery("from Answer");
		 List<Answer> answs= query.list();
		 
		 
		 //Close Session
		 
		 session.getTransaction().commit();
		 System.out.println("Statement Worked !");
		 session.close();
		 sessionfactory.close();
		
		 return answs;
		 
	 }
	 

	 void updateAnswerResult(int answerId, boolean newResult) { //CHECK THIS AGAIN result must first be changed to Boolean
		 
		 //Open Session
		 
		 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		 Session session = sessionfactory.openSession();
		 session.beginTransaction();
		 
		 
		 //Statement
		 
		 Answer answer = new Answer();
		 answer = (Answer) session.get(Answer.class, answerId);
		 answer.setResult(newResult);
		 session.update(answer);
		 
		 
		 //Close Session
		
		 session.getTransaction().commit();
		 System.out.println("Statement Worked !");
		 session.close();
		 sessionfactory.close();
	 }
	
	 
	 void updateAnswerName(int answerId, String answerName){
		 
		 //Open Session
		 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		 Session session = sessionfactory.openSession();
		 session.beginTransaction();
		 
		 //Statement
		 
		 Answer answer = (Answer) session.get(Answer.class, answerId);
		 answer.setAnswerName(answerName);
		  
		 //Close Session
		 
		 session.getTransaction().commit();
		 System.out.println("Statement Worked !");
		 session.close();
		 sessionfactory.close();
		 
	 }

}
