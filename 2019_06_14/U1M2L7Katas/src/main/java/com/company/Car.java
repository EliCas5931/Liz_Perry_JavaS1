package com.company;

import com.company.interfaces.Vehicle;

public class Car implements Vehicle {

    private String make;
    private String model;
    private int milesTraveled;


//    I don't think I'm doing this correctly...

//    public Car(String make, String model, int milesTraveled) {
//        this.make = make;
//    }

    public Car() {

    }

    public void drive(int miles) {

    }

    public void displayMilesTraveled() {

    }

    public String getModel() {

        return model;

    }

    public void setModel(String model) {

        this.model = model;

    }

    public String getMake() {

        return make;

    }

    public void setMake(String make) {

        this.make = make;

    }

    public int getMilesTraveled() {

        return milesTraveled;

    }

    public void setMilesTraveled(int milesTraveled) {

        this.milesTraveled = milesTraveled;

    }

}
