package com.company.LizPerryU1Capstone.viewmodel;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class PurchaseViewModel {

    //Need validations!
    private int invoiceId;
    @NotEmpty(message = "Please supply a value for name.")
    private String name;
    @NotEmpty(message = "Please supply a value for street.")
    private String street;
    @NotEmpty(message = "Please supply a value for city.")
    private String city;
    @NotEmpty(message = "Please supply a value for state.")
    private String state;
    @NotEmpty(message = "Please supply a value for zipCode.")
    private String zipCode;
    @NotEmpty(message = "Please supply a value for itemType.")
    private String itemType;
    @Min(value = 1, message = "You must supply an itemId!")
    private Integer itemId;
    @Min(value = 1, message = "You must supply a quantity!")
    private Integer quantity;

    public PurchaseViewModel() {

    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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
        if (!(o instanceof PurchaseViewModel)) return false;
        PurchaseViewModel that = (PurchaseViewModel) o;
        return Objects.equals(getInvoiceId(), that.getInvoiceId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getStreet(), that.getStreet()) &&
                Objects.equals(getCity(), that.getCity()) &&
                Objects.equals(getState(), that.getState()) &&
                Objects.equals(getZipCode(), that.getZipCode()) &&
                Objects.equals(getItemType(), that.getItemType()) &&
                Objects.equals(getItemId(), that.getItemId()) &&
                Objects.equals(getQuantity(), that.getQuantity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInvoiceId(), getName(), getStreet(), getCity(), getState(), getZipCode(), getItemType(), getItemId(), getQuantity());
    }
}
