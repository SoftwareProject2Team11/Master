package tests;


import static org.junit.Assert.*;

import java.sql.Time;
//import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import logic.Address;
import logic.Reminder;
import logic.Training;

public class TrainingTest {
	private Training t1;
	//private Training t2;
	private Calendar cal;
	private Address a1;
	private Date d1;
	private Time time1;
	//private ArrayList<Employee> empList1;
	//private ArrayList<Material> matList1;
	//private ArrayList<Certificat> cerList1;
	private Reminder r1;
	
	@Before
	public void setUp() throws Exception {
		cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2017);
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		
		t1 = new Training();
		a1 = new Address();
		d1 = cal.getTime();
		//empList1 = new ArrayList<Employee>();
		//matList1 = new ArrayList<Material>();
		//cerList1 = new ArrayList<Certificat>();
		r1 = new Reminder();
		/*
		t2 = new Training(2, a1, "40", "test", d1,
				empList1, matList1, cerList1,
				true, r1);
		*/
	}

	@Test
	public void testSetGetTrainingId() {
		t1.setTrainingID(1);
		assertEquals(1, t1.getTrainingID());
	}
	
	@Test
	public void testSetGetTrainingName() {
		t1.setTrainingName("test");
		assertEquals("test", t1.getTrainingName());
	}
	
	@Test
	public void testSetGetAddress() {
		t1.setAddress(a1);
		assertEquals(a1, t1.getAddress());
	}
	
	@Test
	public void testSetGetDuration() {
		t1.setDuration(time1);
		assertEquals(time1, t1.getDuration());
	}
	
	@Test
	public void testSetGetSummary() {
		t1.setSummary("test");
		assertEquals("test", t1.getSummary());
	}
	
	@Test
	public void testSetGetDate() {
		t1.setDate(d1);
		assertEquals(d1, t1.getDate());
	}
	/*
	@Test
	public void testSetGetEmployeeList() {
		t1.setEmployeeList(empList1);
		assertEquals(empList1, t1.getEmployeeList());
	}
	*/
	/*
	@Test
	public void testSetGetMaterialList() {
		t1.setMaterialList(matList1);
		assertEquals(matList1, t1.getMaterialList());
	}
	*/
	/*
	@Test
	public void testSetGetCertificatList() {
		t1.setCertificatList(cerList1);
		assertEquals(cerList1, t1.getCertificatList());
	}
	*/
	@Test
	public void testSetGetIsActief() {
		t1.setActief(true);
		assertEquals(true, t1.isActief());
	}
	
	@Test
	public void testSetGetReminder() {
		t1.setReminder(r1);
		assertEquals(r1, t1.getReminder());
	}
	/*
	@Test
	public void testConstructorTraining() {
		assertEquals("Error with getTrainingId", 2, t1.getTrainingID());
		assertEquals("Error with getAddress", a1, t1.getAddress());
		assertEquals("Error with getDuration", "40", t1.getDuration());
		assertEquals("Error with getSummary", "test", t1.getSummary());
		assertEquals("Error with getDate", d1, t1.getDate());
		assertEquals("Error with getEmployeeList", empList1, t1.getEmployeeList());
		assertEquals("Error with getMaterialList", matList1, t1.getMaterialList());
		assertEquals("Error with getCertificatList", cerList1, t1.getCertificatList());
		assertEquals("Error with isActief", true, t1.isActief());
		assertEquals("Error with getReminder", r1, t1.getReminder());
	}
	*/
}