package db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import gui.Main;
import logic.Location;

public class LocationDAO {
	
	public void addLocation(Location location)
	{
		
	//opening session
	Session session = Main.sessionFactory.getCurrentSession();
	session.beginTransaction();
	
	
	session.save(location);
		
		
	//closing session
	session.getTransaction().commit();
	System.out.println("Statement Worked!");
	session.close();

		
	}
	
	public Location getLocationById(int id)
	{
		
	//opening session
	Session session = Main.sessionFactory.getCurrentSession();
	session.beginTransaction();
	
	Location l = new Location();
	

	l = (Location)session.get(Location.class, id);
		
		
	//closing session
	session.getTransaction().commit();
	System.out.println("Statement Worked!");
	session.close();

	
	return l;
	}
	
	
	public Location getLocationByAddressId(int id)
	{
		
	//opening session
	Session session = Main.sessionFactory.getCurrentSession();
	session.beginTransaction();
	
	@SuppressWarnings("unchecked")
	Query<Location> query = session.createQuery("FROM Location WHERE addressId = :a");
	query.setParameter("a",id);
	Location l = (Location) query.uniqueResult();
		
	//closing session
	session.getTransaction().commit();
	System.out.println("Statement Worked!");
	session.close();

	
	return l;
	}
	
	public Location getLocationName(String name)
	{
		
	//opening session
	Session session = Main.sessionFactory.getCurrentSession();
	session.beginTransaction();

	Query query = session.createQuery("FROM Location WHERE locationName Like '%"+name+"%'");
	Location a = (Location) query.uniqueResult();
		
		
	//closing session
	session.getTransaction().commit();
	System.out.println("Statement Worked!");
	session.close();

	return a;
	}

}
