package logic;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

import org.hibernate.Session;

public class LoginDAO {

	
	
	
	public ArrayList<Login> getAll()
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();
		
		s.beginTransaction();
		
		ArrayList<Login>Logins = new ArrayList<Login>();
		Login l = new Login();
		l = (Login)s.get(Login.class,s);
		Logins.add(l);
		
		   s.getTransaction().commit();
		   s.close();
		   sessionFactory.close();
		return Logins;
	}
	public Login getLoginByUsername(int username)
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();
		
		s.beginTransaction();
		
		Login l = new Login();
		l = (Login)s.get(Login.class,username);
		
		s.getTransaction().commit();
		   s.close();
		   sessionFactory.close();
		
		   return l;
	}
	/*dit is eigenlijk een methode die normaal gezien niet mag worden gebruikt
	public getLoginById(int id)
	{
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session s = sessionFactory.openSession();
	
	s.beginTransaction();
	
		Login l = new Login();
		l = (Login)s.get(Login.class,id);
		
		   s.getTransaction().commit();
		   s.close();
		   sessionFactory.close();
		
		return l;	
	}*/
	/*dit is eigenlijk een methode die normaal gezien niet mag worden gebruikt(ook moet het passwoord eerst geëncripteerd worden door middel van een beveiligingssleutel
	public getLoginByPassword(String passwoord)
	{
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session s = sessionFactory.openSession();
		
		s.beginTransaction();
		
		Login l = new Login();
		l = (Login)s.get(Login.class,password);
		
		   s.getTransaction().commit();
		   s.close();
		   sessionFactory.close();
		
		return l;	
	}*/
	
	
	
	
	
}
