package logic;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.ArrayList;

import org.hibernate.Session;




public class MaterialDAO {

	
	
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();
		public MaterialDAO()
		{
		s.beginTransaction();	
		}
	public ArrayList<Material> getAll()
	{
		ArrayList<Material>Materials = new ArrayList<Material>();
		Material m = new Material();
		m = (Material)s.get(Material.class,s);
		Materials.add(m);
		return Materials;
	}
	public Material getItemById(int id)
	{
		Material m = new Material();
		m = (Material)s.get(Material.class,id);
		return m;
	}
	public ArrayList<Material> getItemBytitle(String title)
	{
		ArrayList<Material>Materials = new ArrayList<Material>();
		Material m = new Material();
		m = (Material)s.get(Material.class,title);
		Materials.add(m);
		return Materials;
	}
	public Material getItemByISBN(int ISBN)
	{
		Material m = new Material();
		m = (Material)s.get(Material.class,ISBN);
		return m;
	}
	public ArrayList<Material> getMaterialByAuthor(String author)
	{
		ArrayList<Material>MaterialsA = new ArrayList<Material>();
		Material m = new Material();
		m = (Material)s.get(Material.class,author);
		MaterialsA.add(m);
		return MaterialsA;
	}
	public void addMaterial(String title,int ISBN, String author)
	{
		Material m = new Material();
		m.setMaterial(title, ISBN, author);
		s.save(m);
	}
	public void updateTitle(int id,String title)
	{
		Material m = (Material) s.load(Material.class, id);
		m.setTitle(title);
		
	}
	public void updateISBN(int id,int ISBN)
	{
		Material m = (Material) s.load(Material.class, id);
		m.setISBN(ISBN);
		
	}
	public void updateauthor(int id,String author)
	{
		Material m = (Material) s.load(Material.class, id);
		m.setAuthor(author);
		
	}
		
	public void finalize() {
		   s.getTransaction().commit();
		   s.close();
		   sessionFactory.close();
		  }
}
