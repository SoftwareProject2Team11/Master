package logic;

public class Address {

    private int addressId;
    private String streetname;
    private int houseNumber;
    private String city;
    public Address(String streetname, int houseNumber, String city) {
        super();
        this.streetname = streetname;
        this.houseNumber = houseNumber;
        this.city = city;
    }
    public Address(int addressId,String streetname, int houseNumber, String city) {
        super();
        this.addressId = addressId;
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
        return addressId;
    }
    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }
}