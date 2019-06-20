package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ArrayListThereOrNot {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        int userInput;

        List<Integer> arrayList1 = new ArrayList<>();

        Random randomGenerator = new Random();

        for(int i = 0; i < 10; i++){

            arrayList1.add(i, randomGenerator.nextInt(50)+1);

        }

        System.out.println(arrayList1);

        System.out.print("Value to find: ");

        userInput = myScanner.nextInt();

        int arrayCounter = 0;

        for (Integer number: arrayList1){

            if (userInput == number){

                System.out.println(number + " is in the ArrayList.");

            }else {

                arrayCounter++;

            }

        }

        if (arrayCounter == arrayList1.size()){

            System.out.println(userInput + " is not in the ArrayList.");

        }
    }
}