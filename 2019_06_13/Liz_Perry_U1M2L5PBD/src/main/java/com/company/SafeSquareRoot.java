package com.company;

import java.util.Scanner;

public class SafeSquareRoot {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        System.out.println("SQUARE ROOT!");

        System.out.println("Enter a number: ");

        int userInt = Integer.parseInt(myScanner.nextLine());

        while (userInt < 0) {

            System.out.println("Wow, do you not read directions?");

            System.out.println("I have to take the square root and can't do that with a negative number!!!");

            System.out.println("Please enter a number I can actually find the square root of!");

            userInt = Integer.parseInt(myScanner.nextLine());

        }

        double squareRoot = Math.sqrt(userInt);

        System.out.println("The square root of " + userInt + " is " + squareRoot);

    }
}
