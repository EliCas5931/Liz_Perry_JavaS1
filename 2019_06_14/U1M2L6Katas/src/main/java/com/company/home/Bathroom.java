package com.company.home;

public class Bathroom extends Home {

    private boolean hasTub;
    private String flooring;
    private int numSinks;
    private int area;
    private int perimeter;

    public Bathroom() {

    }

    public boolean isHasTub() {
        return hasTub;
    }

    public void setHasTub(boolean hasTub) {
        this.hasTub = hasTub;
    }

    public String getFlooring() {
        return flooring;
    }

    public void setFlooring(String flooring) {
        this.flooring = flooring;
    }

    public int getNumSinks() {
        return numSinks;
    }

    public void setNumSinks(int numSinks) {
        this.numSinks = numSinks;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(int perimeter) {
        this.perimeter = perimeter;
    }


}
