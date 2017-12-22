package logic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Address")
public class Address {
	
	@Id
	@Column(name="addressId")
	private int AddressId;
	@Column(name="streetname")
	private String streetname;
	@Column(name="houseNumber")
	private int houseNumber;
	@Column(name="city")
	private String city;
	@Column(name="visibility")
	private int visibility;
	@Column(name="lat")
	private double  lat;
	@Column(name="long")
	private double  longi;
	
	public Address() {
		
	}
	public Address(int AddressId,String streetname, int houseNumber, String city, int visibility, double lat, double longi) {
		super();
		this.AddressId = AddressId;
		this.streetname = streetname;
		this.houseNumber = houseNumber;
		this.city = city;
		this.visibility=visibility;
		this.lat=lat;
		this.longi=longi;
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
