package org.mark.berry;

/**
 * Name : Mark Berry
 * Student ID : 12205528
 * Date : 22/03/23
 * File Name : Land.java
 * Purpose of Class : This class is an intractable object used to store variables in multiple instances.
 **/

public class Land {
    //  Object instance variables.
    private int lotNumber;
    private String address;
    private double landArea;

    //  Constructor that takes all parameters.
    public Land(int lotNumber, String address, double landArea) {
        this.lotNumber = lotNumber;
        this.address = address;
        this.landArea = landArea;
    }

    //  Constructor with takes no parameters.
    public Land() {
        this.lotNumber = 0;
        this.address = "address";
        this.landArea = 0.0;
    }
    //Getters

    public int getLotNumber() {
        return lotNumber;
    }

    public String getAddress() {
        return address;
    }

    public double getLandArea() {
        return landArea;
    }

    //Setters

    public void setLotNumber(int lotNumber) {
        this.lotNumber = lotNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLandArea(double landArea) {
        this.landArea = landArea;
    }

    // To string method, prints the object variables when object is called to a print statement.
    @Override
    public String toString() {
        return
                "Lot Number = " + lotNumber + "\n" +
                        "Address = " + address + "\n" +
                        "Land Area = " + landArea + "\n";
    }
}
