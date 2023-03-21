package org.mark.berry;

public class BuyerSeller {

    private String clientID;
    private String name;
    private String address;
    private int phoneNumber;

    public BuyerSeller(String clientID, String name, String address, int phoneNumber) {
        this.clientID = clientID;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public BuyerSeller() {
        this.clientID = "clientID";
        this.name = "name";
        this.address = "address";
        this.phoneNumber = 0;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "BuyerSeller{" +
                "clientID='" + clientID + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
