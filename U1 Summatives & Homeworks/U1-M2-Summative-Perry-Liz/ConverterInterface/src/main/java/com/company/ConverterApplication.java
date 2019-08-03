package com.company;

import com.company.Interfaces.Converter;

public class ConverterApplication {

    //main method to instantiate and use both if and switch classes

    public static void main(String[] args) {

        Converter ifState = new ConverterIf();

        Converter switchState = new ConverterSwitch();


        // Check if working correctly
        // if statements
        System.out.println("4 - Thursday & April");

        System.out.println(ifState.convertDay(4));

        System.out.println(ifState.convertMonth(4));


        // switch statements
        System.out.println("7 - Sunday & July");

        System.out.println(switchState.convertMonth(7));

        System.out.println(switchState.convertDay(7));
    }
}
