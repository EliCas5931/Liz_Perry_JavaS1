package com.company.vendingmachine;

public class Chips extends VendingMachine {

    private float price;
    private int numDoritos;
    private boolean inStock;

    public Chips() {

    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNumDoritos() {
        return numDoritos;
    }

    public void setNumDoritos(int numDoritos) {
        this.numDoritos = numDoritos;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }
}
