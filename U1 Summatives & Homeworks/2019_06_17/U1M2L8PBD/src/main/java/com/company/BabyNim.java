package com.company;

import java.util.Scanner;

public class BabyNim {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        int pile1 = 3;

        int pile2 = 3;

        int pile3 = 3;

        while (pile1 > 0 || pile2 > 0 || pile3 > 0) {

            System.out.println("A: " + pile1 + "    B: " + pile2 + "    C: " + pile3);

            System.out.println("Choose a pile: ");

            String userInput = myScanner.nextLine();

            System.out.print("How many to remove from pile " + userInput + ": \n");

            int toRemove = Integer.parseInt(myScanner.nextLine());

            if (userInput.equals("A")) {

                pile1 = pile1 - toRemove;

            } else if (userInput.equals("B")) {

                pile2 = pile2 - toRemove;

            } else if (userInput.equals("C")) {

                pile3 = pile3 - toRemove;

            } else {

                System.out.println("Please enter a valid pile and number.");
            }

            if (pile1 <= 0 && pile2 <= 0 && pile3 <= 0) {

                System.out.println();

                System.out.println("A: " + pile1 + "    B: " + pile2 + "    C: " + pile3 + "\n");

            }

        }

        System.out.println("All piles are empty. Good job!");


    }

}
