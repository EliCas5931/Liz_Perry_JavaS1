package com.company;

public class Farmer extends Characters {

    public Farmer (String name) {
        super(name, 75, 100, 75, 10, 1);
    }

    public void plow() {
        System.out.println("Just out here plowing my fields!");
    }

    public void harvest() {
        System.out.println("Lookie at all my harvests!");
    }
}
