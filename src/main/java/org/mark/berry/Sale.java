package org.mark.berry;

import java.time.LocalDate;

/**
 * Name : Mark Berry
 * Student ID : 12205528
 * Date : 22/03/23
 * File Name : Sale.java
 * Purpose of Class : This class is an intractable object used to store variables in multiple instances.
 **/

public class Sale {
    //  Object instance variables.
    private String saleId;
    private LocalDate date;
    private double soldPrice;
    private Land property;
    private BuyerSeller seller;
    private BuyerSeller buyer;

    //  Constructor with takes no parameters.
    public Sale() {
        this.saleId = "Sale ID";
        this.date = LocalDate.parse("2000-10-10");
        this.property = new Land();
        this.seller = new BuyerSeller();
        this.buyer = new BuyerSeller();
    }
    //  Constructor that takes all parameters.
    public Sale(String saleId, LocalDate date, double soldPrice, Land property, BuyerSeller seller, BuyerSeller buyer) {
        this.saleId = saleId;
        this.date = date;
        this.soldPrice = soldPrice;
        this.property = property;
        this.seller = seller;
        this.buyer = buyer;
    }

    //Getters

    public String getSaleId() {
        return saleId;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getSoldPrice() {
        return soldPrice;
    }

    public Land getProperty() {
        return property;
    }

    public BuyerSeller getSeller() {
        return seller;
    }

    public BuyerSeller getBuyer() {
        return buyer;
    }

    //Setters

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setSoldPrice(double soldPrice) {
        this.soldPrice = soldPrice;
    }

    public void setProperty(Land property) {
        this.property = property;
    }

    public void setSeller(BuyerSeller seller) {
        this.seller = seller;
    }

    public void setBuyer(BuyerSeller buyer) {
        this.buyer = buyer;
    }

    // To string method, prints the object variables when object is called to a print statement.
    @Override
    public String toString() {
        return "\nsaleId= " + saleId +
                "\ndate= " + date +
                "\nsoldPrice= " + soldPrice +
                "\nproperty= " + property +
                "\nSeller= " + seller +
                "\nBuyer= " + buyer;

    }

}
