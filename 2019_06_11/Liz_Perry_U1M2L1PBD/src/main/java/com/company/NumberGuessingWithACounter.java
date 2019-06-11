package com.company;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingWithACounter {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        Random randomGenerator = new Random();

        int randomNumber = randomGenerator.nextInt(10) + 1;

        int guessAttempts = 0;

        System.out.println("I have chosen a number between 1 and 10. Try to guess it.");

        System.out.println("Your guess: ");

        int userChoice = myScanner.nextInt();

        guessAttempts++;

        while (userChoice != randomNumber) {

            System.out.println("That is incorrect. Guess again.");

            System.out.println("Your guess: ");

            userChoice = myScanner.nextInt();

            guessAttempts++;

        }

        System.out.println("That's right! You're a good guesser.");

        System.out.println("It only took you " + guessAttempts + " tries.");

    }

}
