package org.mark.berry;

public class HouseAndLand extends Land {

    private double constructedArea;
    private int numberOfBedrooms;
    private int numberOfBathrooms;

    public HouseAndLand(int lotNumber, String address, double landArea, double constructedArea, int numberOfBedrooms, int numberOfBathrooms) {
        super(lotNumber, address, landArea);
        this.constructedArea = constructedArea;
        this.numberOfBedrooms = numberOfBedrooms;
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public double getConstructedArea() {
        return constructedArea;
    }

    public void setConstructedArea(double constructedArea) {
        this.constructedArea = constructedArea;
    }

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public void setNumberOfBedrooms(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public void setNumberOfBathrooms(int numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }
}
