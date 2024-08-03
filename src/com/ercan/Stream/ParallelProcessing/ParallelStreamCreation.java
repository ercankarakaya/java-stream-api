package com.ercan.Stream.ParallelProcessing;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamCreation {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // Creating a Parallel Stream
        numbers.parallelStream().forEach(System.out::println);


    }

}
