package logic;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//import java.util.List;
//import java.util.ArrayList;

// ATM this has no DAO because we make use of ODATA to interact with the employees of the ERP
// For the moment this is only uses for the training class
@Entity
@Table(name="Employee")
public class Employee {
@Id
	private int employeeId;
	private boolean isActief;
	
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public boolean isActief() {
		return isActief;
	}
	public void setActief(boolean isActief) {
		this.isActief = isActief;
	}
	
	/*
	List <Certificate> list = new ArrayList<Certificate>();
	List <Material> list = new ArrayList<Material>();
	List <Survey> list = new ArrayList<Survey>();
	*/
	
	
	
}