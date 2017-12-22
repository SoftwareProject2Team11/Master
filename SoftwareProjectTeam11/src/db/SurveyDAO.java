/*package db;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import logic.Survey;

public class SurveyDAO {

	public List<Survey>getSurveyAll(){
		
		//Open Session
		 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		 Session session = sessionfactory.openSession();
		 session.beginTransaction();
		 
		 //Statement
		 Query query = session.createQuery("from Survey");
		 List<Survey> surveys = query.list();
		 
		 
		 //Close Session
		 session.getTransaction().commit();
		 System.out.println("Statement Worked !");
		 session.close();
		 sessionfactory.close();

		 return surveys;
	}
	
	public void addNewSurvey(Survey survey) {
		//Open Session
		 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		 Session session = sessionfactory.openSession();
		 session.beginTransaction();
		
		//Statement
		 session.save(survey);
		 
		 //Close Session
		 session.getTransaction().commit();
		 System.out.println("Statement Worked !");
		 session.close();
		 sessionfactory.close();
		
	}
	
	public Survey getSurveyById(int id)
	{
		//Open Session
		 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		 Session session = sessionfactory.openSession();
		 session.beginTransaction();
		 
		 //Statement
		 Survey survey = new Survey();
		 survey = (Survey) session.get(Survey.class,id);
		 
		//Close Session
		 session.getTransaction().commit();
		 System.out.println("Statement Worked !");
		 session.close();
		 sessionfactory.close();
		
		 return survey;
		
	}

	public void updateSurveyDescription(int surveyId, String newSurveyDesc) {
	
		 //Open Session
		 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		 Session session = sessionfactory.openSession();
		 session.beginTransaction();
		 
		 //Statement
		 Survey survey = new Survey();
		 survey = (Survey) session.get(Survey.class, surveyId);
		 survey.setSurveyDescription(newSurveyDesc);
		 session.update(survey);
		 
		 //Close Session
		 session.getTransaction().commit();
		 System.out.println("Statement Worked !");
		 session.close();
		 sessionfactory.close();
	}
}
	
*/