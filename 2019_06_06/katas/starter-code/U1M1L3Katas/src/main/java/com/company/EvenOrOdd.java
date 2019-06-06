package com.company;

import java.util.Scanner;

public class EvenOrOdd {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter any number.");
        int userInput = Integer.parseInt(myScanner.nextLine());

        if (userInput % 2 == 0) {
            System.out.println("The number " + userInput + " is even!");
        } else {
            System.out.println("The number " + userInput + " is odd!");
        }
    }
}
