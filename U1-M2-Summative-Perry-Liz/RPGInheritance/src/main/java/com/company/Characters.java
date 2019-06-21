package com.company;

public class Characters {

    private String name;
    private int strength;
    private int health;
    private int stamina;
    private int speed;
    private int attackPower;

    public Characters(String name, int strength, int health, int stamina, int speed, int attackPower) {
        this.name = name;
        this.strength = strength;
        this.health = health;
        this.stamina = stamina;
        this.speed = speed;
        this.attackPower = attackPower;
    }


    //abilities for characters
    public void run() {
        System.out.println("JUST KEEP RUNNING!");
    }

    public void attack() {
        System.out.println("ATTTTAAAAAACCCCCCCKKKKKKKKKK ARRRRGGGGHHH");
    }

    public void heal() {
        System.out.println("I MUST HEAL! Getting.... dizzy.....");
    }

    //methods for abilities
    public void decreaseHealth() {
        health--;
    }

    public void increaseStamina() {
        stamina++;
    }

    public void decreaseStamina() {
        stamina--;
    }


    // Generate getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }
}
