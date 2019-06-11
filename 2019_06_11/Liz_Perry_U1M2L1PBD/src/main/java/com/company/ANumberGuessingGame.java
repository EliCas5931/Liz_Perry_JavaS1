package com.company;

import java.util.Scanner;
import java.util.Random;

public class ANumberGuessingGame {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        Random randomGenerator = new Random();

        int randomNumber = randomGenerator.nextInt(10) + 1;

        System.out.println("I'm thinking of a number from 1 to 10.");

        System.out.println("Your guess: ");

        int userChoice = Integer.parseInt(myScanner.nextLine());

        if (randomNumber == userChoice) {

            System.out.println("That's right! My secret number was " + randomNumber + "!");

        } else {

            System.out.println("Sorry, but I was really thinking of " + randomNumber + ".");

        }
    }
}
