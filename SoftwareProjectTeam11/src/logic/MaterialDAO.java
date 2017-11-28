package logic;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.ArrayList;

import org.hibernate.Session;




public class MaterialDAO {

	
	
		
	public ArrayList<Material> getAll()
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();
		
		s.beginTransaction();
		
		ArrayList<Material>Materials = new ArrayList<Material>();
		Material m = new Material();
		m = (Material)s.get(Material.class,s);
		Materials.add(m);

		   s.getTransaction().commit();
		   s.close();
		   sessionFactory.close();
		
		   return Materials;
	}
	public Material getItemById(int id)
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();
		
		s.beginTransaction();
		
		Material m = new Material();
		m = (Material)s.get(Material.class,id);

		   s.getTransaction().commit();
		   s.close();
		   sessionFactory.close();
		
		   return m;
	}
	public ArrayList<Material> getItemBytitle(String title)
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();
		
		s.beginTransaction();
		
		ArrayList<Material>Materials = new ArrayList<Material>();
		Material m = new Material();
		m = (Material)s.get(Material.class,title);
		Materials.add(m);

		   s.getTransaction().commit();
		   s.close();
		   sessionFactory.close();
		
		   return Materials;
	}
	public Material getItemByISBN(int ISBN)
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();
		
		s.beginTransaction();
		
		Material m = new Material();
		m = (Material)s.get(Material.class,ISBN);

		   s.getTransaction().commit();
		   s.close();
		   sessionFactory.close();
		
		   return m;
	}
	public ArrayList<Material> getMaterialByAuthor(String author)
	{
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();
		
		s.beginTransaction();
		
		ArrayList<Material>MaterialsA = new ArrayList<Material>();
		
		Material m = new Material();
		m = (Material)s.get(Material.class,author);
		MaterialsA.add(m);

		   s.getTransaction().commit();
		   s.close();
		   sessionFactory.close();
		
		   return MaterialsA;
		
	}
	public void addMaterial(String title,int ISBN, String author)
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();
		
		s.beginTransaction();
		
		Material m = new Material();
		m.setMaterial(title, ISBN, author);
		s.save(m);

		   s.getTransaction().commit();
		   s.close();
		   sessionFactory.close();
	}
	public void updateTitle(int id,String title)
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();
		
		s.beginTransaction();
		
		Material m = (Material) s.load(Material.class, id);
		m.setTitle(title);

		   s.getTransaction().commit();
		   s.close();
		   sessionFactory.close();
	}
	public void updateISBN(int id,int ISBN)
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();
		
		s.beginTransaction();
		
		Material m = (Material) s.load(Material.class, id);
		m.setISBN(ISBN);

		   s.getTransaction().commit();
		   s.close();
		   sessionFactory.close();
	}
	public void updateauthor(int id,String author)
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();
		
		s.beginTransaction();
		
		Material m = (Material) s.load(Material.class, id);
		m.setAuthor(author);

		   s.getTransaction().commit();
		   s.close();
		   sessionFactory.close();
	}
		
}
