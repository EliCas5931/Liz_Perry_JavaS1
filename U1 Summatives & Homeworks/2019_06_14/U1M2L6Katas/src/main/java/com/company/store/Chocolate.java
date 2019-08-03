package com.company.store;

public class Chocolate extends Store {

    private String maker;
    private boolean hasCaramel;
    private float price;
    private int quantity;

    public Chocolate() {

    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public boolean isHasCaramel() {
        return hasCaramel;
    }

    public void setHasCaramel(boolean hasCaramel) {
        this.hasCaramel = hasCaramel;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
