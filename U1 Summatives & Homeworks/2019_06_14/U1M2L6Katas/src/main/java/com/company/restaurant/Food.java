package com.company.restaurant;

public class Food {

    private boolean isMeat;
    private boolean isVegetarian;
    private int numBread;
    private float priceApps;

    public Food() {

    }

    public boolean isMeat() {
        return isMeat;
    }

    public void setMeat(boolean meat) {
        isMeat = meat;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public int getNumBread() {
        return numBread;
    }

    public void setNumBread(int numBread) {
        this.numBread = numBread;
    }

    public float getPriceApps() {
        return priceApps;
    }

    public void setPriceApps(float priceApps) {
        this.priceApps = priceApps;
    }
}
