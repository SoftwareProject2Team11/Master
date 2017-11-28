package logic;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Training {
	
	private int trainingID;
	private String trainingName;
	private Address address;
	private Time duration;
	private String summary;
	private Date date;
	private ArrayList<Employee> employeeList = new ArrayList<Employee>();
	private ArrayList<Material> materialList = new ArrayList<Material>();
	private ArrayList<Certificat> certificatList = new ArrayList<Certificat>();
	private boolean isActief;
	private Reminder reminder;
	
	public Training(int trainingID, Address address, Time duration, String summary, Date date,
			ArrayList<Employee> employeeList, ArrayList<Material> materialList, ArrayList<Certificat> certificatList,
			boolean isActief, Reminder reminder) {
		this.trainingID = trainingID;
		this.address = address;
		this.duration = duration;
		this.summary = summary;
		this.date = date;
		this.employeeList = employeeList;
		this.materialList = materialList;
		this.certificatList = certificatList;
		this.isActief = isActief;
		this.reminder = reminder;
	}
	
	public Training() {
		
	}
	
	public void setTraining(int trainingId, Time duration, String summary, Date date, boolean visibility, String trainingName) {
		this.setTrainingID(trainingId);
		this.setDuration(duration);
		this.setSummary(summary);
		this.setDate(date);
		this.setActief(visibility);
		this.setTrainingName(trainingName);
	}

	public int getTrainingID() {
		return trainingID;
	}
	public void setTrainingID(int trainingID) {
		this.trainingID = trainingID;
	}
	public String getTrainingName() {
		return trainingName;
	}
	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Time getDuration() {
		return duration;
	}
	public void setDuration(Time duration) {
		this.duration = duration;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public ArrayList<Employee> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(ArrayList<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	public ArrayList<Material> getMaterialList() {
		return materialList;
	}
	public void setMaterialList(ArrayList<Material> materialList) {
		this.materialList = materialList;
	}
	public ArrayList<Certificat> getCertificatList() {
		return certificatList;
	}
	public void setCertificatList(ArrayList<Certificat> certificatList) {
		this.certificatList = certificatList;
	}
	public boolean isActief() {
		return isActief;
	}
	public void setActief(boolean isActief) {
		this.isActief = isActief;
	}
	public Reminder getReminder() {
		return reminder;
	}
	public void setReminder(Reminder reminder) {
		this.reminder = reminder;
	}

	public String showMaterialListForMail() {
		String list = ""; 
		list = list + "<ul>\n";
		for (int i=0; i<materialList.size(); i++) {
			list = list + "<li><p>" + materialList.get(i).getTitle() + " - " + materialList.get(i).getAuthor() + " - " + materialList.get(i).getISBN() + "</p></li>";
		}
		list = list + "</ul>\n";
		return list;	
	}
	
	//Wordt gedaan via Odata
	/*
	 * public String showEmployeeListForMail() {
		String list = ""; 
		list = list + "<ul>\n";
		for (int i=0; i<employeeList.size(); i++) {
			list = list + "<li><p>" + employeeList.get(i).getNaam() + " - " + employeeList.get(i).getLeeftijd() + " jaar</p></li>";
		}
		list = list + "</ul>\n";
		return list;	
	}
	*/
	
	@Override
	public String toString() {
		return "Training [trainingID=" + trainingID + ", address=" + address + ", duration=" + duration + ", summary="
				+ summary + ", date=" + date + ", employeeList=" + employeeList + ", materialList=" + materialList
				+ ", certificatList=" + certificatList + ", isActief=" + isActief + ", reminder=" + reminder + "]";
	}

	public boolean searchEmployee(Employee employee) {
		
		for (int i=0; i<employeeList.size(); i++) {
			if (employeeList.get(i).getEmployeeId() == employee.getEmployeeId()) {
				return true;
			}
		}
		return false;
	//Ik zou deze methode als returnwaarde boolean meegeven, 
	//als de ingegeven employee in de lijst is returt de methode true
	//Daarbij is het ook gemmakelijk om het te hergebruiken in volgende methodes
	//Deze functie zoekt op employeeId
	}
	
	
	public void addEmployee(Employee employee) {
		if (searchEmployee(employee) == true) {
			System.out.println("Deze employee staat al in de lijst");
		}
		else {
			employeeList.add(employee);
		}
	}
	
	public void removeEmployee(Employee employee) {
		if (searchEmployee(employee) == false) {
			System.out.println("Deze employee staat niet in de lijst");
		}
		else {
			employeeList.remove(employee);
		}
	}
	
	
	public boolean CheckisActief() {
		if (isActief == true) {
			return true;
		}
		else {
			return false;
		}
	//Hier heb ik de naam van de methode verandert, vermits ik een
	//error krijg van meerdere methoden onder dezelfde naam 
	//(omdat isActief al de naam is van een variable)
	}
	
	
	//Feature 
	public void showEmployeeList() {
		for (int i=0; i<employeeList.size(); i++) {
			System.out.println(employeeList.get(i).toString());
		}
	}
}