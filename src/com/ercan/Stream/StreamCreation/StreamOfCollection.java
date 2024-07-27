package com.ercan.Stream.StreamCreation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamOfCollection {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("apple","banana","cherry");
        Stream<String> stream = list.stream();

        stream.forEach(System.out::println);

    }
}
