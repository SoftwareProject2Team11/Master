package logic;

import java.util.Iterator;
import java.util.List;

//REMARKS!
//In de database moet result omgezet worden naar een BOOLEAN, momenteel is dit een DOUBLE!
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class CertificatDAO {
	
	
	 void getCertNameById(int certificatId) { 
		 
		 //Open Session
		 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		 Session session = sessionfactory.openSession();
		 session.beginTransaction();
		 
		 //Statement
		 Certificat c = new Certificat();
		 c = (Certificat) session.get(Certificat.class, certificatId);
		 
		 
		 //Close Session
		 session.getTransaction().commit();
		 System.out.println("Statement Worked !");
		 session.close();
		 sessionfactory.close();
	 }
	 
	 void addNewCert(Certificat certificat) { 
		 
		 //Open Session
		 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		 Session session = sessionfactory.openSession();
		 session.beginTransaction();
		 
		//Statement
		
		 session.save(certificat);
		 
		//Close Session
		 session.getTransaction().commit();
		 System.out.println("Statement Worked !");
		 session.close();
		 sessionfactory.close();
	 }
	 

	
	public List<Certificat> getCertAll(){
		 
		 //Open Session
		 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		 Session session = sessionfactory.openSession();
		 session.beginTransaction();
		 
		 //Statement
		 Query query = session.createQuery("from Certificat");
		 List<Certificat> certifs= query.list();
		 
 	/* System.out.println("Total Number Of Records: " +list.size());	
 	 * 
		 Iterator it = list.iterator();
		 
		 while(it.hasNext())
		 {
			 Object o = ( Object)it.next();
			 Certificat c = (Certificat) o;
			 System.out.println("Certificate ID : "+c.getCertificatId());
			 System.out.println("Certificate Name : "+c.getCertificatName());
			 System.out.println("Certificate Result (0 = failed & 1 = passed) : "+c.isResult());
			 System.out.println("----------------------------------------------------");
			 }
	*/
		 
		 
		 //Close Session
		 session.getTransaction().commit();
		 System.out.println("Statement Worked !");
		 session.close();
		 sessionfactory.close();
		
		 return certifs;
		 
	 }
	 
/*
	 void updateCertResult(int certificatId, int newResult) { 
		 
		 //Open Session
		 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		 Session session = sessionfactory.openSession();
		 session.beginTransaction();
		 
		 //Statement
		 
		 Certificat certificat = new Certificat();
		certificat = (Certificat) session.get(Certificat.class, certificatId);
		certificat.setResult(newResult);
		session.update(certificat);
		 
		 
		 //Close Session
		 session.getTransaction().commit();
		 System.out.println("Statement Worked !");
		 session.close();
		 sessionfactory.close();
	 }
	
	 */
	 void updateCertName(int certificatId, String certificatName){
		 
		 //Open Session
		 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		 Session session = sessionfactory.openSession();
		 session.beginTransaction();
		 
		 //Statement
		 
		 Certificat certificat = (Certificat) session.get(Certificat.class, certificatId);
		 certificat.setCertificatName(certificatName);
		  
		//Close Session
		 session.getTransaction().commit();
		 System.out.println("Statement Worked !");
		 session.close();
		 sessionfactory.close();
		 
	 }

}
