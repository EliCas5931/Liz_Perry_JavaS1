package com.company;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.util.List;

public class JSONWriteAndRead {
    public static void main(String[] args) {

        List<Car> carList = new ArrayList<>();

        carList.add(new Car(2000, "Toyota", "Camry", "Blue"));
        carList.add(new Car(2001, "Honda", "Civic", "Silver"));
        carList.add(new Car(2009, "Jeep", "Wrangler", "Rust"));
        carList.add(new Car(2018, "Tesla", "Roadster", "Black"));
        carList.add(new Car(1964, "Ford", "Mustang", "Red"));

        PrintWriter writer = null;

        try{

            ObjectMapper mapper = new ObjectMapper();

            String jsonCarList = mapper.writeValueAsString(carList);
            System.out.println(jsonCarList);

            writer = new PrintWriter(new FileWriter("cars.json"));
            writer.println(jsonCarList);

            writer.flush();
            writer.close();

            List<Car> newCarList;

            newCarList = mapper.readValue(new File("cars.json"), new TypeReference<List<Car>>() {
            });

            for (Car car: newCarList) {
                System.out.println("=================================");
                System.out.println(car.getYear());
                System.out.println(car.getMake());
                System.out.println(car.getModel());
                System.out.println(car.getColor());
            }

        } catch( JsonProcessingException e) {
            System.out.println("ERROR: Trouble converting object to JSON string: " + e.getMessage());
            e.printStackTrace();
        } catch(IOException e) {
            System.out.println("ERROR: Could not write to file: " + e.getMessage());
        }finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }

    }
}
