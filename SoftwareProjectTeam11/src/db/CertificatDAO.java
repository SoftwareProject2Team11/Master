package db;


import org.hibernate.Session;
import gui.Main;
import logic.Certificat;


import org.hibernate.query.Query;

public class CertificatDAO {
	
	public void uploadCertificat(Certificat c)
	{
		//opening session
		Session session = Main.sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		//code
		session.save(c);
			
			
		//closing session
		session.getTransaction().commit();
		System.out.println("Statement Worked!");
		session.close();

	}
	
	public Certificat downloadCertificat(String name)
	{
		//opening session
		Session session = Main.sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		Query<Certificat> query = session.createQuery("FROM Certificat WHERE certificatName = :n");
		query.setParameter("n", name);
		Certificat c = query.uniqueResult();

		
		
		//closing session
		session.getTransaction().commit();
		System.out.println("Statement Worked!");
		session.close();
		
		return c;
	}
	
	

}
