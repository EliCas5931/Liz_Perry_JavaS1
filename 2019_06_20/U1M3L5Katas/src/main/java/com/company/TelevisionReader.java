package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TelevisionReader {
    public static void main(String[] args) {

        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Television> tvList;

            tvList = mapper.readValue(new File("src/main/resources/televisions.json"), new TypeReference<List<Television>>() {
            });

            tvList
                    .stream()
                    .forEach(tv -> {
                        System.out.println("================");
                        System.out.println("Screen Size: " + tv.getScreenSize());
                    });

            System.out.println("================");
            System.out.println("================");

            Map<String, List<Television>> groupedTvs =
                    tvList
                            .stream()
                            .collect(Collectors.groupingBy(t -> t.getBrand()));
            Set<String> keys = groupedTvs.keySet();
            for(String key : keys) {
                System.out.println(key);
            }

            System.out.println("================");
            System.out.println("================");

            double avgScreenSize =
                    tvList
                            .stream()
                            .mapToInt(t -> t.getScreenSize())
                            .average()
                            .getAsDouble();
            System.out.println("Average Screen Size is: " + avgScreenSize);

            System.out.println("================");
            System.out.println("================");

            int maxScreenSize =
                    tvList
                            .stream()
                            .mapToInt(tv -> tv.getScreenSize())
                            .max()
                            .getAsInt();
            System.out.println("Max Screen Size: " + maxScreenSize);


        } catch (IOException e) {

            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());

        }
    }
}