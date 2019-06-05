package com.company;

import java.util.Scanner;

public class SubtractTwo {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter a number.");
        int num1 = Integer.parseInt(myScanner.nextLine());

        System.out.println("Please enter another number.");
        int num2 = Integer.parseInt(myScanner.nextLine());

        int subtract = num1 - num2;

        System.out.printf("%d", subtract);
    }
}
