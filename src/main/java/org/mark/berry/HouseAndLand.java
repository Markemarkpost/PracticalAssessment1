package org.mark.berry;

/**
 * Name : Mark Berry
 * Student ID : 12205528
 * Date : 22/03/23
 * File Name : HouseAndLand.java
 * Purpose of Class : This class is an intractable object used to store variables in multiple instances.
 **/

public class HouseAndLand extends Land {
    //  Object instance variables.
    private double constructedArea;
    private int numberOfBedrooms;
    private int numberOfBathrooms;

    //  Constructor that takes all parameters.
    public HouseAndLand(int lotNumber, String address, double landArea, double constructedArea, int numberOfBedrooms, int numberOfBathrooms) {
        super(lotNumber, address, landArea);
        this.constructedArea = constructedArea;
        this.numberOfBedrooms = numberOfBedrooms;
        this.numberOfBathrooms = numberOfBathrooms;
    }

    //  Constructor with takes no parameters.
    public HouseAndLand() {
        this.constructedArea = 0.0;
        this.numberOfBedrooms = 0;
        this.numberOfBathrooms = 0;
    }
    //Getters

    public double getConstructedArea() {
        return constructedArea;
    }

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    //Setters

    public void setConstructedArea(double constructedArea) {
        this.constructedArea = constructedArea;
    }

    public void setNumberOfBedrooms(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public void setNumberOfBathrooms(int numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    // To string method, prints the object variables when object is called to a print statement.
    public String toString() {
        return super.toString() +
                "Constructed Area = " + constructedArea + "\n" +
                "Number Of Bedrooms = " + numberOfBedrooms + "\n" +
                "Number Of Bathrooms = " + numberOfBathrooms + "\n";
    }

}
