/**
 * 
 */
package db;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.CriteriaQuery;

import logic.Person;

/**
 * @author Katrien
 *
 */
public class PersonDAO extends Connection{
	
	public PersonDAO()
	{
		super();
}
	public List<Person> getAll(){
		List<Person> persons;
		
	    TypedQuery<Person> query = s.createQuery("FROM Person");
	    persons = query.getResultList();
	    this.finalize();
	    return persons;
	}
	

}
