package com.company;

import java.util.Scanner;

public class UltimateQuestion {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String userInput;
        int userInt;

        do {
            System.out.println("Please choose a number between 1 and 100!");
            userInput = myScanner.nextLine();
            userInt = Integer.parseInt(userInput);
        } while (userInt != 42);
        System.out.println("That's the number I was looking for! 42 is definitely the answer!");
    }
}
