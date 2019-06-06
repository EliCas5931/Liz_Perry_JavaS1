package com.company;

import java.util.Scanner;

public class RangeChecker {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String userInput;
        int userInt;

        do {
            System.out.println("Please enter a number between 15 and 32!");
            userInput = myScanner.nextLine();
            userInt = Integer.parseInt(userInput);

        } while (userInt < 16 || userInt > 31);

        System.out.println("Your number " + userInt + " is in range!");
    }
}
