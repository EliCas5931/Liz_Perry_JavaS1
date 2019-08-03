package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LocatingLargestValueInArrayList {

    public static void main(String[] args) {

        List<Integer> arrayList1 = new ArrayList<>();

        Random randomGenerator = new Random();

        for (int i = 0; i < 10; i++) {

            arrayList1.add(randomGenerator.nextInt(100) + 1);

        }

        System.out.println("ArrayList: " + arrayList1 + "\n");

        int getLargest = arrayList1.get(0);

        for (Integer number: arrayList1) {

            if (number > getLargest) {

                getLargest = number;

            }

        }

        int getIndex = arrayList1.indexOf(getLargest);

        System.out.println("The largest value is " + getLargest + ", which is in slot " + getIndex);
    }
}
