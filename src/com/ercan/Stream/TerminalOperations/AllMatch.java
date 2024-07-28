package com.ercan.Stream.TerminalOperations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class AllMatch {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("apple", "banana", "cherry");
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10);
        List<String> emptyList = Collections.emptyList();

        boolean allMatch = emptyList.stream().allMatch(word -> word.length() > 3);
        System.out.println(allMatch); // true (For an empty stream, allMatch always returns true)

        boolean allLongerThanThree = words.stream().allMatch(word -> word.length() > 3);
        System.out.println(allLongerThanThree); // true

        boolean allEven = numbers.stream().allMatch(n -> n % 2 == 0);
        System.out.println(allEven); // true

        boolean allNegative = Arrays.asList(1, -2, 3, -4, 5).stream().allMatch(n -> n < 0);
        System.out.println(allNegative);  // false

        boolean allPositive = IntStream.of(1, 2, 3, 4, 5).allMatch(n -> n > 0);
        System.out.println(allPositive);

        boolean allLongWords = words.stream()
                .filter(word -> word.length() > 5)
                .map(String::toUpperCase)
                .allMatch(word -> word.length() > 5);
        System.out.println(allLongWords); // true

    }
}
