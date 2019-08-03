package com.company;

import java.util.Random;

public class ShorterDoubleDice {

    public static void main(String[] args) {

        Random randomDice = new Random();

        int dice1, dice2;

        System.out.println("HERE COME THE DICE!\n");

        do {

            dice1 = randomDice.nextInt(6) + 1;

            dice2 = randomDice.nextInt(6) + 1;

            System.out.println("Roll #1: " + dice1);

            System.out.println("Roll #2: " + dice2);

            int diceTotal = dice1 + dice2;

            System.out.println("The total is " + diceTotal + "!\n");

        } while (dice1 != dice2);

    }

}
