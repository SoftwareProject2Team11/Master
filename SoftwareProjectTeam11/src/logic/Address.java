package logic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.Session; 
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javax.persistence.Query;

//@Entity
//@Table(name="Address")
public class Address {
	
	//@Id
	//@Column(name="addressId")
	private int AddressId;
	//@Column(name="streetname")
	private String streetname;
	//@Column(name="houseNumber)
	private int houseNumber;
	//@Column(name="city")
	private String city;
	
	public Address(String streetname, int houseNumber, String city) {
		super();
		this.streetname = streetname;
		this.houseNumber = houseNumber;
		this.city = city;
	}
	public Address(int AddressId,String streetname, int houseNumber, String city) {
		super();
		this.AddressId = AddressId;
		this.streetname = streetname;
		this.houseNumber = houseNumber;
		this.city = city;
	}
	public String getStreetname() {
		return streetname;
	}
	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}
	public int getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getAddressId() {
		return AddressId;
	}
	public void setAddressId(int AddressId) {
		this.AddressId = AddressId;
	}
	
	public boolean addAddress(Address address)
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
	
	
	Query query = session.createQuery("FROM address");
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

	Query query = session.createQuery("FROM address WHERE streetname Like '%"+name+"%'");
	Address a = query.getSingleResult();
		
		
	//closing session
	session.getTransaction().commit();
	System.out.println("Statement Worked!");
	session.close();
	sessionFactory.close();
	return a;
	}
	
}
