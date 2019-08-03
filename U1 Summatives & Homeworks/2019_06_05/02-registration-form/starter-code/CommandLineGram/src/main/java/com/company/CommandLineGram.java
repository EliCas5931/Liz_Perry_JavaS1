package com.company;

import java.util.Scanner;

public class CommandLineGram {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("What is your first name?");
        String firstName = myScanner.nextLine();

        System.out.println("What is your last name?");
        String lastName = myScanner.nextLine();

        System.out.println("What is your email?");
        String email = myScanner.nextLine();

        System.out.println("What is your Twitter handle?");
        String twitter = myScanner.nextLine();

        System.out.println("What is your age?");
        String age = myScanner.nextLine();

        System.out.println("What country do you live in?");
        String country = myScanner.nextLine();

        System.out.println("What is your profession?");
        String profession = myScanner.nextLine();

        System.out.println("What is your favorite operating system?");
        String os = myScanner.nextLine();

        System.out.println("What is your favorite programming language?");
        String language = myScanner.nextLine();

        System.out.println("Who is your favorite computer scientist?");
        String scientist = myScanner.nextLine();

        System.out.println("What is your favorite keyboard shortcut?");
        String shortcut = myScanner.nextLine();

        System.out.println("Have you ever built your own computer?");
        String built = myScanner.nextLine();

        System.out.println("If you could be any superhero, who would it be?");
        String superhero = myScanner.nextLine();

        System.out.println("\n" + firstName);
        System.out.println(lastName);
        System.out.println(email);
        System.out.println(twitter);
        System.out.println(age);
        System.out.println(country);
        System.out.println(profession);
        System.out.println(os);
        System.out.println(language);
        System.out.println(scientist);
        System.out.println(shortcut);
        System.out.println(built);
        System.out.println(superhero);

    }
}
