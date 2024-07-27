package com.ercan.Stream.StreamCreation;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOfString {
    public static void main(String[] args) {

        IntStream streamOfChars = "abcd".chars();
        //streamOfChars.forEach(System.out::println); // [97 98 99 100]

        Stream<String> streamOfString = Pattern.compile(", ").splitAsStream("a,b,c,d");
        //streamOfString.forEach(System.out::println);  // [a,b,c,d]


        /* Separating and Processing Words */
        String sentence = "Stream API in Java is very powerful";
        List<Integer> wordLengths = Arrays.stream(sentence.split(" "))
                .map(String::length)
                .toList();

        wordLengths.forEach(System.out::println); // [6, 3, 2, 4, 2, 4, 9]


        /* Splitting and Filtering String into Characters */
        String str = "hello world";
        String result = str.chars()
                .filter(ch -> ch != ' ' && ch != 'o')
                .mapToObj(ch -> String.valueOf((char) ch))
                .collect(Collectors.joining());
        System.out.println(result);  // [hellwrld]


        /* Operations with String List */
        List<String> strings = Arrays.asList("date", "banana", "cherry", "apple");
        List<String> sortedUpperCaseStrings = strings.stream().sorted().map(String::toUpperCase).toList();
        sortedUpperCaseStrings.forEach(System.out::println); // [APPLE, BANANA, CHERRY, DATE]


        /* Filtering Strings Based on a Specific Pattern */
        List<String> strings1 = Arrays.asList("apple", "banana", "avocado", "cherry", "date");
        List<String> filteredStrings1 = strings1.stream().filter(s -> s.startsWith("a")).toList();
        filteredStrings1.forEach(System.out::println); // [apple, avocado]

        /* Finding Unique Words in a List of Strings */
        List<String> strings2 = Arrays.asList("apple", "banana", "apple", "cherry", "banana");
        Set<String> uniqueStrings2 = strings2.stream().collect(Collectors.toSet());
        uniqueStrings2.forEach(System.out::println); // [banana, apple, cherry]

        /* Converting a List of Strings to a Single String */
        List<String> strings3 = Arrays.asList("apple", "banana", "cherry", "date");
        String singleStr = strings3.stream().collect(Collectors.joining(" - "));
        System.out.println(singleStr); // "apple - banana - cherry - date"


    }
}
