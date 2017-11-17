package logic;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

public class ReminderDAO {
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session s = sessionFactory.openSession();
	public ReminderDAO(){
		s.beginTransaction();	
	}
	
	public ArrayList<Reminder> getAll(){
		ArrayList<Reminder> reminders = new ArrayList<Reminder>();
		Reminder r = new Reminder();
		r = (Reminder) s.get(Reminder.class,s);
		reminders.add(r);
		return reminders;
	}
	
	public void addReminder (int reminderId, Date reminderDate) {
		Reminder r = new Reminder();
		r.setReminder(reminderId, reminderDate);
		s.save(r);
	}
	
	public Reminder getTrainingById(int reminderId) {
		Reminder t = new Reminder();
		t = (Reminder)s.get(Reminder.class, reminderId);
		return t;
	}
	
	public Reminder getTrainingByDate(int reminderDate) {
		Reminder t = new Reminder();
		t = (Reminder)s.get(Reminder.class, reminderDate);
		return t;
	}
	
	public void finalize() {
		   s.getTransaction().commit();
		   s.close();
		   sessionFactory.close();
		  }
}
