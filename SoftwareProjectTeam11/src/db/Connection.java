package db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Connection {
	SessionFactory sessionFactory;
	Session s;
	
	public void openConnection() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
		s = sessionFactory.openSession();
		s.beginTransaction();	
	}
	
	public void finalize() {
		   s.getTransaction().commit();
		   s.close();
		   sessionFactory.close();
		  }
	
}
