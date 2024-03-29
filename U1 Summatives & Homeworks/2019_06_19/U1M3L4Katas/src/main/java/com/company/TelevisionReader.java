package com.company;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;

public class TelevisionReader {

    public static void main(String[] args) {

        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Television> tvList;

            tvList = mapper.readValue(new File("televisions.json"), new TypeReference<List<Television>>() {
            });

            for (Television TVS : tvList) {
                System.out.println("==============");
                System.out.println(TVS.getBrand());
                System.out.println(TVS.getModel());
                System.out.println(TVS.getPrice());
                System.out.println(TVS.getScreenSize());
            }

        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }
    }
}
