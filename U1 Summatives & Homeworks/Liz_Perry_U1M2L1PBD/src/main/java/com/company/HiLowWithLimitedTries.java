package com.company;

import java.util.Scanner;
import java.util.Random;

public class HiLowWithLimitedTries {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        Random randomGenerator = new Random();

        int guessAttempts = 1;

        int userGuess;

        int randomNumber = randomGenerator.nextInt(100) + 1;

        System.out.println("I'm thinking of a number between 1-100. You have 7 guesses.");

        System.out.println("First guess: ");

        userGuess = myScanner.nextInt();

        guessAttempts++;

        while (randomNumber != userGuess && guessAttempts < 8) {

            if (randomNumber > userGuess) {

                System.out.println("Sorry, you're too low.");

                System.out.println("Guess # " + guessAttempts + ": ");

                userGuess = myScanner.nextInt();

                guessAttempts++;

            } else if (randomNumber < userGuess) {

                System.out.println("Sorry, you're too high.");

                System.out.println("Guess # " + guessAttempts + ": ");

                userGuess = myScanner.nextInt();

                guessAttempts++;

            }
        }

        if (randomNumber == userGuess) {

            System.out.println("You guessed it! What are the odds?");

        } else if (guessAttempts > 7) {

            System.out.println("Sorry, you didn't guess it in 7 tries. You lose.");

        }

    }

}
