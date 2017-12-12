package db;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import logic.Address;

public class AddressDAO {
	
	public void addAddress(Address address)
	{
		
	//opening session
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	
	
	session.save(address);
		
		
	//closing session
	session.getTransaction().commit();
	System.out.println("Statement Worked!");
	session.close();
	sessionFactory.close();
		
	}
	
	
	public List<Address> getAllAddress()
	{
		
	//opening session
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	
	
	@SuppressWarnings("unchecked")
	Query<Address> query = session.createQuery("FROM Address");
	List<Address> lijst = query.list();
		
		
	//closing session
	session.getTransaction().commit();
	System.out.println("Statement Worked!");
	session.close();
	sessionFactory.close();
	
	return lijst;
	}
	
	public Address getAddressById(int id)
	{
		
	//opening session
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	Address a = new Address();
	
	a = (Address)session.get(Address.class,id);

		
		
	//closing session
	session.getTransaction().commit();
	System.out.println("Statement Worked!");
	session.close();
	sessionFactory.close();
	
	return a;
	}
	
	public Address getAddressByStreet(String name)
	{
		
	//opening session
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	session.beginTransaction();

	@SuppressWarnings("unchecked")
	Query<Address> query = session.createQuery("FROM Address WHERE streetname Like '%"+name+"%'");
	Address a = (Address) query.uniqueResult();
		
		
	//closing session
	session.getTransaction().commit();
	System.out.println("Statement Worked!");
	session.close();
	sessionFactory.close();
	return a;
	}
}