package com.company.LizPerryU1Capstone.model;

import java.util.Objects;

public class Purchase {

    private int id;
    private String name;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String itemType;
    private int itemId;
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zipCode;
    }

    public void setZip(String zip) {
        this.zipCode = zip;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return id == purchase.id &&
                Objects.equals(name, purchase.name) &&
                Objects.equals(street, purchase.street) &&
                Objects.equals(city, purchase.city) &&
                Objects.equals(state, purchase.state) &&
                Objects.equals(zipCode, purchase.zipCode) &&
                Objects.equals(itemType, purchase.itemType) &&
                Objects.equals(itemId, purchase.itemId) &&
                Objects.equals(quantity, purchase.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, street, city, state, zipCode, itemType, itemId, quantity);
    }
}
