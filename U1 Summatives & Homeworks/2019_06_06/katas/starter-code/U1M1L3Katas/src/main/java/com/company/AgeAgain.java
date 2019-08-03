package com.company;

import java.util.Scanner;

public class AgeAgain {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String userGrade, userCollege, whichCollege, afterSchool, userJob;
        System.out.println("What is your age?");
        int userInput = Integer.parseInt(myScanner.nextLine());

        if (userInput < 14) {
            System.out.println("What grade number are you in?");
            userGrade = myScanner.nextLine();

            System.out.println("Wow! " + userGrade + " grade - that sounds exciting!");
        } else if (userInput >= 14 && userInput <= 18) {
            System.out.println("Are you planning on going to college?");
            userCollege = myScanner.nextLine();

            if (userCollege.equals("yes")) {
                System.out.println("Which college?");
                whichCollege = myScanner.nextLine();
                System.out.println(whichCollege + " is a great school!");
            } else if (userCollege.equals("no")) {
                System.out.println("What do you want to do after high school?");
                afterSchool = myScanner.nextLine();
                System.out.println("Wow, " + afterSchool + " sounds like a plan!");
            } else {
                System.out.println("Please respond yes or no.");
            }
        } else if(userInput > 18) {
            System.out.println("What kind of job do you have?");
            userJob= myScanner.nextLine();
            System.out.printf("%s",userJob + " sounds like a great job!");
        } else {
            System.out.println("Invalid response.");
        }
    }
}
