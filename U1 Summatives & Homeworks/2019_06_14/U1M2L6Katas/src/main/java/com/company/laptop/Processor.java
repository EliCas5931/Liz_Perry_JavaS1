package com.company.laptop;

public class Processor extends Laptop {
    private boolean isIntel;
    private float price;
    private int numUSBPorts;

    public Processor() {

    }

    public boolean isIntel() {
        return isIntel;
    }

    public void setIntel(boolean intel) {
        isIntel = intel;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNumUSBPorts() {
        return numUSBPorts;
    }

    public void setNumUSBPorts(int numUSBPorts) {
        this.numUSBPorts = numUSBPorts;
    }
}
