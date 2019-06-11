package com.company;

import java.util.Scanner;

public class ValidNumber {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int userInt;

        boolean checkRange = false;

        System.out.println("Please enter a number between 1 and 10.");

        while (!checkRange) {

            userInt = Integer.parseInt(myScanner.nextLine());

            if (userInt < 1 || userInt > 10) {

                System.out.println("You must enter a number between 1 and 10, please try again.");

            } else {
                checkRange = true;
                System.out.println("You entered: " + userInt);
            }
        }

    }
}
