package com.company.restaurant;

public class Bathroom {

    private boolean hasChangingStation;
    private boolean isClean;
    private String decorType;
    private int numStalls;

    public Bathroom() {

    }

    public boolean isHasChangingStation() {
        return hasChangingStation;
    }

    public void setHasChangingStation(boolean hasChangingStation) {
        this.hasChangingStation = hasChangingStation;
    }

    public boolean isClean() {
        return isClean;
    }

    public void setClean(boolean clean) {
        isClean = clean;
    }

    public String getDecorType() {
        return decorType;
    }

    public void setDecorType(String decorType) {
        this.decorType = decorType;
    }

    public int getNumStalls() {
        return numStalls;
    }

    public void setNumStalls(int numStalls) {
        this.numStalls = numStalls;
    }
}
