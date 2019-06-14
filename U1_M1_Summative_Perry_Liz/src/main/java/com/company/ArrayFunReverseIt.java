package com.company;

public class ArrayFunReverseIt {

    public static void main(String[] args) {

        int [] originalArray = {1, 2, 3, 4, 5};

        int [] reverseArray = new int[originalArray.length];

        for (int i = 0; i < originalArray.length; i++) {

//            reverseArray[originalArray.length - 1 - i] = originalArray[i];

            reverseArray[i] = originalArray[4 - i];

        }

        for (int forward: originalArray) {

            System.out.println(forward);

        }

        for (int reverse: reverseArray) {

            System.out.println(reverse);

        }

    }

}
