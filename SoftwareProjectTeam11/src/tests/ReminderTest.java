/*
package tests;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import logic.Reminder;

public class ReminderTest {
	private Reminder r1;
	private Reminder r2;
	private Calendar cal;
	private Calendar cal2;
	private Date d1;
	private Date d2;
	
	@Before
	public void setup() {
		cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2017);
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		
		cal2 = Calendar.getInstance();
		cal2.set(Calendar.YEAR, 2016);
		cal2.set(Calendar.MONTH, Calendar.FEBRUARY);
		cal2.set(Calendar.DAY_OF_MONTH, 15);
		
		d1 = cal.getTime();
		d2 = cal2.getTime();
		
		r1 = new Reminder();
		r2 = new Reminder(2, d2);
	}

	@Test
	public void testSetGetReminderId() {
		r1.setReminderId(1);
		assertEquals(1, r1.getReminderId());
	}
	
	@Test
	public void testSetGetReminderDate() {
		r1.setRinderDate(d1);
		assertEquals(d1, r1.getRinderDate());
	}
	
	@Test
	public void testConstructorReminder() {
		assertEquals("Error with getReminderId",2, r2.getReminderId());
		assertEquals("Error with getReminderDate", d2, r2.getRinderDate());
	}
}
*/