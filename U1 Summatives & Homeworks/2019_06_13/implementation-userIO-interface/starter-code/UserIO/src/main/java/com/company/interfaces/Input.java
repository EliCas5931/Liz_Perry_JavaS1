package com.company.interfaces;

import java.util.Scanner;

public class Input implements UserIO {

    Scanner myScanner = new Scanner(System.in);

//    private String prompt;

    public int readInt(String prompt) {
        System.out.println(prompt);
        int userPrompt = myScanner.nextInt();
        return userPrompt;
    }

    public long readLong(String prompt) {
        System.out.println(prompt);
        long userPrompt = myScanner.nextLong();
        return userPrompt;
    }

    public double readDouble(String prompt) {
        System.out.println(prompt);
        double userPrompt = myScanner.nextDouble();
        return userPrompt;
    }

    public float readFloat(String prompt) {
        System.out.println(prompt);
        float userPrompt = myScanner.nextFloat();
        return userPrompt;
    }

    public String readString(String prompt) {
        System.out.println(prompt);
        String userPrompt = myScanner.nextLine();
        return userPrompt;
    }
}
