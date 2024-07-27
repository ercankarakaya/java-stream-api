package com.ercan.Stream.StreamCreation;

import com.ercan.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamGenerateMethod {
    public static void main(String[] args) {

        /* Writes element 3 times */
        Stream<String> streamGenerated = Stream.generate(() -> "element").limit(3);
        //streamGenerated.forEach(System.out::println);

        /* Writes 5 different double type numbers */
        Stream<Double> randomDoubleNumbers = Stream.generate(Math::random).limit(5);
        //randomDoubleNumbers.forEach(System.out::println);

        /* Writes 5 different int type numbers */
        Stream<Integer> randomIntNumbers = Stream.generate(new Random()::nextInt).limit(5);
        //randomIntNumbers.forEach(System.out::println);

        /* Generating Random User Objects */
        final String[] NAMES = {"Alice", "Bob", "Charlie", "David"};
        final Random random = new Random();
        Stream<User> userStream = Stream.generate(() -> new User(
                NAMES[random.nextInt(NAMES.length)],
                random.nextInt(50) + 20  // Ages 20-69
        )).limit(5); // We set a limit to get the first 5 users.

        userStream.forEach(System.out::println);


        /* Generating Datetime */
        Stream<LocalDateTime> dateTimeStream = Stream.generate(new Supplier<LocalDateTime>() {
            private LocalDateTime current = LocalDateTime.now();

            @Override
            public LocalDateTime get() {
                current = current.plusHours(1); // Hourly increments.
                return current;
            }
        });

        dateTimeStream.limit(5).forEach(System.out::println);


    }
}
