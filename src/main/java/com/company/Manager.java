package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Manager {
    public static void processData(String inputPath) {

        try {
            Stream<String> stream = Files.lines(Paths.get(inputPath));

        final Integer[] counter = {0};
        final String[] temp = {""};

            stream
                .skip(1)
                .forEach(s -> {
                    if (!( s.split(" ")[0].equals(temp[0])))
                    {
                        counter[0]++;
                        temp[0] = s.split(" ")[1];
                    }
                });

            System.out.println("counter : "+ counter[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
