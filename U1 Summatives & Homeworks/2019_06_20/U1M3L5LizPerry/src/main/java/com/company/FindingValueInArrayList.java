package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FindingValueInArrayList {

    public static void main(String[] args) {

        List<Integer> arrayList1 = new ArrayList<>();

        Random randomGenerator = new Random();

        int randomNumber;

        for (int i = 0; i < 10; i++) {

            randomNumber = randomGenerator.nextInt(50) + 1;

            arrayList1.add(randomNumber);

        }

        Scanner userInput = new Scanner(System.in);

        System.out.println(arrayList1);

        System.out.println("Value to find");

        int userIntInput = userInput.nextInt();

        for (Integer numbers: arrayList1) {

            if (userIntInput == numbers) {

                System.out.println(numbers + " is in the ArrayList.");

            }

        }

    }

}