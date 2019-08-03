package com.company;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Random;

public class CopyingArrayLists {

    public static void main(String[] args) {

        List<Integer> arrayList1 = new ArrayList<>();

        List<Integer> arrayList2 = new ArrayList<>();

        Random randomGenerator = new Random();

        int randomNumber;

        for (int i = 0; i < 10; i++) {

            randomNumber = randomGenerator.nextInt(100) + 1;

            arrayList1.add(randomNumber);

            arrayList2.add(randomNumber);

        }

        arrayList1.set(9, -7);

        System.out.println(arrayList1);

        System.out.println(arrayList2);

    }

}
