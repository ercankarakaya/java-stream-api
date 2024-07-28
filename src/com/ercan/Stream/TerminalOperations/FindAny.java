package com.ercan.Stream.TerminalOperations;

import java.util.*;
import java.util.stream.IntStream;

public class FindAny {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");

        Optional<String> anyWord = words.stream().findAny();
        anyWord.ifPresent(System.out::println);  // a random element (example: apple)

        Optional<String> filteredAnyWord = words.stream().filter(word -> word.length() > 5).findAny();
        filteredAnyWord.ifPresent(System.out::println);

        OptionalInt anyNumber = IntStream.range(1, 10).findAny();
        anyNumber.ifPresent(System.out::println);

        List<String> emptyList = Collections.emptyList();
        String str = emptyList.stream().findAny().orElse("No elements found");
        System.out.println(str);

    }
}
