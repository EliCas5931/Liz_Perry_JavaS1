package com.company;

import java.util.Scanner;


public class PrimeFinder {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Choose a ceiling number:");
        int userInput = myScanner.nextInt();

        for(int i = 2; i <= userInput; i++) {
            boolean prime = true;
            for(int j = i - 1; j >= 2; j--) {
                if(i % j == 0) {
                    prime = false;
                }

            }
            if(prime) {
                System.out.println(i);
            }
        }
    }
}