package logic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class LocationDAO {
	
	public void addLocation(Location location)
	{
		
	//opening session
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	
	
	session.save(location);
		
		
	//closing session
	session.getTransaction().commit();
	System.out.println("Statement Worked!");
	session.close();
	sessionFactory.close();
		
	}
	
	public Location getLocationById(int id)
	{
		
	//opening session
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	
	Location l = new Location();
	

	l = (Location)session.get(Location.class, id);
		
		
	//closing session
	session.getTransaction().commit();
	System.out.println("Statement Worked!");
	session.close();
	sessionFactory.close();
	
	return l;
	}
	
	public Location getLocationName(String name)
	{
		
	//opening session
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	session.beginTransaction();

	Query query = session.createQuery("FROM Location WHERE locationName Like '%"+name+"%'");
	Location a = (Location) query.uniqueResult();
		
		
	//closing session
	session.getTransaction().commit();
	System.out.println("Statement Worked!");
	session.close();
	sessionFactory.close();
	return a;
	}

}
