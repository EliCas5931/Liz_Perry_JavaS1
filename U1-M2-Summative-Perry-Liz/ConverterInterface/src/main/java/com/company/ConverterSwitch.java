package com.company;

import com.company.Interfaces.Converter;

public class ConverterSwitch implements Converter {

    // convert userinput for month number to correct month

    public String convertMonth (int monthNumber) {

        switch (monthNumber) {
            case 1:
                return "January";

            case 2:
                return "February";

            case 3:
                return "March";

            case 4:
                return "April";

            case 5:
                return "May";

            case 6:
                return "June";

            case 7:
                return "July";

            case 8:
                return "August";

            case 9:
                return "September";

            case 10:
                return "October";

            case 11:
                return "November";

            case 12:
                return "December";

            default:
                return "You have entered an invalid number. You must enter a number between 1 and 12.";
        }
    }

    //convert userinput for day number to correct day

    public String convertDay (int dayNumber) {

        switch (dayNumber) {

            case 1:
                return "Monday";

            case 2:
                return "Tuesday";

            case 3:
                return "Wednesday";

            case 4:
                return "Thursday";

            case 5:
                return "Friday";

            case 6:
                return "Saturday";

            case 7:
                return "Sunday";

            default:
                return "You have entered an invalid number. You must enter a number between 1 and 7.";
        }
    }
}
