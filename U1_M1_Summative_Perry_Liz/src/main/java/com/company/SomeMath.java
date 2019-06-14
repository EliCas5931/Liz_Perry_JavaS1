package com.company;

public class SomeMath {

    public static void main(String[] args) {

        System.out.println(totalFive(1, 2, 3, 4, 5));

        System.out.println(averageFive(1,3,5,7,9));

        System.out.println(largestFive(42.0, 35.1, 2.3, 40.2, 15.6));

    }

    public static int totalFive (int num1, int num2, int num3, int num4, int num5) {

        int sumFive;

        sumFive = num1 + num2 + num3 + num4 + num5;

        return sumFive;
    }

    public static double averageFive (int num1, int num2, int num3, int num4, int num5) {

        double avgFive = (num1 + num2 + num3 + num4 + num5) / 5;

        return avgFive;
    }

//    public static double largestFive (double [] numbers)

    public static double largestFive (double num1, double num2, double num3, double num4, double num5) {

        double [] numbers = {num1, num2, num3, num4, num5};

        double returnLarge = numbers[0];

        for (int i = 1; i < numbers.length; i++) {

            if (numbers[i] > returnLarge) {

                returnLarge = numbers[i];

            }

        }

        return returnLarge;

    }

}
