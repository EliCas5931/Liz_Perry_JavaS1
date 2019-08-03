package com.company;

public class ModulusAnimation {
    public static void main( String[] args ) throws Exception {

        int repeats = 5;
        int steps_per_second = 10;

        for (int i=0; i<repeats*11; i++ ) {

            if (i % 11 == 0)

                System.out.print("Liz is really tired. \r");

            else if (i % 11 == 1)

                System.out.print("ed. Liz is really tir \r");

            else if (i % 11 == 2)

                System.out.print("tired. Liz is really \r");

            else if (i % 11 == 3)

                System.out.print("lly tired. Liz is re \r");

            else if (i % 11 == 4)

                System.out.print("really tired. Liz is \r");

            else if (i % 11 == 5)

                System.out.print("is really tired. Liz \r");

            else if (i % 11 == 6)

                System.out.print("iz is really tired. L \r");

            else if (i % 11 == 7)

                System.out.print("Liz is really tired. \r");

            else if (i % 11 == 8)

                System.out.print("red. Liz is really ti \r");

            else if (i % 11 == 9)

                System.out.print("tired. Liz is really \r");

            else if (i % 11 == 10)

                System.out.print("ally tired. Liz is re \r");

                Thread.sleep(1000/steps_per_second);

        }
    }
}

