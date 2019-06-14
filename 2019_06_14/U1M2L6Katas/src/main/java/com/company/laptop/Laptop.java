package com.company.laptop;

public class Laptop {

    private Processor processor;
    private Memory memory;
    private ScreenSize screenSize;
    private OpticalDrive opticalDrive;
    private float compCost;

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public ScreenSize getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(ScreenSize screenSize) {
        this.screenSize = screenSize;
    }

    public OpticalDrive getOpticalDrive() {
        return opticalDrive;
    }

    public void setOpticalDrive(OpticalDrive opticalDrive) {
        this.opticalDrive = opticalDrive;
    }

    public float getCompCost() {
        return compCost;
    }

    public void setCompCost(float compCost) {
        this.compCost = compCost;
    }

    public Laptop() {

    }
}
