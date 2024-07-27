package com.ercan.Stream.StreamCreation;

import java.time.LocalDateTime;
import java.util.stream.Stream;

public class StreamIterateMethod {
    public static void main(String[] args) {

        /* Infinite Stream */
        Stream<Integer> infiniteStream = Stream.iterate(0, n -> n + 1);
        //infiniteStream.limit(5).forEach(System.out::println);

        Stream<Integer> evenNumbers = Stream.iterate(0, n -> n + 2).limit(5);
        //evenNumbers.forEach(System.out::println); // 0 2 4 6 8

        /* Finite Stream */
        Stream<Integer> finiteStream = Stream.iterate(0, n -> n < 10, n -> n + 1);
        //finiteStream.forEach(System.out::println);


        /* Fibonacci Example */
        Stream.iterate(new long[]{0, 1}, f -> new long[]{f[1], f[0] + f[1]})
                .limit(10)
                .forEach(f -> System.out.println(f[0]));

        /* Generating Datetime */
        Stream.iterate(LocalDateTime.now(), dateTime -> dateTime.plusHours(1))
                .limit(5)
                .forEach(System.out::println);

    }
}
