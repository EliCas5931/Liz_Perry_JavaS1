package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ArrayListWhereIsIt {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        Random randomGenerator = new Random();

        List<Integer> arrayList1 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            arrayList1.add(randomGenerator.nextInt(50) + 1);

        }



        System.out.println("ArrayList: " + arrayList1);

        System.out.println("Value to find");

        int userIntInput = userInput.nextInt();

        boolean isInArray = arrayList1.contains(userIntInput);



        if (isInArray) {

            System.out.println(userIntInput + " is in Slot " + arrayList1.indexOf(userIntInput));

        }

        if (!isInArray){

            System.out.println(userIntInput + " is not in the ArrayList");

        }

    }

}