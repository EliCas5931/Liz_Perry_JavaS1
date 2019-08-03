package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicArrayLists2 {

    public static void main(String[] args) {

        List<Integer> whateverYourArrayListVariableIsCalled = new ArrayList<>();

        Random randomGenerator = new Random();

        int randomNumber;

        for (int i=0;i<10;i++){

            randomNumber = randomGenerator.nextInt(100)+1;

            whateverYourArrayListVariableIsCalled.add(randomNumber);

        }

        System.out.println( "ArrayList: " + whateverYourArrayListVariableIsCalled );

    }

}

