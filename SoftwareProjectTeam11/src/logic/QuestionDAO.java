package logic;

import java.util.Iterator;
import java.util.List;

//REMARKS!
//In de database moet result omgezet worden naar een BOOLEAN, momenteel is dit een DOUBLE!
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class QuestionDAO {
	
	
	 void getQuestNameById(int questionId) { 
		 
		 //Open Session
		 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		 Session session = sessionfactory.openSession();
		 session.beginTransaction();
		 
		 //Statement
		 Question question = new Question();
		 question = (Question) session.get(Question.class, questionId);
		 System.out.println("The Questione with id " + questionId + " is " + question.getQuestionName()); 
		 
		 //Close Session
		 session.getTransaction().commit();
		 System.out.println("Statement Worked !");
		 session.close();
		 sessionfactory.close();
	 }
	 
	 void addNewQuest(String questionName, boolean result) { 
		 
		 //Open Session
		 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		 Session session = sessionfactory.openSession();
		 session.beginTransaction();
		 
		//Statement
		 Question newQuestion = new Question(questionName, result);
		 session.save(newQuestion);
		 
		//Close Session
		 session.getTransaction().commit();
		 System.out.println("Statement Worked !");
		 session.close();
		 sessionfactory.close();
	 }
	 

	
	public List<Question> getQuestAll(){
		 
		 //Open Session
		 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		 Session session = sessionfactory.openSession();
		 session.beginTransaction();
		 
		 //Statement
		 Query query = session.createQuery("from Question");
		 List<Question> quests= query.list();
		 
		 
		 //Close Session
		 
		 session.getTransaction().commit();
		 System.out.println("Statement Worked !");
		 session.close();
		 sessionfactory.close();
		
		 return quests;
		 
	 }
	 

	 void updateQuestResult(int questionId, boolean newResult) { //CHECK THIS AGAIN result must first be changed to Boolean
		 
		 //Open Session
		 
		 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		 Session session = sessionfactory.openSession();
		 session.beginTransaction();
		 
		 
		 //Statement
		 
		 Question question = new Question();
		 question = (Question) session.get(Question.class, questionId);
		 question.setResult(newResult);
		 session.update(question);
		 
		 
		 //Close Session
		
		 session.getTransaction().commit();
		 System.out.println("Statement Worked !");
		 session.close();
		 sessionfactory.close();
	 }
	
	 
	 void updateQuestName(int questionId, String questionName){
		 
		 //Open Session
		 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		 Session session = sessionfactory.openSession();
		 session.beginTransaction();
		 
		 //Statement
		 
		 Question question = (Question) session.get(Question.class, questionId);
		 question.setQuestionName(questionName);
		  
		 //Close Session
		 
		 session.getTransaction().commit();
		 System.out.println("Statement Worked !");
		 session.close();
		 sessionfactory.close();
		 
	 }

}
