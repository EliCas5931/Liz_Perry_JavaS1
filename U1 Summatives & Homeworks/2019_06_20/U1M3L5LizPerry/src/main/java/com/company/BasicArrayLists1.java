package com.company;

import java.util.ArrayList;
import java.util.List;

public class BasicArrayLists1 {

    public static void main(String[] args) {

        List<Integer> arrayLength = new ArrayList<>();

        for(int i = 0; i <10; i++) {

            arrayLength.add(-133);

        }

        for(int i =0; i < arrayLength.size(); i++) {

            System.out.println("Slot " + i + " contains a " +arrayLength.get(i));

        }

    }
}
