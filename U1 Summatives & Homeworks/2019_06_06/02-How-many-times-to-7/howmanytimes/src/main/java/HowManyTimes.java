import java.util.Random;

public class HowManyTimes {
    public static void main(String[] args) {
        Random randomGenerator = new Random();


        int dice1, dice2, dice3, dice4 = 0;

        int diceTotal, diceTotal2, leftCount, totalRolls = 0;

        int nextSeven = 1;

        for (int i = 0; i < 100; i++) {

            int diceCount = i + 1;

            dice1 = randomGenerator.nextInt(6) +1;
            System.out.println(dice1);

            dice2 = randomGenerator.nextInt(6) +1;
            System.out.println(dice2);

            diceTotal = dice1 + dice2;

            System.out.println("The dice total is " + diceTotal);

            if (diceTotal == 7) {

                leftCount = 100 - diceCount;

                System.out.println(leftCount);

                for (int j = 0; j < leftCount + 1; j++) {

                    dice3 = randomGenerator.nextInt(6) + 1;

                    System.out.println(dice3);

                    dice4 = randomGenerator.nextInt(6) + 1;

                    System.out.println(dice4);

                    diceTotal2 = dice3 + dice4;

                    System.out.println("The dice total 2 is " + diceTotal2);

                    System.out.println("This is roll number " + j);

                    if (diceTotal2 == 7) {

                        nextSeven++;

                        System.out.println(nextSeven);
                    }

                }

                System.out.println("It took " + diceCount + " rolls to get 7.");

                System.out.println("The total number of 7s rolled was " + nextSeven);

                break;

            }

        }


    }


}
