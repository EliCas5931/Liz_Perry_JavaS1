package com.company;

import java.util.Scanner;

public class ALittleQuiz {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int userCorrect = 0;

        int userIncorrect = 0;

        System.out.println("Are you ready for a quiz?");

        String userInput = myScanner.nextLine();

        if (userInput.equals("y") || (userInput.equals("Y"))) {

            System.out.println("Okay, here it comes! \n");

        } else {

            System.out.println("Okay, here it comes anyways!\n");

        }

        System.out.println("Q1) What is the sum of 945 and 237?");

        System.out.println("        1) 1183");
        System.out.println("        2) 1182");
        System.out.println("        3) 1184");

        int userChoice1 = Integer.parseInt(myScanner.nextLine());

        if (userChoice1 == 2) {

            System.out.println("That's right!\n");

            userCorrect++;

        } else {

            System.out.println("Sorry, 1182 is the sum of 945 and 237.\n");

            userIncorrect++;

        }

        System.out.println("Q2) What is the product of 89 and 15?");

        System.out.println("        1) 1337");
        System.out.println("        2) 1335");
        System.out.println("        3) 1336");

        int userChoice2 = Integer.parseInt(myScanner.nextLine());

        if (userChoice2 == 2) {

            System.out.println("That's right!\n");

            userCorrect++;

        } else {

            System.out.println("Sorry, 1335 is the product of 89 and 15.\n");

            userIncorrect++;

        }

        System.out.println("Q3) What is 17^2?");

        System.out.println("        1) 4913");
        System.out.println("        2) 289");
        System.out.println("        3) 17");

        int userChoice3 = Integer.parseInt(myScanner.nextLine());

        if (userChoice3 == 2) {

            System.out.println("That's right!\n");

            userCorrect++;

        } else {

            System.out.println("Sorry, 289 is the squared expression of 17.\n");

            userIncorrect++;

        }

        System.out.println("Overall, you got " + userCorrect + " correct and " + userIncorrect + " wrong.");
        System.out.println("Thanks for playing!");

    }

}
