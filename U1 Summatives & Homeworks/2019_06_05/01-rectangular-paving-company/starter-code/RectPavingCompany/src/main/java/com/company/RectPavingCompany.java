package com.company;

import java.util.Scanner;

public class RectPavingCompany {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("What is the width of your driveway?");
        int width = Integer.parseInt(myScanner.nextLine());

        System.out.println("What is the length of your driveway?");
        int length = Integer.parseInt(myScanner.nextLine());

        int area = width * length;

        int perimeter1 = width * 2;

        int perimeter2 = length * 2;

        int perimeter = perimeter1 + perimeter2;

        System.out.println("The area of your driveway is " + area + " feet.");

        System.out.println("The perimeter of your driveway is " + perimeter + " feet.");

        float cement = area * 12.50f;

        float framing = perimeter * 8.25f;

        System.out.printf("The subtotal for the cement is $" + "%.2f\n", cement);

        System.out.printf("The subtotal for the framing is $" + "%.2f\n", framing);

        float driveway = cement + framing;

        System.out.printf("The total cost of the driveway is $" + "%.2f\n", driveway);

        // Version 2

        System.out.println("For another driveway, what is the total cost of the cement?");

        float newCement = myScanner.nextFloat();

        System.out.println("For the other driveway, what is the total cost of the framing?");

        float newFraming = myScanner.nextFloat();

        float cement2 = newCement / area;

        //

        System.out.printf("The cement for the driveway is $" + "%.2f\n", cement2);

        float framing2 = newFraming / perimeter;

        System.out.printf("The framing for the driveway is $" + "%.2f\n", framing2);
    }
}
