package odata;

public class EmployeeData {
	private int employeeID;
	private String firstname;
	private String lastname;
	private String job;
	private String address;
	private String city;
	private String region;
	private String country;
	private String birthday;
	private String hireday;
	private String homePhone;
	private String extension;
	
	public EmployeeData(int employeeID, String firstname, String lastname, String job, String address, String city,
			String region, String country, String birthday, String hireday, String homePhone, String extension) {
		super();
		this.employeeID = employeeID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.job = job;
		this.address = address;
		this.city = city;
		this.region = region;
		this.country = country;
		this.birthday = birthday;
		this.hireday = hireday;
		this.homePhone = homePhone;
		this.extension = extension;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
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

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getHireday() {
		return hireday;
	}

	public void setHireday(String hireday) {
		this.hireday = hireday;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", firstname=" + firstname + ", lastname=" + lastname + ", job="
				+ job + ", address=" + address + ", city=" + city + ", region=" + region + ", country=" + country
				+ ", birthday=" + birthday + ", hireday=" + hireday + ", homePhone=" + homePhone + ", extension="
				+ extension + "]";
	}

}
