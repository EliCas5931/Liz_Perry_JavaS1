package com.company;

import java.util.Scanner;

public class AverageThree {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter a number between 1 - 10.");
        int num1 = Integer.parseInt(myScanner.nextLine());

        System.out.println("Please enter another number between 1 - 10.");
        int num2 = Integer.parseInt(myScanner.nextLine());

        System.out.println("Please enter another number between 1 - 10.");
        int num3 = Integer.parseInt((myScanner.nextLine()));

        int sum = num1 + num2 + num3;

        float sum2 = sum / 3.00f;

        System.out.format("%.2f",sum2);
    }
}

