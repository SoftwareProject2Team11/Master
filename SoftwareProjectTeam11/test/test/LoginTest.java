package test;


import static org.junit.Assert.*;

import org.junit.Test;
import logic.Login;

public class LoginTest {
	private Login login;
	private Login login2;
	@Test
	public void setUp() {
		login = new Login();
		login2 = new Login("username","password");
		}
	@Test
	public void testConnect()
	{
		login.Connect("Luke Lucas", "test");
		if(login.getOutputConnect() !=null) {
			
		}else 
			{
			fail("not succeeded");
			};
		login2.Connect("Luke Luca", "test2");
		if(login2.getOutputConnect()!=null) {
			
		}
		else {
			fail("not succeeded");
		};
		
		
	}
	public void testConstructorReminder() {
		assertEquals("Error with login defaultconstructor",login.getLoginId());
		assertEquals("Error with login constructor made to login", login2.getLoginId());
	}
	
}
