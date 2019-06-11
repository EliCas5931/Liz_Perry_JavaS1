package com.company;

import java.util.Random;
import java.util.Scanner;

public class KeepGuessing {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        Random randomGenerator = new Random();

        int randomNumber = randomGenerator.nextInt(10) + 1;

        System.out.println("I have chosen a number between 1 and 10. Try to guess it.");

        System.out.println("Your guess: ");

        int userChoice = myScanner.nextInt();

        while (userChoice != randomNumber) {

            System.out.println("That is incorrect. Guess again.");

            //Infinite loop. Google a fix.

            System.out.println("Your guess: ");

            userChoice = myScanner.nextInt();

        }

        System.out.println("That's right! You're a good guesser.");

    }
}
