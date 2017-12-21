package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import gui.Main;
import logic.Training;

public class UserDAO {
	
	public List<String> getAll()
	{
		
	//opening session
	
	Session session = Main.sessionFactory.getCurrentSession();
	session.beginTransaction();
	
	
	@SuppressWarnings("unchecked")
	Query<String> query = session.createNativeQuery("SELECT name FROM users");
	
	List<String> lijst = query.list();
		
		
	//closing session
	session.getTransaction().commit();
	System.out.println("Statement Worked!");
	session.close();
	
	
	return lijst;
	}
	
	public String getAllFollowing(int id)
	{
		
	//opening session
	
	Session session = Main.sessionFactory.getCurrentSession();
	session.beginTransaction();
	
	
	@SuppressWarnings("unchecked")
	Query<String> query = session.createNativeQuery("SELECT name FROM users where id = :i");
	query.setParameter("i", id);
	
	String pers = query.uniqueResult();
		
		
	//closing session
	session.getTransaction().commit();
	System.out.println("Statement Worked!");
	session.close();
	
	
	return pers;
	}
	

}
