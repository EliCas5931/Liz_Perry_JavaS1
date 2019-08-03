package com.company;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetIterator {

    public void printSet(int int1, int int2, int int3, int int4, int int5) {

        Set <Integer> newSetter = new HashSet<>();

        newSetter.add(int1);
        newSetter.add(int2);
        newSetter.add(int3);
        newSetter.add(int4);
        newSetter.add(int5);

        Iterator<Integer> integerIterator = newSetter.iterator();

        while (integerIterator.hasNext()) {
            System.out.println(integerIterator.next());
        }
    }
}
