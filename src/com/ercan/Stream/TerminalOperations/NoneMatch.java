package com.ercan.Stream.TerminalOperations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NoneMatch {
    public static void main(String[] args) {

        List<String> emptyList = Collections.emptyList();
        List<Integer> numbers = Arrays.asList(1, 3, 5, 7, 9);
        List<String> words = Arrays.asList("apple", "banana", "cherry");


        boolean noneMatch = emptyList.stream().noneMatch(word -> word.length() > 3);
        System.out.println(noneMatch); // true

        boolean noneEven = numbers.stream().noneMatch(n -> n % 2 == 0);
        System.out.println(noneEven); // true

        boolean noneLongerThanSeven = words.stream().noneMatch(word -> word.length() > 7);
        System.out.println(noneLongerThanSeven); // true

        boolean noneNegative = Arrays.asList(1, 2, 3, 4, 5).stream().noneMatch(n -> n < 0);
        System.out.println(noneNegative); // true



    }
}
