package db;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.query.Query;

import gui.Main;
import logic.KeyCodes;

public class KeyCodeDAO {

	public void addKeyCode(KeyCodes k) {

		// opening session
		Session session = Main.sessionFactory.getCurrentSession();
		session.beginTransaction();

		
		session.save(k);

		// closing session
		session.getTransaction().commit();
		System.out.println("Statement Worked!");
		session.close();

	}

	public List<KeyCodes> getAll() {
		Session session = Main.sessionFactory.getCurrentSession();
		session.beginTransaction();

		@SuppressWarnings("unchecked")
		Query<KeyCodes> query = session.createQuery("FROM KeyCodes WHERE used = 0");

		List<KeyCodes> lijst = query.list();

		// closing session
		session.getTransaction().commit();
		System.out.println("Statement Worked!");
		session.close();

		return lijst;
	}

}
