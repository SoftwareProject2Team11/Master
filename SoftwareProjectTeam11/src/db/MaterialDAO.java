package db;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import logic.Address;
import logic.Material;

import java.util.ArrayList;

import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import gui.Main;

public class MaterialDAO {
	
	
	public void addMaterial(Material m)
	{
		// opening session
		Session session = Main.sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		session.save(m);	
		// closing session
		session.getTransaction().commit();
		System.out.println("Statement Worked!");
		session.close();		
	}

	public List<Material> getAll() {
		// opening session
		Session session = Main.sessionFactory.getCurrentSession();
		session.beginTransaction();

		@SuppressWarnings("unchecked")
		Query<Material> q = session.createQuery("FROM Material");
		List<Material> Materials = q.list();

		// closing session
		session.getTransaction().commit();
		System.out.println("Statement Worked!");
		session.close();

		return Materials;
	}

	public Material getMaterialByTrainingId(int trainingId) {
		// opening session
		Session session = Main.sessionFactory.getCurrentSession();
		session.beginTransaction();

		@SuppressWarnings("unchecked")
		Query<Material> query = session.createQuery("FROM Material WHERE trainingId = :id");
		query.setParameter("id", trainingId);
		Material a = (Material) query.uniqueResult();

		// closing session
		session.getTransaction().commit();
		System.out.println("Statement Worked!");
		session.close();
		
		return a;
	}

}
