package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Manager {
    public static void processData(String inputPath) {

        final Integer[] graphs_status = new Integer[2];
        graphs_status[0] = 0;   //CONTAINS NUMBER OF GRAPHS IDENTIFIED;
        graphs_status[1] = 0;   //CONTAIN MAXIMUM NUMBER OF OCCURED VERTICES;

        try {
            Stream<String> stream = Files.lines(Paths.get(inputPath));

            stream
                .skip(1)
                .forEach(s -> {
                    //declare current variables
                    Integer current_1st_value = Integer.parseInt(s.split(" ")[0]);
                    Integer current_2nd_value = Integer.parseInt(s.split(" ")[1]);
                    //Process
                    // IF (1ST VERTEX > MAX) THEN NEW GRAPH FOUNDED
                    if(current_1st_value > graphs_status[1])
                    {
                        graphs_status[0] += 1; // GRAPH COUNT ++

                        //graphs_status[1] = current_2nd_value;
                    }
                    // NEW MAX IS EACH TIME TAKEN FROM 2ND VERTEX (2ND IS ALWAYS GREATER THEN 1ST ) ASSUMPTION
                    graphs_status[1] = current_2nd_value;
                });

        System.out.println(graphs_status[0]);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
