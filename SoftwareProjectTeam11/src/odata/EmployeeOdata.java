package odata;

import java.util.ArrayList;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class EmployeeOdata {

	public static ArrayList<String> getAll()
	{ 
		Client client = ClientBuilder.newClient();
		ArrayList<String> namen = new ArrayList<String>();
		String s=null;
		String t=null;
		String naam = null;
		for(int i=1;i<=9;i++) 
		{
			WebTarget target=client.target("http://services.odata.org/V3/Northwind/Northwind.svc/Employees("+i+")/FirstName");
			s = target.request(MediaType.APPLICATION_JSON).get(String.class);
			WebTarget target2=client.target("http://services.odata.org/V3/Northwind/Northwind.svc/Employees("+i+")/LastName");
			t = target2.request(MediaType.APPLICATION_JSON).get(String.class);
			s = new ClearString().clearGivenString(s);
			t = new ClearString().clearGivenString(t);
			naam = s + " " + t;
			namen.add(naam);
		}
		return namen;
	}
	
	public static EmployeeData getEmployeeByID(int id)
	{ 
		Client client = ClientBuilder.newClient();
		
		WebTarget target=client.target("http://services.odata.org/V3/Northwind/Northwind.svc/Employees("+id+")/FirstName");
		WebTarget target2=client.target("http://services.odata.org/V3/Northwind/Northwind.svc/Employees("+id+")/LastName");
		WebTarget target3=client.target("http://services.odata.org/V3/Northwind/Northwind.svc/Employees("+id+")/Title");
		WebTarget target4=client.target("http://services.odata.org/V3/Northwind/Northwind.svc/Employees("+id+")/TitleOfCourtesy");
		WebTarget target5=client.target("http://services.odata.org/V3/Northwind/Northwind.svc/Employees("+id+")/BirthDate");
		WebTarget target6=client.target("http://services.odata.org/V3/Northwind/Northwind.svc/Employees("+id+")/HireDate");
		WebTarget target7=client.target("http://services.odata.org/V3/Northwind/Northwind.svc/Employees("+id+")/Address");
		WebTarget target8=client.target("http://services.odata.org/V3/Northwind/Northwind.svc/Employees("+id+")/City");
		WebTarget target9=client.target("http://services.odata.org/V3/Northwind/Northwind.svc/Employees("+id+")/Region");
		WebTarget target10=client.target("http://services.odata.org/V3/Northwind/Northwind.svc/Employees("+id+")/PostalCode");
		WebTarget target11=client.target("http://services.odata.org/V3/Northwind/Northwind.svc/Employees("+id+")/Country");
		WebTarget target12=client.target("http://services.odata.org/V3/Northwind/Northwind.svc/Employees("+id+")/HomePhone");
		WebTarget target13=client.target("http://services.odata.org/V3/Northwind/Northwind.svc/Employees("+id+")/Extension");
										
		String firstname = target.request(MediaType.APPLICATION_JSON).get(String.class);
		firstname = new ClearString().clearGivenString(firstname);
		String lastname = target2.request(MediaType.APPLICATION_JSON).get(String.class);
		lastname = new ClearString().clearGivenString(lastname);
		String title = target3.request(MediaType.APPLICATION_JSON).get(String.class);
	 	title = new ClearString().clearGivenString(title);
	 	String titleOfCourtesy = target4.request(MediaType.APPLICATION_JSON).get(String.class);
		titleOfCourtesy = new ClearString().clearGivenString(titleOfCourtesy);
		String birthday = target5.request(MediaType.APPLICATION_JSON).get(String.class);
		birthday = new ClearString().clearGivenString(birthday);
		String hireDate = target6.request(MediaType.APPLICATION_JSON).get(String.class);
		hireDate = new ClearString().clearGivenString(hireDate);
		String address = target7.request(MediaType.APPLICATION_JSON).get(String.class);
		address = new ClearString().clearGivenString(address);
		String city = target8.request(MediaType.APPLICATION_JSON).get(String.class);
		city = new ClearString().clearGivenString(city);
		String region = target9.request(MediaType.APPLICATION_JSON).get(String.class);
		region = new ClearString().clearGivenString(region);
		String postalCode = target10.request(MediaType.APPLICATION_JSON).get(String.class);
		postalCode = new ClearString().clearGivenString(postalCode);
		String country = target11.request(MediaType.APPLICATION_JSON).get(String.class);
		country = new ClearString().clearGivenString(country);
		String homePhone = target12.request(MediaType.APPLICATION_JSON).get(String.class);
		homePhone = new ClearString().clearGivenString(homePhone);
		String extension = target13.request(MediaType.APPLICATION_JSON).get(String.class);
		extension = new ClearString().clearGivenString(extension);
		
		EmployeeData emp = new EmployeeData(id,firstname,lastname,title,address,city,region,country,birthday,hireDate,homePhone,extension);
		//String info = "Firstname: " +titleOfCourtesy + " "+ firstname +"\nLastname: " + lastname + "\nJob: " + title + "\nAddress: " + address + "\nCity: "+city + "\nRegion: " + region + "\nCountry: "+ country + "\nBirthday: "+ birthday + "\nHireDate: " + hireDate + "\nHome phone: "+ homePhone + "\nExtension: " + extension;
			
		return emp;
	}
	
	public String getEmployeeNameById(int id)
	{
		Client client = ClientBuilder.newClient();
		
		WebTarget target=client.target("http://services.odata.org/V3/Northwind/Northwind.svc/Employees("+id+")/FirstName");
		WebTarget target2=client.target("http://services.odata.org/V3/Northwind/Northwind.svc/Employees("+id+")/LastName");
		
		String firstname = target.request(MediaType.APPLICATION_JSON).get(String.class);
		firstname = new ClearString().clearGivenString(firstname);
		String lastname = target2.request(MediaType.APPLICATION_JSON).get(String.class);
		lastname = new ClearString().clearGivenString(lastname);
		
		String name = lastname + firstname;
		return name;
	}
	
}
