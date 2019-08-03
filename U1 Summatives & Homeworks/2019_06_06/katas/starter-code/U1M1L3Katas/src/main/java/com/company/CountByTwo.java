package com.company;

import java.util.Scanner;

public class CountByTwo {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please pick a number.");
        int userInput = Integer.parseInt(myScanner.nextLine());

//        for (int i = 0; i < userInput; i++) {
//            if (i % 2 == 0) {
//                System.out.println(i + " ");
//                if (i + 1 == userInput) {
//                    System.out.println(userInput);
//                } else if (i + 2 == userInput) {
//                    System.out.println(userInput);
//                }
//            }
//        }

        for (int i = 0; i < userInput + 1; i += 2) {
            System.out.println(i);
        }
    }
}
