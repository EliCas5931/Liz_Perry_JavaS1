package com.company;

public class Radio {
    private String manufacturer;
    private String model;
    private int numSpeakers;
    private String station;
    private int volume;
    private boolean powered;

    public Radio(String manufacturerIn, String modelIn, int numSpeakersIn, String stationIn, int volumeIn, boolean poweredIn) {
        this.manufacturer = manufacturerIn;
        this.model = modelIn;
        this.numSpeakers = numSpeakersIn;
        this.station = stationIn;
        this.volume = volumeIn;
        this.powered = poweredIn;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getStation() {
        return station;
    }

    public String getModel() {
        return model;
    }

    public int getNumSpeakers() {
        return numSpeakers;
    }

    public int getVolume() {
        return volume;
    }

    public boolean isPowered() {
        return powered;
    }

    public void togglePower() {
        powered = false;
    }

}

