package com.company;

import java.util.Scanner;

public class ArrayFunUserArray {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        int userInt = 0;

        int [] userArray = new int[5];

        while (userInt < 5) {

            System.out.println("Enter a number: \n");

            userArray[userInt] = Integer.parseInt(myScanner.nextLine());

            userInt++;

        }

        for (int elements: userArray) {

            System.out.println(elements);

        }

    }

}
