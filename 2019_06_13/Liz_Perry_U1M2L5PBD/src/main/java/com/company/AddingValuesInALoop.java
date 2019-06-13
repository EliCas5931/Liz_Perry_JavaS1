package com.company;

import java.util.Scanner;

public class AddingValuesInALoop {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        int sum = 0;

        System.out.println("I will add up all the numbers you give me.");

        System.out.println("Number: ");

        int userInt = Integer.parseInt(myScanner.nextLine());

        sum = userInt + sum;

        while (userInt != 0) {

            System.out.println("The total so far is " + sum);

            System.out.println("Number: ");

            userInt = Integer.parseInt(myScanner.nextLine());

            sum = userInt + sum;

        }

        System.out.println("The total is " + sum);

    }
}
