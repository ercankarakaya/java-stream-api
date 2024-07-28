package com.ercan.Stream.StreamCreation;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class StreamOfCollection {
    public static void main(String[] args) {

        Collection<String> list = Arrays.asList("apple","banana","cherry");
        Stream<String> stream = list.stream();

        stream.forEach(System.out::println);

    }
}
