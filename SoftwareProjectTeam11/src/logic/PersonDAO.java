/**
 * 
 */
package logic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Katrien
 *
 */
public class PersonDAO {
	SessionFactory sessionFactory;
	Session s;
	
	public PersonDAO()
	{
		super();
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
