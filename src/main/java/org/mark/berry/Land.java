package org.mark.berry;

public class Land {

    private int lotNumber;
    private String address;
    private double landArea;

    public Land(int lotNumber, String address, double landArea) {
        this.lotNumber = lotNumber;
        this.address = address;
        this.landArea = landArea;
    }

    public int getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(int lotNumber) {
        this.lotNumber = lotNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLandArea() {
        return landArea;
    }

    public void setLandArea(double landArea) {
        this.landArea = landArea;
    }

    @Override
    public String toString() {
        return "Land{" +
                "lotNumber=" + lotNumber +
                ", address='" + address + '\'' +
                ", landArea=" + landArea +
                '}';
    }
}
