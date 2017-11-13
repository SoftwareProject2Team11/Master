/**
 * 
 */
package logic;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.CriteriaQuery;

/**
 * @author Katrien
 *
 */
public class PersonDAO extends Connection{
	
	public PersonDAO()
	{
		super();
}
	public ArrayList<Person> getAll(){
		ArrayList<Person> persons = new ArrayList<Person>();
		
			Person person = (Person)s.get(Person.class);
			persons.add(person);
	}
	/*
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
	}*/
	

}
