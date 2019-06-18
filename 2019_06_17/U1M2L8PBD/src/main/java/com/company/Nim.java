package com.company;

import java.util.Scanner;

public class Nim {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        int pile1 = 3;

        int pile2 = 4;

        int pile3 = 5;

        int playerTurn = 0;

        String currentPlayer;


        System.out.print("Player 1, enter your name: ");

        String userName1 = myScanner.nextLine();

        System.out.print("Player 2, enter your name: \n");

        String userName2 = myScanner.nextLine();




        do {

            System.out.println("A: " + pile1 + "    B: " + pile2 + "    C: " + pile3 + "\n");



            // which player is up?

            if (playerTurn % 2 == 0) {

                currentPlayer = userName1;

            } else {

                currentPlayer = userName2;

            }



            System.out.println(currentPlayer + ", choose a pile: ");

            String userInput = myScanner.nextLine();

            System.out.println("How many to remove from pile " + userInput);

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

            playerTurn++;

        } while (pile1 > 0 || pile2 > 0 || pile3 > 0);

        if (pile1 <= 0 && pile2 <= 0 && pile3 <= 0) {

            if (playerTurn % 2 == 0) {

                System.out.println(userName1 + ", there are no counters left, so you WIN!");

            } else {

                System.out.println(userName2 + ", there are no counters left, so you WIN!");

            }

        }

    }
}
