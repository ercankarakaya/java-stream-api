package com.ercan.Stream.StreamCreation;

import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class StreamOfPrimitives {
    public static void main(String[] args) {

        // Using the new interfaces alleviates unnecessary auto-boxing, which allows for increased productivity

        IntStream intStream = IntStream.range(1, 4);
        intStream.forEach(System.out::println); // 1 2 3

        IntStream randomInts = (new Random()).ints(10, 0, 100);
        randomInts.forEach(System.out::println);

        int[] numbers = {1, 2, 3, 4, 5};
        IntStream.of(numbers).map(n -> n * n).forEach(System.out::println);

        LongStream longStream = LongStream.rangeClosed(1, 4);
        longStream.forEach(System.out::println); // 1 2 3 4

        LongStream randomLongs = (new Random()).longs(10,0,100);
        randomLongs.forEach(System.out::println);

        DoubleStream doubleStream = (new Random()).doubles(3);
        doubleStream.forEach(System.out::println);

    }
}
