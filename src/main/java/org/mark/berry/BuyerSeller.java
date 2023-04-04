package org.mark.berry;

/**
 * Name : Mark Berry
 * Student ID : 12205528
 * Date : 22/03/23
 * File Name : BuyerSeller.java
 * Purpose of Class : This class is an intractable object used to store variables in multiple instances.
 **/

public class BuyerSeller {
    //  Object instance variables.
    private String clientID;
    private String name;
    private String address;
    private String phoneNumber;

    //  Constructor that takes all parameters.
    public BuyerSeller(String clientID, String name, String address, String phoneNumber) {
        this.clientID = clientID;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    //  Constructor with takes no parameters.
    public BuyerSeller() {
        this.clientID = "clientID";
        this.name = "X";
        this.address = "address";
        this.phoneNumber = "0";
    }
    //Getters
    public String getClientID() {
        return clientID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    //Setters

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // To string method, prints the object variables when object is called to a print statement.
    @Override
    public String toString() {
        return "Client ID = " + clientID + "\n" +
                "Name = " + name +"\n" +
                "Address = " + address +"\n" +
                "phone Number = " + phoneNumber;
    }


}
