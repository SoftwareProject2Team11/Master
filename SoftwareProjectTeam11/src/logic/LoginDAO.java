package logic;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

import org.hibernate.Session;

public class LoginDAO {

	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session s = sessionFactory.openSession();
	public LoginDAO()
	{
		
		s.beginTransaction();	
	}
	public ArrayList<Login> getAll()
	{
		ArrayList<Login>Logins = new ArrayList<Login>();
		Login l = new Login();
		l = (Login)s.get(Login.class);
		Logins.add(l);
		return Logins;
	}
	public Login getLoginByUsername(int username)
	{
		Login l = new Login();
		l = (Login)s.get(Login.class,username);
		return l;
	}
	/*dit is eigenlijk een methode die normaal gezien niet mag worden gebruikt
	public getLoginById(int id)
	{
		Login l = new Login();
		l = (Login)s.get(Login.class,id);
		return l;	
	}*/
	/*dit is eigenlijk een methode die normaal gezien niet mag worden gebruikt(ook moet het passwoord eerst geëncripteerd worden door middel van een beveiligingssleutel
	public getLoginByPassword(String passwoord)
	{
		Login l = new Login();
		l = (Login)s.get(Login.class,password);
		return l;	
	}*/
	public void finalize() {
		   s.getTransaction().commit();
		   s.close();
		   sessionFactory.close();
		  }
	
	
	
	
	
	
}
