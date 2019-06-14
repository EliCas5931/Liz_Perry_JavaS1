package com.company.home;

public class Patio extends Home {

    private int area;
    private int length;
    private int width;
    private boolean patioFurniture;
    private String flooring;

    public Patio() {

    }


    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isPatioFurniture() {
        return patioFurniture;
    }

    public void setPatioFurniture(boolean patioFurniture) {
        this.patioFurniture = patioFurniture;
    }

    public String getFlooring() {
        return flooring;
    }

    public void setFlooring(String flooring) {
        this.flooring = flooring;
    }
}
