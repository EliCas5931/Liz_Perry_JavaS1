package com.company;

public class App {

    public static void main(String[] args) {

        Farmer farmer = new Farmer("Farmer 1");

        Constable constable = new Constable("Constable 1");

        Warrior warrior = new Warrior("Warrior 1");

        // test if working
        System.out.println(farmer.getHealth());
        System.out.println(constable.getSpeed());
        System.out.println(warrior.getShieldStrength());
    }
}
