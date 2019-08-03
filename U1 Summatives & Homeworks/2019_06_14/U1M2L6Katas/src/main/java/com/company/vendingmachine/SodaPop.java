package com.company.vendingmachine;

public class SodaPop extends VendingMachine {

    private float price;
    private boolean isPepsi;
    private int numPepsi;
    private String vendLocation;

    public SodaPop() {

    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isPepsi() {
        return isPepsi;
    }

    public void setPepsi(boolean pepsi) {
        isPepsi = pepsi;
    }

    public int getNumPepsi() {
        return numPepsi;
    }

    public void setNumPepsi(int numPepsi) {
        this.numPepsi = numPepsi;
    }

    public String getVendLocation() {
        return vendLocation;
    }

    public void setVendLocation(String vendLocation) {
        this.vendLocation = vendLocation;
    }
}
