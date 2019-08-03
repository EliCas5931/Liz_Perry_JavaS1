package com.company;

import java.util.Random;

public class Dice {
    public static void main(String[] args) {

        Random randomDice = new Random();

        int dice1, dice2, diceTotal = 0;

        dice1 = randomDice.nextInt(6) + 1;

        dice2 = randomDice.nextInt(6) + 1;

        diceTotal = dice1 + dice2;

        System.out.println("HERE COMES THE DICE!\n");

        System.out.println("Roll #1: " + dice1);

        System.out.println("Roll #2: " + dice2);

        System.out.println("The total is " + diceTotal + "!");
    }
}
