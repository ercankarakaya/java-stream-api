package com.ercan.Stream.ParallelProcessing;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelPerformance {
    public static void main(String[] args) {

        List<Integer> largeList = IntStream.range(0, 100000000).boxed().collect(Collectors.toList());

        // Sequential stream time
        long startTime = System.currentTimeMillis();

        largeList.stream()
                .mapToInt(Integer::intValue)
                .sum();

        long endTime = System.currentTimeMillis();
        System.out.println("Sequential stream time : " + (endTime - startTime) + " ms");

        // Parallel stream time
        startTime = System.currentTimeMillis();

        largeList.parallelStream()
                .mapToInt(Integer::intValue)
                .sum();

        endTime = System.currentTimeMillis();
        System.out.println("Parallel stream time : " + (endTime - startTime) + " ms");


    }
}
