package com.company;

import java.util.Scanner;

public class CountByThirteen {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please pick a number.");
        int userInput = Integer.parseInt(myScanner.nextLine());

        for (int i = 0; i < userInput + 1; i += 13) {
            System.out.println(i);
        }
    }
}