package com.ercan.Stream.TerminalOperations;

import java.util.Arrays;
import java.util.List;

public class ToArray {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("apple", "banana", "cherry");
        String[] wordArray = words.stream().toArray(String[]::new);

        System.out.println(Arrays.toString(wordArray)); // [apple, banana, cherry]

    }
}
