package com.company;

public class IceCreamPOS {

    private float price;
    private int numScoops;
    private String flavors;
    private boolean inCup;

    //initialize class

    public IceCreamPOS() {

    }

    public IceCreamPOS(float price, int numScoops, String flavors, boolean inCup) {
        this.price = price;
        this.flavors = flavors;
        this.numScoops = numScoops;
        this.inCup = inCup;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNumScoops() {
        return numScoops;
    }

    public void setNumScoops(int numScoops) {
        this.numScoops = numScoops;
    }

    public String getFlavors() {
        return flavors;
    }

    public void setFlavors(String flavors) {
        this.flavors = flavors;
    }

    public boolean isInCup() {
        return inCup;
    }

    public void setInCup(boolean inCup) {
        this.inCup = inCup;
    }
}
