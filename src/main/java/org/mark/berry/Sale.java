package org.mark.berry;
import java.time.LocalDate;



public class Sale {
    private String saleId;
    private LocalDate date;
    private double soldPrice;
    private Land property;
    private BuyerSeller seller;
    private BuyerSeller buyer;

    public Sale() {
    }

    public Sale(String saleId, LocalDate date, double soldPrice, Land property, BuyerSeller seller, BuyerSeller buyer) {
        this.saleId = saleId;
        this.date = date;
        this.soldPrice = soldPrice;
        this.property = property;
        this.seller = seller;
        this.buyer = buyer;
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getSoldPrice() {
        return soldPrice;
    }

    public void setSoldPrice(double soldPrice) {
        this.soldPrice = soldPrice;
    }

    public Land getProperty() {
        return property;
    }

    public void setProperty(Land property) {
        this.property = property;
    }

    public BuyerSeller getSeller() {
        return seller;
    }

    public void setSeller(BuyerSeller seller) {
        this.seller = seller;
    }

    public BuyerSeller getBuyer() {
        return buyer;
    }

    public void setBuyer(BuyerSeller buyer) {
        this.buyer = buyer;
    }

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
