package com.company;

public class IceCreamFactory {

    private float numOZs;
    private int numFlavors;
    private String brandName;
    private boolean lactoseFree;

    //initialize class

    public float getNumOZs() {
        return numOZs;
    }

    public void setNumOZs(float numOZs) {
        this.numOZs = numOZs;
    }

    public int getNumFlavors() {
        return numFlavors;
    }

    public void setNumFlavors(int numFlavors) {
        this.numFlavors = numFlavors;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public boolean isLactoseFree() {
        return lactoseFree;
    }

    public void setLactoseFree(boolean lactoseFree) {
        this.lactoseFree = lactoseFree;
    }

    public IceCreamFactory() {

    }

    public IceCreamFactory(float numOZs, int numFlavors, String brandName, boolean lactoseFree) {
        this.numOZs = numOZs;
        this.numFlavors = numFlavors;
        this.brandName = brandName;
        this.lactoseFree = lactoseFree;
    }
}
