package com.company;

public class App {
    public static int subtract (int a, int b) {
        return a - b;
    }

    public static int subtractOrZero (int a, int b) {
        if ((a - b) < 0) {
            return 0;
        } else {
            return a - b;
        }
    }

    public static int max (int a, int b, int c) {
        int value;

        if (a > b) {
            value = a;
        } else {
            value = b;
        }

        if (value > c) {
            return value;
        } else {
            return c;
        }
    }

    public static int min (int a, int b, int c) {
        int number;

        if (a < b) {
            number = a;
        } else {
            number = b;
        }

        if (number < c) {
            return number;
        } else {
            return c;
        }
    }

    public static boolean isLarger (int first, int second) {
        if (first > second) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

    }

}
