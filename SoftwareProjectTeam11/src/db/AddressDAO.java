package db;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import gui.Main;
import logic.Address;

public class AddressDAO {
	
	public void addAddress(String street, int n, String cty)
	{
		
	//opening session
	Session session = Main.sessionFactory.getCurrentSession();
	session.beginTransaction();
	
	
	
	Query query = session.createNativeQuery("INSERT INTO Address VALUES (null, :name , :number , :city , 1, 0.0, 0.0 ) ");
	query.setParameter("name", street);
	query.setParameter("number", n);
	query.setParameter("city", cty);
	query.executeUpdate();
		
		
	//closing session
	session.getTransaction().commit();
	System.out.println("Statement Worked!");
	session.close();	
	}
	
	
	public List<Address> getAllAddress()
	{
		
	//opening session
		Session session = Main.sessionFactory.getCurrentSession();
	session.beginTransaction();
	
	
	@SuppressWarnings("unchecked")
	Query<Address> query = session.createQuery("FROM Address");
	List<Address> lijst = query.list();
		
		
	//closing session
	session.getTransaction().commit();
	System.out.println("Statement Worked!");
	session.close();
 
	
	return lijst;
	}
	
	public Address getAddressById(int id)
	{
		
	//opening session
		Session session = Main.sessionFactory.getCurrentSession();
	session.beginTransaction();
	Address a = new Address();
	
	a = (Address)session.get(Address.class,id);

		
		
	//closing session
	session.getTransaction().commit();
	System.out.println("Statement Worked!");
	session.close();
 
	
	return a;
	}
	
	public Address getAddressByStreet(String name)
	{
		
	//opening session
		Session session = Main.sessionFactory.getCurrentSession();
	session.beginTransaction();

	@SuppressWarnings("unchecked")
	Query<Address> query = session.createQuery("FROM Address WHERE streetname Like :nam ");
	query.setParameter("nam", "%"+name+"%");
	List<Address> lijst = query.list();
		
		
	//closing session
	session.getTransaction().commit();
	System.out.println("Statement Worked!");
	session.close();
 
	return lijst.get(lijst.size()-1);
	}
}