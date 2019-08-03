package com.company;

public class App {

    public static void main(String[] args) {

        Calculator returnCalc = new Calculator();

        // return int calculations
        returnCalc.additionInt(1, 1);
        returnCalc.subtractionInt(23, 52);
        returnCalc.multiplicationInt(34, 2);
        returnCalc.divisionInt(12, 3);
        returnCalc.divisionInt(12, 7);

        //return double calculations
        returnCalc.additionDouble(3.4, 2.3);
        returnCalc.multiplicationDouble(6.7, 4.4);
        returnCalc.subtractionDouble(5.5, 0.5);
        returnCalc.divisionDouble(10.8, 2.2);

    }
}
