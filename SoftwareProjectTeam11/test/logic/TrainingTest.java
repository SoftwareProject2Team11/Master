package logic;

import static org.junit.Assert.*;

//import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class TrainingTest {
	private Training t1;
	private Calendar cal;
	private Address a1;
	private Date d1;
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
		t1.setDuration("test");
		assertEquals("test", t1.getDuration());
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
	
	//contructor test nog toevoegen
}
