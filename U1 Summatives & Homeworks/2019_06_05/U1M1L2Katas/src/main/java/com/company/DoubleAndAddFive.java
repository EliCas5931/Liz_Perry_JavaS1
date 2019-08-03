package com.company;

import java.util.Scanner;

public class DoubleAndAddFive {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please pick a number.");
        int num1 = Integer.parseInt(myScanner.nextLine());

        int num2 = num1 * 2;

        int num3 = num2 + 5;

        System.out.printf("%d", num3);
    }
}
