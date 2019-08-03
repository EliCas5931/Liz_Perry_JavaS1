package com.company;

public class App {
    public static void main(String[] args) {

    }

    public static int total (int[] sumArr) {

        int sum = 0;

        for (int i = 0; i < sumArr.length; i++)

          sum += sumArr[i];

        return sum;
    }

    public static int totalOdd (int[] oddArr) {

        int odd = 0;

        for (int i = 1; i < oddArr.length; i += 2)

            odd += oddArr[i];

        return odd;
    }

    public static int totalEven (int[] evenArr) {

        int even = 0;

        for (int i = 0; i < evenArr.length; i += 2)

            even += evenArr[i];

        return even;
    }


    public static int secondLargestNumber (int[] secondArr) {

        int largest = secondArr[0];

        int secondLargest = secondArr[1];

        for (int i = 0; i < secondArr.length; i++) {

            if (secondArr[i] > largest) {

                secondLargest = largest;

                largest = secondArr[i];

            } else if (secondArr[i] > secondLargest && secondArr[i] != largest) {

                secondLargest = secondArr[i];

            }

        }

        return secondLargest;

    }

    public static String [] swapFirstAndLast (String[] swapArr) {

        String first = swapArr[0];

        String last = swapArr[swapArr.length - 1];

        swapArr[0] = last;

        swapArr[swapArr.length - 1] = first;

        return swapArr;
    }

    public static int[] reverse (int[] reverseArgs) {

        for (int i = 0; i < reverseArgs.length / 2; i++) {

            int numbers = reverseArgs[i];

            reverseArgs[i] = reverseArgs[reverseArgs.length - i - 1];

            reverseArgs[reverseArgs.length - i -1] = numbers;

        }

        return reverseArgs;

    }

    public static String concatenateString (String [] concatArgs) {

        String allWords = "";

        for (int i = 0; i < concatArgs.length; i++) {

            allWords += concatArgs[i];
        }

        return allWords;

    }

    public static int[] everyThird (int[] thirdArgs) {

        if (thirdArgs.length < 3) {

            return null;

        }

        int start = 0;

        int[] arrThird = new int [thirdArgs.length / 3];

        for (int i = 2; i < thirdArgs.length; i += 3) {

            arrThird[start] += thirdArgs[i];

            start++;

        }

        return arrThird;
    }

    public static int[] lessThanFive (int[] fiveArgs) {

        int start = 0;

        for(int i = 0; i < fiveArgs.length; i++) {

            if(fiveArgs[i] < 5) {

                start++;

            }

        }

        if(start == 0) {

            return null;

        }

        int[] containsFive = new int[start];

        int begins = 0;

        for(int j = 0; j < fiveArgs.length; j++) {

            if(fiveArgs[j] < 5) {

                containsFive[begins] = fiveArgs[j];

                begins++;

            }

        }

        return containsFive;

    }

    public static int [] [] splitAtFive (int[] splitArgs) {

        int aboveFive = 0, belowFive = 0, countsBelow = 0, countsAbove = 0;

        for (int i = 0; i < splitArgs.length; i++) {

            if (splitArgs[i] < 5) {

                belowFive++;

            } else {

                aboveFive++;

            }

        }

        int [] splitBelowFive = new int[belowFive];

        int [] splitAboveFive = new int[aboveFive];

        for (int i = 0; i < splitArgs.length; i++) {

            if (splitArgs[i] < 5) {

                splitBelowFive[countsBelow] = splitArgs[i];

                countsBelow++;

            } else {

                splitAboveFive[countsAbove] = splitArgs[i];

                countsAbove++;
            }

        }

        int [] [] twoDimArray = {splitBelowFive, splitAboveFive};

        return twoDimArray;

    }

    public static String [] [] evensAndOdds(String[] evensOddsArr) {

        int evenCount = 0, oddCount = 0;

        for (int i = 0; i < evensOddsArr.length; i++) {

            if (i % 2 == 0) {

                evenCount++;

            } else {

                oddCount++;
            }

        }

        String [] evenArray = new String[evenCount];

        String [] oddArray = new String[oddCount];

        int evenInt = 0, oddInt = 0;

        for (int evenIndex = 0; evenIndex < evensOddsArr.length; evenIndex += 2) {

            evenArray[evenInt] = evensOddsArr[evenIndex];

            evenInt++;

        }

        for (int oddIndex = 1; oddIndex < evensOddsArr.length; oddIndex += 2) {

            oddArray[oddInt] = evensOddsArr[oddIndex];

            oddInt++;

        }

        String [] [] twoDimsArray = {evenArray, oddArray};

        return twoDimsArray;

    }

}
