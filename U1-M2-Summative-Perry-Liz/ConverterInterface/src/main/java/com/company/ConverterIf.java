package com.company;

import com.company.Interfaces.Converter;

public class ConverterIf implements Converter {

    //Convert user input for month number to return related month

    public String convertMonth (int monthNumber) {

        if (monthNumber == 1) {

            return "January";

        } else if (monthNumber == 2) {

            return "February";

        } else if (monthNumber == 3) {

            return "March";

        } else if (monthNumber == 4) {

            return "April";

        } else if (monthNumber == 5) {

            return "May";

        } else if (monthNumber == 6) {

            return "June";

        } else if (monthNumber == 7) {

            return "July";

        } else if (monthNumber == 8) {

            return "August";

        } else if (monthNumber == 9) {

            return "September";

        } else if (monthNumber == 10) {

            return "October";

        } else if (monthNumber == 11) {

            return "November";

        } else {

            return "You have entered an invalid number. You must enter a number between 1 and 12.";
        }

    }


    //convert user input for day number to corresponding day

    public String convertDay (int dayNumber) {

        if (dayNumber == 1) {

            return "Monday";

        } else if (dayNumber == 2) {

            return "Tuesday";

        } else if (dayNumber == 3) {

            return "Wednesday";

        } else if (dayNumber == 4) {

            return "Thursday";

        } else if (dayNumber == 5) {

            return "Friday";

        } else if (dayNumber == 6) {

            return "Saturday";

        } else if (dayNumber == 7){

            return "Sunday";

        } else {

            return "You have entered an invalid number. You must enter a number between 1 and 7.";
        }
    }
}
