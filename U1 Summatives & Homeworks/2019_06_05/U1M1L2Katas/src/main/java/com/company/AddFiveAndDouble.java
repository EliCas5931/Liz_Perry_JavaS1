package com.company;

import java.util.Scanner;

public class AddFiveAndDouble {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please pick a number.");
        int num1 = Integer.parseInt(myScanner.nextLine());

        int num2 = num1 + 5;

        int num3 = num2 * 2;

        System.out.printf("%d", num3);
    }
}
