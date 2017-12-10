package logic;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class QuestionDAO {

	public List<Question>getQuestionAll(){
		
		//Open Session
		 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		 Session session = sessionfactory.openSession();
		 session.beginTransaction();
		 
		 //Statement
		 Query query = session.createQuery("from Question");
		 List<Question> questions = query.list();
		 
		//Close Session
		 session.getTransaction().commit();
		 System.out.println("Statement Worked !");
		 session.close();
		 sessionfactory.close();

		 return questions;
	}
	
	public void addNewQuestion(Question question) {
		
		//Open Session
		 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		 Session session = sessionfactory.openSession();
		 session.beginTransaction();
		
		//Statement
		 session.save(question);
		 
		//Close Session
		session.getTransaction().commit();
		System.out.println("Statement Worked !");
		session.close();
		sessionfactory.close();
	}
	
	public Question getQuestionById(int id) {
		
		//Open Session
		 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		 Session session = sessionfactory.openSession();
		 session.beginTransaction();
		 
		 //Statement
		 Question question =  new Question();
		 question = (Question) session.get(Question.class, id);
		 
		 
		//Close Session
		 session.getTransaction().commit();
		 System.out.println("Statement Worked !");
		 session.close();
		 sessionfactory.close();
		 
		 return question;
		 
	}
	
	public void updateQuestion(int questionId, String newQuestion) {
		
		//Open Session
		 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		 Session session = sessionfactory.openSession();
		 session.beginTransaction();
		 
		 //Statement
		 Question question = new Question();
		 question = (Question) 
				 	session.get(Question.class, questionId);
		 question.setQuestion(newQuestion);
		 session.update(question);
		 
		//Close Session
		 session.getTransaction().commit();
		 System.out.println("Statement Worked !");
		 session.close();
		 sessionfactory.close();
	}


}