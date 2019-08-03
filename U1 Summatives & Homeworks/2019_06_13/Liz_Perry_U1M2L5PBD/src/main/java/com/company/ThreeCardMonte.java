package com.company;

import java.util.Random;
import java.util.Scanner;

public class ThreeCardMonte {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        Random randomGenerator = new Random();

        int randomNumber = randomGenerator.nextInt(3) + 1;

        System.out.println("You are a toddler and your mom asks if you wanna play a game.");

        System.out.println("She takes a ball and 3 cups. She puts the ball under a cup facing down on the table.");

        System.out.println("She then shuffles the cups around super duper quick to confuse you.\n");

        System.out.println("Which one is the ball under?");

        System.out.println("##      ##      ##");

        System.out.println("##      ##      ##");

        System.out.println("1       2       3");

        int userInput = Integer.parseInt(myScanner.nextLine());

        if (userInput == randomNumber) {

            System.out.println("That's right! The ball was under cup number " + randomNumber);

        } else {

            System.out.println("Sorry, your mom was too fast! The ball was under cup number " + randomNumber);

        }

        if (randomNumber == 1) {

            System.out.println("BALL    ##      ##");

            System.out.println("BALL    ##      ##");

        } else if (randomNumber == 2) {

            System.out.println("##      BALL    ##");

            System.out.println("##      BALL    ##");

        } else if (randomNumber == 3) {

            System.out.println("##      ##      BALL");

            System.out.println("##      ##      BALL");

        }

    }

}
