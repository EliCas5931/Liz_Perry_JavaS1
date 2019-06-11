package com.company;

import java.util.Scanner;

public class SpaceBoxing {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        int earthWeight = 0;

        double planetWeight = 0.0;

        System.out.println("Please enter your current earth weight: \n");

        earthWeight = Integer.parseInt(myScanner.nextLine());

        System.out.println("I have information for the following planets:\n");

        System.out.println("   1. Venus   2. Mars    3. Jupiter\n");

        System.out.println("   4. Saturn  5. Uranus  6. Neptune\n");

        System.out.println("Which planet are you visiting? ");

        int userInput = Integer.parseInt(myScanner.nextLine());

        if (userInput == 1) {

            planetWeight = earthWeight * 0.78;

        } else if (userInput == 2) {

            planetWeight = earthWeight * 0.39;

        } else if (userInput == 3) {

            planetWeight = earthWeight * 2.65;

        } else if (userInput == 4) {

            planetWeight = earthWeight * 1.17;

        } else if (userInput == 5) {

            planetWeight = earthWeight * 1.05;

        } else if (userInput == 6) {

            planetWeight = earthWeight * 1.23;

        } else {

            System.out.println("Not a valid choice. Please choose again.");

        }

        System.out.println("Your weight would be " + planetWeight + " pounds on that planet.");


    }

}
