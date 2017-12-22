package db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import logic.Reminder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import org.hibernate.Session;

public class ReminderDAO {
	
	public List<Reminder> getAll(){
		
		//opening session
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		/*
		ArrayList<Reminder> reminders = new ArrayList<Reminder>();
		Reminder r = new Reminder();
		r = (Reminder) session.get(Reminder.class,session);
		reminders.add(r);
		*/
		
		//statement
		Query query = session.createQuery("From Reminder");
		List<Reminder> reminders = query.list();
		
		
		//closing session
		session.getTransaction().commit();
		System.out.println("Statement Worked !");
		session.close();
		sessionfactory.close();
		
		return reminders;
	}
	
	public void addReminder (int reminderId, Date reminderDate) {
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		
		Reminder r = new Reminder();
		r.setReminder(reminderId, reminderDate);
		session.save(r);
		
		session.getTransaction().commit();
		System.out.println("Statement Worked !");
		session.close();
		sessionfactory.close();
	}
	
	public Reminder getTrainingById(int reminderId){
		
		//opening session
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		
		//statement
		Reminder t = new Reminder();
		t = (Reminder)session.get(Reminder.class, reminderId);
		
		//closing session
		session.getTransaction().commit();
		System.out.println("Statement Worked !");
		session.close();
		sessionfactory.close();
		
		return t;
	}
	
	/*
	public Reminder getTrainingByDate( reminderDate) { //Moet naar Date veranderd worden
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		
		Reminder t = new Reminder();
		t = (Reminder)session.get(Reminder.class, reminderDate);
		
		session.getTransaction().commit();
		System.out.println("Statement Worked !");
		session.close();
		sessionfactory.close();
		
		return t;
	}
	*/
}
