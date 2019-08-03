package com.company;

import java.util.Random;

public class DiceDoubles {

    public static void main(String[] args) {

        Random randomDice = new Random();

        int diceTotal = 0;

        int dice1 = randomDice.nextInt(6) + 1;

        int dice2 = randomDice.nextInt(6) + 1;

        diceTotal = dice1 + dice2;

        System.out.println("Here comes the dice!\n");

        System.out.println("Roll #1: " + dice1);

        System.out.println("Roll #2: " + dice2);

        System.out.println("The total is " + diceTotal + "!\n");

        while (dice1 != dice2) {

            dice1 = randomDice.nextInt(6) + 1;

            dice2 = randomDice.nextInt(6) + 1;

            System.out.println("Roll #1: " + dice1);

            System.out.println("Roll #2: " + dice2);

            System.out.println("The total is " + diceTotal + "!\n");

        }

    }

}
