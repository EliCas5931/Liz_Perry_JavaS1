package com.company;

import java.util.Scanner;

public class LoanCalculator {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("What is the amount of your mortgage?");
        int amount = Integer.parseInt(myScanner.nextLine());

        System.out.println("What is the term of your mortgage?");
        int term = Integer.parseInt(myScanner.nextLine());

        System.out.println("What is the annual interest rate?");
        double rate = myScanner.nextFloat();
        double monthly = (rate / 100) /12;

        double number = Math.pow(monthly + 1, term);
        double mortgage = (amount * (monthly * number))/(number - 1);
        System.out.printf("%.3f", mortgage);
    }
}
