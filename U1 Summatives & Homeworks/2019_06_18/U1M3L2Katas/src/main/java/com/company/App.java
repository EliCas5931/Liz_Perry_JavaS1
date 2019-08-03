package com.company;

//ummm google why it took your imports away when you option enter
import java.util.*;

public class App {

    // print the keys
    public static void printKeys (Map<String, String> mapPass) {

        Set<String> getKeys = mapPass.keySet();

        Iterator<String> getIterator = getKeys.iterator();

        for (Map.Entry<String, String> myEntry: mapPass.entrySet()) {

            System.out.println(myEntry.getKey());
        }
    }

    // print the values
    public static void printValues(Map<String, String> mapPass) {

        Collection<String> getValues = mapPass.values();

        Iterator<String> getIterator = getValues.iterator();

        while (getIterator.hasNext()) {

            System.out.println(getIterator.next());
        }
    }

    // print keys and values
    public static void printKeysAndValues (Map<String, String> mapPass) {

        for (Map.Entry<String, String> myEntry: mapPass.entrySet()) {

            System.out.println(myEntry.getKey() + ": " + myEntry.getValue());

        }
    }

    public Map mapFun (Map<String, Integer> mapPass) {

        mapPass.put("Ford Explorer", 2012);

        mapPass.put("Smart Fortwo", 2013);

        mapPass.remove("Jeep Wrangler");

        return mapPass;

    }

    public Map listCars (List<Car> newCars) {

        Map<String, List<Car>> lastList = new HashMap<>();

        List<Car> toyotaList = new ArrayList<>();

        List<Car> fordList = new ArrayList<>();

        List<Car> hondaList = new ArrayList<>();

        for (Car myCar: newCars) {

            if (myCar.getMake() == "Toyota") {

                toyotaList.add(myCar);

            } else if (myCar.getMake() == "Ford") {

                fordList.add(myCar);

            } else if (myCar.getMake() == "Honda") {

                hondaList.add(myCar);

            }

        }

        lastList.put("Toyota", toyotaList);

        lastList.put("Ford", fordList);

        lastList.put("Honda", hondaList);

        return lastList;
    }





}
