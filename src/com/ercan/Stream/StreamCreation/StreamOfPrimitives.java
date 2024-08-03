package com.ercan.Stream.StreamCreation;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.*;

public class StreamOfPrimitives {
    public static void main(String[] args) {

        // Using the new interfaces alleviates unnecessary auto-boxing, which allows for increased productivity

        IntStream intStream = IntStream.range(1, 4);
        intStream.forEach(System.out::println); // 1 2 3

        IntStream randomInts = (new Random()).ints(10, 0, 100);
        randomInts.forEach(System.out::println);

        int[] numbers = {1, 2, 3, 4, 5};
        IntStream.of(numbers).map(n -> n * n).forEach(System.out::println);

        Stream<Integer> boxedStream = IntStream.of(1, 2, 3, 4, 5).boxed(); // boxed ; Used to convert to Wrapper classes (Integer, Long, Double).
        System.out.println(boxedStream.toList()); // [1, 2, 3, 4, 5]

        OptionalInt maxNumber = Arrays.asList(5, 3, 9, 2, 10, 7).stream().
                mapToInt(Integer::intValue)  // convert to IntStream
                .max();
        System.out.println(maxNumber); // 10

        LongStream longStream = LongStream.rangeClosed(1, 4);
        longStream.forEach(System.out::println); // 1 2 3 4

        LongStream randomLongs = (new Random()).longs(10, 0, 100);
        randomLongs.forEach(System.out::println);

        DoubleStream doubleStream = (new Random()).doubles(3);
        doubleStream.forEach(System.out::println);

    }
}
