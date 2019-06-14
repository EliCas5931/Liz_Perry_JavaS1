package com.company.store;

public class SodaPop extends Store {

    private String brand;
    private String locationBought;
    private int quantity;
    private float price;
    private boolean isTasty;

    public SodaPop() {

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getLocationBought() {
        return locationBought;
    }

    public void setLocationBought(String locationBought) {
        this.locationBought = locationBought;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isTasty() {
        return isTasty;
    }

    public void setTasty(boolean tasty) {
        isTasty = tasty;
    }
}
