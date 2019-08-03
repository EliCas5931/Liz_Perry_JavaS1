package com.company.vendingmachine;

public class VendingMachine {

    private Chips chips;
    private SodaPop sodaPop;
    private int chipCount;
    private float cashOnHand;
    private String location;

    public VendingMachine() {

    }

    public Chips getChips() {
        return chips;
    }

    public void setChips(Chips chips) {
        this.chips = chips;
    }

    public SodaPop getSodaPop() {
        return sodaPop;
    }

    public void setSodaPop(SodaPop sodaPop) {
        this.sodaPop = sodaPop;
    }

    public int getChipCount() {
        return chipCount;
    }

    public void setChipCount(int chipCount) {
        this.chipCount = chipCount;
    }

    public float getCashOnHand() {
        return cashOnHand;
    }

    public void setCashOnHand(float cashOnHand) {
        this.cashOnHand = cashOnHand;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
