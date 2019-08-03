package com.company;

import java.util.Random;

public class FortuneCookie {
    public static void main(String[] args) {
        Random randomLotto = new Random();

        int randomFortune = randomLotto.nextInt(5);

        String[] fortuneMessage = {
                "Do not fear failure.",
                "It is now, and in this world, that we must live.",
                "You can create your own happiness.",
                "Hard work pays off in the future, laziness pays off now.",
                "You learn from mistakes... You will learn a lot today.",
                "You will become great if you believe in yourself."
        };

        System.out.println("Fortune cookie says: " + fortuneMessage[randomFortune]);

        //Print to the same line, not skipping.

        System.out.print("Your lucky numbers: ");

        for (int i = 0; i < 6; i++) {

            int luckyNumbers = randomLotto.nextInt(54) + 1;

            int [] luckyNumbersArray = new int[6];

            luckyNumbersArray[i] = luckyNumbers;

            if (i < 5) {

                System.out.print(luckyNumbersArray[i] + " - ");

            } else {

                //Figure out how to get the extra - off

                System.out.println(luckyNumbersArray[5]);

            }

        }

    }
}
