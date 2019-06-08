package com.company;

public class App {
    public static void main(String[] args) {
    }

//    public static int total (int[] sumArr) {
//        int sum = 0;

//        for (int i = 0; i < sumArr.length; i++)
//
//          sum += sumArr[i];

//        return sum;
//    }

//    public static int totalOdd (int[] oddArr) {
//        int odd = 0;
//
//        for (int i = 1; i < oddArr.length; i += 2)

//            odd += oddArr[i];

//        return odd;
//    }

//    public static int totalEven (int[] evenArr) {
//        int even = 0;
//
//        for (int i = 0; i < evenArr.length; i += 2)
//
//            even += evenArr[i];
//
//        return even;
//    }


    public static int secondLargestNumber (int[] secondArr) {
        int [] secondArray = {};

        int largest = secondArray[0];

        int secondLargest = secondArray[1];

        for (int i = 0; i < secondArr.length; i++) {

            if (secondArray[i] > largest) {

                secondLargest = largest;

                largest = secondArray[i];

            } else if (secondArray[i] > secondLargest && secondArray[i] != largest) {

                secondLargest = secondArray[i];
            }
        }
        return secondLargest;
    }


}
