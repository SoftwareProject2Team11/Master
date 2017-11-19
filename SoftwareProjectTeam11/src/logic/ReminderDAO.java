package logic;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

public class ReminderDAO {
	
	public ArrayList<Reminder> getAll(){
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		
		ArrayList<Reminder> reminders = new ArrayList<Reminder>();
		Reminder r = new Reminder();
		r = (Reminder) session.get(Reminder.class,session);
		reminders.add(r);
		
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
	
	public Reminder getTrainingById(int reminderId) {
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		
		Reminder t = new Reminder();
		t = (Reminder)session.get(Reminder.class, reminderId);
		
		session.getTransaction().commit();
		System.out.println("Statement Worked !");
		session.close();
		sessionfactory.close();
		
		return t;
	}
	
	public Reminder getTrainingByDate(int reminderDate) {
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
}
