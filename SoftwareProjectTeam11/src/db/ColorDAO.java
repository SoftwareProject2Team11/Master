package db;

import org.hibernate.Session;
import org.hibernate.query.Query;

import gui.Main;
import logic.Color;
import logic.Training;


public class ColorDAO {
	
	public void updateColor(String c)
	{
			 //Open Session
			 Session session = Main.sessionFactory.getCurrentSession();
			 session.beginTransaction();
			
			 //Statement
			 @SuppressWarnings("unchecked")
			 Query<Color> query = session.createNativeQuery("UPDATE Color set kleur = :kl " );
			 query.setParameter("kl", c);
			 query.executeUpdate();

			 
			 //Close Session
			 session.getTransaction().commit();
			 System.out.println("Statement Worked !");
			 session.close();
	}
	
	public String getColor()
	{	
		//opening session
		Session session = Main.sessionFactory.getCurrentSession();
		session.beginTransaction();
	
		
		//query
		@SuppressWarnings("unchecked")
		//Query<String> query = session.createQuery("FROM Color");	
		Query<String> query = session.createNativeQuery("SELECT kleur FROM Color");
		String s = query.uniqueResult();
		
		//closing session
		session.getTransaction().commit();
		System.out.println("Statement Worked!");
		session.close();


		return s;
	}

}
