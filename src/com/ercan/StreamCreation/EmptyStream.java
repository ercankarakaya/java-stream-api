package com.ercan.StreamCreation;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class EmptyStream {
    public static void main(String[] args) {

        /* Creating an Empty Stream with Stream.empty() */
        Stream<String> emptyStream = Stream.empty();
        emptyStream.forEach(System.out::println); // Does not print anything.

        /* Creating Stream with an Empty Array */
        String[] emptyArray = new String[0];
        Stream<String> emptyStreamArray = Arrays.stream(emptyArray);
        emptyStreamArray.forEach(System.out::println); // Does not print anything.

        /* Returning empty or full stream depending on condition */
        List<String> list = Arrays.asList("a", "b"); // null;
        Stream<String> streamList = streamOf(list); // list.stream(); May generate a nullpointer exception.
        streamList.forEach(System.out::println); // If the list is empty, it prints nothing.

        /* Using with Optional */
        Optional<String> optional = Optional.ofNullable(null);
        Stream<String> optStream = optional.map(Stream::of).orElseGet(Stream::empty); // Returning an empty or full stream from Optional.
        optStream.forEach(System.out::println); // If the Optional is empty, it prints nothing.


        /* For Testing and Debugging Purposes */
        Stream<String> testStream = getTestStream(true);
        testStream.forEach(System.out::println);
    }

    public static Stream<String> streamOf(List<String> list) {
        return list == null || list.isEmpty() ? Stream.empty() : list.stream();
    }
    public static Stream<String> getTestStream(boolean condition){
        return condition ? Stream.of("Test1","Test2") : Stream.empty();
    }
}
