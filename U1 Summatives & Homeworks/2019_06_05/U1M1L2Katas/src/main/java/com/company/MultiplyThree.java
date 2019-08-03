package com.company;

import java.util.Scanner;

public class MultiplyThree {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter a number.");
        int num1 = Integer.parseInt(myScanner.nextLine());

        System.out.println("Please enter another number.");
        int num2 = Integer.parseInt(myScanner.nextLine());

        System.out.println("Please enter another number.");
        int num3 = Integer.parseInt((myScanner.nextLine()));

        int multiple = num1 * num2 * num3;

        System.out.format("%d", multiple);
    }
}