package com.company;

import java.util.Random;
import java.util.Scanner;

public class HiLo {
    public static void main(String[] args) {
        Random randomGenerator = new Random();
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Welcome to Hi-Low!");

        System.out.println("What is your name?");
        String name = myScanner.nextLine();

        System.out.println("OK, " + name + ", here are the rules:");
        System.out.println("Try to guess what number between 1 and 100 that the computer is thinking");

        int compGuess = randomGenerator.nextInt(100) + 1;

        for (int i = 0; i < 1000; i++) {
            int numGuess = i + 1;

            int userGuess = myScanner.nextInt();

            if (userGuess < compGuess) {

                System.out.println("Too low! Guess again!");

            } else if (userGuess > compGuess) {

                System.out.println("Too high! Guess again!");

            } else if (userGuess == compGuess) {

                System.out.println("Congratulations, " + name + "! You win!");

                System.out.println("It took you " + numGuess + " guesses to find my number!");

                break;

            } else {

                System.out.println("Invalid input.");
            }

        }

    }
}
