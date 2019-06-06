package com.company;

import java.util.Scanner;

public class YourAgeCan {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("What is your age?");
        int userInput = Integer.parseInt(myScanner.nextLine());

        if (userInput >= 18 && userInput < 21) {
            System.out.println("You are old enough to vote.");
        } else if (userInput >= 18 && userInput < 35) {
            System.out.println("You are old enough to vote and drink alcohol.");
        } else if (userInput >= 18 && userInput < 55) {
            System.out.println("You are old enough to vote, drink alcohol, and be president.");
        } else if (userInput >=18 && userInput < 65) {
            System.out.println("You are old enough to vote, drink alcohol, be president, and eligible for aarp.");
        } else if (userInput >= 18 && userInput < 80) {
            System.out.println("You are old enough to vote, drink alcohol, be president, eligible for aarp, and can retire.");
        } else if (userInput >= 80 && userInput <=89) {
            System.out.println("You are old enough to vote, drink alcohol, be president, eligible for aarp, can retire and are an octogenarian.");
        } else if (userInput >= 18 && userInput < 100) {
            System.out.println("You are old enough to vote, drink alcohol, be president, eligible for aarp, can retire and you were an octogenarian.");
        } else if (userInput > 100) {
            System.out.println("You are old enough to vote, drink alcohol, be president, eligible for aarp, can retire, are an octogenarian and more than a century old.");
        }
    }
}
