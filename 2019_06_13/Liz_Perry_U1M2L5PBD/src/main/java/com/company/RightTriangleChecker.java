package com.company;

import java.util.Scanner;

public class RightTriangleChecker {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        int side2, side3;

        System.out.println("Enter three integers: ");

        System.out.println("Side 1: ");

        int side1 = Integer.parseInt(myScanner.nextLine());

        do {

            System.out.println("Side 2: ");

            side2 = Integer.parseInt(myScanner.nextLine());

            if (side1 > side2) {

                System.out.println(side2 + " is smaller than " + side1 + ". Try again.");

            }

        } while (side1 > side2);

        do {

            System.out.println("Side 3: ");

            side3 = Integer.parseInt(myScanner.nextLine());

            if (side2 > side3) {

                System.out.println(side3 + " is smaller than " + side2 + ". Try again.");

            }

        } while (side2 > side3);

        System.out.println("Your three sides are " + side1 + " " + side2 + " " + side3);

        int firstTwoSides = (side1 * side1 + side2 * side2);

        int thirdSide = (side3 * side3);

        if (firstTwoSides == thirdSide) {

            System.out.println("These sides *do* make a right triangle. Yippy-skippy!");

        } else {

            System.out.println("NO! These sides do not make a right triangle!");

        }

    }
}
