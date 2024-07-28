package com.ercan.Stream.TerminalOperations;

import java.util.*;
import java.util.stream.IntStream;

public class FindFirst {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");

        Optional<String> firstWord = words.stream().findFirst();
        firstWord.ifPresent(System.out::println);  // apple

        Optional<String> filteredFirstWord = words.stream().filter(word -> word.length() > 5).findFirst();
        filteredFirstWord.ifPresent(System.out::println); // banana

        OptionalInt firstNumber = IntStream.range(1, 10).findFirst();
        firstNumber.ifPresent(System.out::println); // 1

        List<String> emptyList = Collections.emptyList();
        String str = emptyList.stream().findFirst().orElse("No elements found");
        System.out.println(str);

    }
}
