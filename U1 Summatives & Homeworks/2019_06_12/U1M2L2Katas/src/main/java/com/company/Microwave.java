package com.company;

public class Microwave {
    private String manufacturer;
    private String model;
    private int secondsLeft;
    private String time;
    private boolean running;

    public Microwave(String manufacturerIn, String modelIn, int secondsLeftIn, String timeIn, boolean runningIn) {
        this.manufacturer = manufacturerIn;
        this.model = modelIn;
        this.secondsLeft = secondsLeftIn;
        this.time = timeIn;
        this.running = runningIn;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getSecondsLeft() {
        return secondsLeft;
    }

    public String getTime() {
        return time;
    }

    public boolean isRunning() {
        return running;
    }

    public void start(int secondsLeft) {
        secondsLeft--;
    }

    public void stop() {
        secondsLeft = 0;
    }

    public void clear() {
        running = false;
    }
}
