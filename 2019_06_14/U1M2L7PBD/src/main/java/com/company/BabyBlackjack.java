package com.company;

import java.util.Random;

public class BabyBlackjack {

    public static void main(String[] args) {

        Random randomGenerator = new Random();

        System.out.println("Baby Blackjack!\n");

//         This was in the for loop section so I assumed I HAD to use a for loop... however I wouldn't in this case. Just
//         a simple if/elseif/else would work

        for (int i = 0; i < 1; i++) {

            int playersCards1 = randomGenerator.nextInt(10) + 1;

            int playersCards2 = randomGenerator.nextInt(10) + 1;

            int playerTotal = playersCards1 + playersCards2;

            System.out.println("You drew " + playersCards1 + " and " + playersCards2);

            System.out.println("Your total is " + playerTotal + ".\n");

            int dealersCards1 = randomGenerator.nextInt(10) + 1;

            int dealersCards2 = randomGenerator.nextInt(10) + 1;

            int dealerTotal = dealersCards1 + dealersCards2;

            System.out.println("The dealer drew " + dealersCards1 + " and " + dealersCards2);

            System.out.println("Their total is " + dealerTotal + ".\n");

            if (playerTotal > dealerTotal) {

                System.out.println("YOU WIN!");

            } else if (dealerTotal > playerTotal) {

                System.out.println("DEALER WINS!");

            } else {

                System.out.println("IT'S A TIE!");

            }

        }

    }

}
