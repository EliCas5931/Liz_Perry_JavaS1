package com.company;

import java.util.Scanner;

public class ValidNumber {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Please enter a number between 1 and 10.");

        int userInt = Integer.parseInt(myScanner.nextLine());

        while (userInt < 1 || userInt > 10) {

            System.out.println("You must enter a number between 1 and 10, please try again.");

            userInt = Integer.parseInt(myScanner.nextLine());

        }

        System.out.println("You entered a valid number: " + userInt);

    }
}
