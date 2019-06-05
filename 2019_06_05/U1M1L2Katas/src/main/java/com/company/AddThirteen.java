package com.company;

import java.util.Scanner;

public class AddThirteen {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please pick a number.");
        int num1 = Integer.parseInt(myScanner.nextLine());

        int sum = num1 + 13;

        System.out.println("Your number + 13 = " + sum);
    }
}
