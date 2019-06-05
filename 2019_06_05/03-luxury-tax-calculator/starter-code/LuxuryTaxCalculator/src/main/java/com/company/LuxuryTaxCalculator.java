package com.company;

import java.util.Scanner;

public class LuxuryTaxCalculator {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Please enter the salary for the 1st Player with no commas or a dollar sign\n");

        int salary1 = Integer.parseInt(myScanner.nextLine());

        System.out.println("Please enter the salary for the 2nd Player with no commas or a dollar sign\n");

        int salary2 = Integer.parseInt(myScanner.nextLine());

        System.out.println("Please enter the salary for the 3rd Player with no commas or a dollar sign\n");

        int salary3 = Integer.parseInt(myScanner.nextLine());

        int sumSalary = salary1 + salary2 + salary3;

        System.out.printf("The total salary for the 3 players is " + sumSalary + "\n");

        if (sumSalary > 40000000) {

            int difference = sumSalary - 40000000;

            System.out.printf("The team has gone over their budget by " + difference + "\n");

            float taxable = difference * .18f;

            System.out.printf("The cost of the luxury tax for the team is " + "%.0f", taxable);

        }
    }
}
