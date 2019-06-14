package com.company.store;

public class Chips extends Store {

    private float price;
    private String name;
    private String boughtFrom;
    private boolean isLaysBrand;

    public Chips() {

    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getBoughtFrom() {
        return boughtFrom;
    }

    public void setBoughtFrom(String boughtFrom) {
        this.boughtFrom = boughtFrom;
    }

    public boolean isLaysBrand() {
        return isLaysBrand;
    }

    public void setLaysBrand(boolean laysBrand) {
        isLaysBrand = laysBrand;
    }
}
