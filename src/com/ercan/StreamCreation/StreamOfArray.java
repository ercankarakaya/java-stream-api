package com.ercan.StreamCreation;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamOfArray {
    public static void main(String[] args) {

        // Stream<String> streamOfArray = Stream.of("a", "b", "c","d");

        String[] array = {"a","b","c","d"};
        Stream<String> streamOfArrayFull = Arrays.stream(array); // a, b, c,d
        Stream<String> streamOfArrayPart = Arrays.stream(array,2,4); // c, d

    }
}
