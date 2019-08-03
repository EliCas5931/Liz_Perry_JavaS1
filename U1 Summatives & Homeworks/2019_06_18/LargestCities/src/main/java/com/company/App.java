package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class App {

    public static void main(String[] args) {

        City newYork = new City("New York", 8654321);

        City losAngeles = new City("Los Angeles", 4563218);

        City chicago = new City("Chicago", 2716520);

        City denver = new City("Denver", 704621);

        City desMoines = new City("Des Moines", 217521);

        City atlanta = new City("Atlanta", 486213);

        Map<String, City> states = new HashMap<>();

        states.put("New York", newYork);

        states.put("Los Angeles", losAngeles);

        states.put("Chicago", chicago);

        states.put("Denver", denver);

        states.put("Des Moines", desMoines);

        states.put("Atlanta", atlanta);

        Set<Map.Entry<String, City>> myEntries = states.entrySet();

        for(Map.Entry<String, City> entry: myEntries) {

            System.out.println("City: " + entry.getKey() + " --- Population: " + entry.getValue().getPopulation());

        }

        System.out.println("\n");

        Scanner myScanner = new Scanner(System.in);

        System.out.print("Enter a minimum population value: ");

        int popValue = myScanner.nextInt();

        for(Map.Entry<String, City> entry: myEntries) {

            if(popValue < entry.getValue().getPopulation()){

                System.out.println("City: " + entry.getKey() + " --- Population: " + entry.getValue().getPopulation());

            }

        }

    }

}
