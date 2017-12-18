/*package tests;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import logic.Material;



public class MaterialTest {
	private Material m1;
	private Material m2;
	
	@Before
	public void setUp(){
		m1 = new Material();
		m2 = new Material(800,"Luc Luq","Testboek");
	}
	
	@Test
	public void testSetISBN()
	{
		m1.setISBN(700);
		assertEquals(700,m1.getISBN());
		m2.setISBN(500);
		assertEquals(500,m2.getISBN());	
	}
	public void testSetAuthor()
	{
		m1.setAuthor("Luq Luc");
		assertEquals("Luq Luc",m1.getAuthor());
		m2.setAuthor("Qul Luc");
		assertEquals("Qul Luc",m2.getAuthor());	
	}
	public void testSetTitle()
	{
		m1.setTitle("Titelboek");
		assertEquals("Titelboek",m1.getTitle());
		m2.setTitle("Titlebook");
		assertEquals("Titlebook",m2.getTitle());	
	}
	@Test
	public void testConstructorMaterial() {
		assertEquals("Error with getMaterialID", 1, m2.getMaterialID());
		
	}

}
*/