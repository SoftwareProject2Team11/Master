package logic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Location")
public class Location {
	
	@Id
	@Column(name="locationId")
	private int locationId;
	@Column(name="addressId")
	private int addressId;
	@Column(name="locationName")
	private String locationName;
	@Column(name="locationDetails")
	private String locationDetails;
	
	public Location(int locationId, int addressId, String locationName, String locationDetails) {
		super();
		this.locationId = locationId;
		this.addressId = addressId;
		this.locationName = locationName;
		this.locationDetails = locationDetails;
	}

	public Location() {
		// TODO Auto-generated constructor stub
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLocationDetails() {
		return locationDetails;
	}

	public void setLocationDetails(String locationDetails) {
		this.locationDetails = locationDetails;
	}
}
