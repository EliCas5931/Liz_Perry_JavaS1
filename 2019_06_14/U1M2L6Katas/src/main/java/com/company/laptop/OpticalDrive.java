package com.company.laptop;

public class OpticalDrive extends Laptop {

    private String type;
    private float price;
    private boolean hasOD;

    public OpticalDrive() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isHasOD() {
        return hasOD;
    }

    public void setHasOD(boolean hasOD) {
        this.hasOD = hasOD;
    }
}
