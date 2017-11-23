package logic;

//@Entity
//@Table(name="Address")
public class Address {
	
	//@Id
	//@Column(name="addressId")
	private int AddressId;
	//@Column(name="streetname")
	private String streetname;
	//@Column(name="houseNumber)
	private int houseNumber;
	//@Column(name="city")
	private String city;
	
	public Address(String streetname, int houseNumber, String city) {
		super();
		this.streetname = streetname;
		this.houseNumber = houseNumber;
		this.city = city;
	}
	public Address(int AddressId,String streetname, int houseNumber, String city) {
		super();
		this.AddressId = AddressId;
		this.streetname = streetname;
		this.houseNumber = houseNumber;
		this.city = city;
	}
	public String getStreetname() {
		return streetname;
	}
	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}
	public int getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getAddressId() {
		return AddressId;
	}
	public void setAddressId(int AddressId) {
		this.AddressId = AddressId;
	}
}
