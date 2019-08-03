package com.company;

public class Constable extends Characters {

    private String jurisdiction;

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public Constable (String name) {
        super(name, 60, 100, 60, 20, 5);
    }

    public void arrest() {
        System.out.println("STOP! In the name of the law! You are under arrest!");
    }
}
