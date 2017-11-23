package logic;

import java.util.Iterator;
import java.util.List;

//REMARKS!
//In de database moet result omgezet worden naar een BOOLEAN, momenteel is dit een DOUBLE!
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class SurveyionDAO {
	
	
	 void getSurveyNameById(int surveyionId) { 
		 
		 //Open Session
		 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		 Session session = sessionfactory.openSession();
		 session.beginTransaction();
		 
		 //Statement
		 Surveyion surveyion = new Surveyion();
		 surveyion = (Surveyion) session.get(Surveyion.class, surveyionId);
		 System.out.println("The Surveyione with id " + surveyionId + " is " + surveyion.getSurveyionName()); 
		 
		 //Close Session
		 session.getTransaction().commit();
		 System.out.println("Statement Worked !");
		 session.close();
		 sessionfactory.close();
	 }
	 
	 void addNewSurvey(String surveyionName, boolean result) { 
		 
		 //Open Session
		 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		 Session session = sessionfactory.openSession();
		 session.beginTransaction();
		 
		//Statement
		 Surveyion newSurveyion = new Surveyion(surveyionName, result);
		 session.save(newSurveyion);
		 
		//Close Session
		 session.getTransaction().commit();
		 System.out.println("Statement Worked !");
		 session.close();
		 sessionfactory.close();
	 }
	 

	
	public List<Surveyion> getSurveyAll(){
		 
		 //Open Session
		 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		 Session session = sessionfactory.openSession();
		 session.beginTransaction();
		 
		 //Statement
		 Query query = session.createQuery("from Surveyion");
		 List<Surveyion> surveys= query.list();
		 
		 
		 //Close Session
		 
		 session.getTransaction().commit();
		 System.out.println("Statement Worked !");
		 session.close();
		 sessionfactory.close();
		
		 return surveys;
		 
	 }
	 

	 void updateSurveyResult(int surveyionId, boolean newResult) { //CHECK THIS AGAIN result must first be changed to Boolean
		 
		 //Open Session
		 
		 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		 Session session = sessionfactory.openSession();
		 session.beginTransaction();
		 
		 
		 //Statement
		 
		 Surveyion surveyion = new Surveyion();
		 surveyion = (Surveyion) session.get(Surveyion.class, surveyionId);
		 surveyion.setResult(newResult);
		 session.update(surveyion);
		 
		 
		 //Close Session
		
		 session.getTransaction().commit();
		 System.out.println("Statement Worked !");
		 session.close();
		 sessionfactory.close();
	 }
	
	 
	 void updateSurveyName(int surveyionId, String surveyionName){
		 
		 //Open Session
		 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		 Session session = sessionfactory.openSession();
		 session.beginTransaction();
		 
		 //Statement
		 
		 Surveyion surveyion = (Surveyion) session.get(Surveyion.class, surveyionId);
		 surveyion.setSurveyionName(surveyionName);
		  
		 //Close Session
		 
		 session.getTransaction().commit();
		 System.out.println("Statement Worked !");
		 session.close();
		 sessionfactory.close();
		 
	 }

}
