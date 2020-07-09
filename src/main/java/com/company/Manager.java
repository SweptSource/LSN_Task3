package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Manager {
    public static void processData(String inputPath) {

        final int[] counter = new int[1];

        try {
            Stream<String> stream = Files.lines(Paths.get(inputPath));

            long uniqueGrphsCounter =
            stream
                .skip(1)
                    .map(s -> { return new MyTouple<Integer, Integer, Boolean>
                                (Integer.parseInt(s.split(" ")[0]), Integer.parseInt(s.split(" ")[1]), true );
                    })
                    .distinct()
                    .peek(mt-> {
                        if (mt.getMerginglocalGraphs())
                        counter[0]++;
                    })
                    .filter(t -> t.getUnique() == true)
                    .count();

        System.out.println(uniqueGrphsCounter - counter[0]);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
