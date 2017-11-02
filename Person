package logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;



public class Person implements Serializable, Runnable, Comparable<Person>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2546289831965973096L;
	private int ID;
	private String firstname;
	private String lastname;
	private Address address;
	private String email;
	private String telephone;
	private static ArrayList<Person> persons = new ArrayList<Person>();
	private HashMap<Person, Integer> persons1 = new HashMap<Person,Integer>();
	private Object obj;
	
	public Person(int iD, String firstname, String lastname, Address address, String email, String telephone) {
		super();
		ID = iD;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.email = email;
		this.telephone = telephone;
		persons.add(this);
		persons1.getClass().isInstance(obj);
	}
	
	//getters, setters
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void save(){
		File file = new File("personen.txt");
		FileOutputStream fileout= null;
		try {
			fileout= new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fileout);
		pw.println(firstname);
		pw.println(lastname);
		pw.println(address);
		pw.println(email);
		pw.println(telephone);
		pw.close();
	}
	
	@Override
	public void run() {
		this.save();
		
	}
	
	@Override
	public String toString() {
		return "Person [firstname=" + firstname + ", lastname=" + lastname + ", address=" + address + ", email=" + email + ", telephone=" + telephone + "]";
	}
	public static ArrayList<Person> getPersons() {
		return persons;
	}
	public static void setPersonen(ArrayList<Person> persons) {
		Person.persons = persons;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public int compareTo(Person o) {
		return this.lastname.compareTo(o.getLastname());
	}
	
	
}

