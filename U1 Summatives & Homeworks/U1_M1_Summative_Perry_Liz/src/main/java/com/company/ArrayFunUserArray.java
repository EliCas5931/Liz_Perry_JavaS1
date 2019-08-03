package com.company;

import java.util.Scanner;

public class ArrayFunUserArray {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        int userInt = 0;

        // create 5 new ints for array

        int [] userArray = new int[5];

        while (userInt < 5) {

            System.out.println("Enter a number: \n");

            //function that parses a string and returns an in below

            userArray[userInt] = Integer.parseInt(myScanner.nextLine());

            userInt++;

        }

        for (int elements: userArray) {

            System.out.println(elements);

        }

    }

}
