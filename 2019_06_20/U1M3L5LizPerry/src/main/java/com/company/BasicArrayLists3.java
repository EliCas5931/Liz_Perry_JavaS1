package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicArrayLists3 {

    public static void main(String[] args) {

        List<Integer> whateverYourArrayListVariableIsCalled = new ArrayList<>();

        Random randomGenerator = new Random();

        int randomNumber;

        for (int i = 0; i < 1000; i++) {

            randomNumber = randomGenerator.nextInt(99) + 10;

            whateverYourArrayListVariableIsCalled.add(randomNumber);

        }

        System.out.println( whateverYourArrayListVariableIsCalled);

    }

}
