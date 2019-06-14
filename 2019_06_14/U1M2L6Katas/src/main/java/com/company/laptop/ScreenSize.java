package com.company.laptop;

public class ScreenSize extends Laptop {

    private String screenType;
    private float surfaceArea;
    private String DPI;
    private boolean isMountable;

    public ScreenSize() {

    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public float getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(float surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public String getDPI() {
        return DPI;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
    }

    public boolean isMountable() {
        return isMountable;
    }

    public void setMountable(boolean mountable) {
        isMountable = mountable;
    }
}
