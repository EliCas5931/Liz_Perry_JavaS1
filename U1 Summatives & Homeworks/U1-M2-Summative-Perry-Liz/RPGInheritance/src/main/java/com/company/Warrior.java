package com.company;

public class Warrior extends Characters {

    private int shieldStrength;

    public Warrior(String name) {
        super(name, 75, 100, 100, 50, 10);
        this.shieldStrength = 100;
    }

    public void decreaseShieldStrength() {
        shieldStrength--;
    }

    public int getShieldStrength() {
        return shieldStrength;
    }

    public void setShieldStrength(int shieldStrength) {
        this.shieldStrength = shieldStrength;
    }
}
