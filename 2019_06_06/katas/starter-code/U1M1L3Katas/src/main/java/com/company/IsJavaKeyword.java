package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class IsJavaKeyword {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        String[] keywords = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float", "for", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "null", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while"};

        System.out.println("Please input any Java keywords you may know.");

        String userInput = myScanner.nextLine();

        if (Arrays.asList(keywords).contains(userInput)) {
            System.out.println("That is a Java keyword!");
        } else {
            System.out.println("That is not a Java keyword!");
        }

    }
}
