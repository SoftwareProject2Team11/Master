import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.CertificatDAO;

/////////////////////////////////////////////////////////
//Connection database
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/////////////////////////////////////////////////////////


class CertificatDAOTests {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Once before all the tests");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("After all the classes are complete");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Set up");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Tear down");
	}

/////////////////////////////////////////////////////////

//Connection to DATABASE 
public static Connection getConnection() throws Exception{
	
	try {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://dt5.ehb.be/SP2Team11";
		String username = "SP2Team11";
		String password = "QJC48w";
		Class.forName(driver);
		
		Connection connection = DriverManager.getConnection(url, username, password);
		System.out.println("Connection");
		return connection;
	}catch(Exception e)
	{ 
		System.out.println(e);
	}
	 return null;
}

/////////////////////////////////////////////////////////
//Tests CRUD

@Test
public void testIt() throws Exception{
	
	Connection connection = getConnection();
	connection.setAutoCommit(false); // begin transaction
	
	CertificatDAO certificatDao = new CertificatDAO();
	  try{
		  
		  // certificatDao.addNewCert("1", "one");
		  //certificatDao.addNewCert("2", "two");

		  // assertEquals("one", certificatDao.readABC("1"));
		  // assertEquals("two", certificatDao.readABC("2"));


		  //  certificatDao.updateCertName("1", "oneOne");
		  //  certificatDao.updateCertName("2", "twoTwo");

		  // assertEquals("oneOne", certificatDao.readABC("1"));
		  //  assertEquals("twoTwo", certificatDao.readABC("2"));

		   

		    
		  } finally {
		    connection.rollback();
		    connection.close();
		  }  
		}
 static void main(String[] args) throws Exception{
	
	 getConnection();
}
}
