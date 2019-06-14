package com.company;

import java.util.Scanner;

public class ArrayFunFiveWords {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        int userWords = 0;

        String [] userArray = new String [5];

        while (userWords < 5) {

            System.out.println("Enter a word: ");

            userArray[userWords] = myScanner.nextLine();

            userWords++;

        }

        for (String elements: userArray) {

            System.out.println(elements);

        }

    }

}
