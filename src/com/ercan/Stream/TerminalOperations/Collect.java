package com.ercan.Stream.TerminalOperations;

import java.util.*;
import java.util.stream.Collectors;

public class Collect {
    public static void main(String[] args) {

        // Collect gathers the elements in the stream into a specified collection.
        // The collect() terminal operation is used to convert a stream into a collection.

        /* Collectors.toList() */
        List<String> stringList = Arrays.asList("a", "b", "c");
        List<String> collectedList = stringList.stream().collect(Collectors.toList());
        System.out.println(collectedList); // [a, b, c]

        List<String> words = Arrays.asList("apple", "banana", "cherry", "apple", "date");
        List<String> distinctWords = words.stream().distinct().collect(Collectors.toList());
        System.out.println(distinctWords); // [apple, banana, cherry, date]


        /* Collectors.toSet() */
        Set<String> wordSet = words.stream().collect(Collectors.toSet());
        System.out.println(wordSet);


        /* Collectors.toMap() */
        Map<String, Integer> wordLengthMap = words.stream()
                .distinct()
                .collect(Collectors.toMap(word -> word, word -> word.length()));

        System.out.println(wordLengthMap);  // {banana=6, date=4, apple=5, cherry=6}


        /* Collectors.joining() */
        List<String> wordList = Arrays.asList("apple", "banana", "cherry");
        String joinedWords = wordList.stream().collect(Collectors.joining(", "));
        System.out.println(joinedWords);  // apple, banana, cherry

        String delimitedWords = wordList.stream().collect(Collectors.joining(", ", "[", "]"));
        System.out.println(delimitedWords);  // [apple, banana, cherry]


        /*  Collectors.groupingBy() */
        List<String> wordList1 = Arrays.asList("apple", "banana", "cherry", "apricot", "blueberry");
        Map<Character, List<String>> wordsGroupedByFirstLetter = wordList1.stream()
                .collect(Collectors.groupingBy(word -> word.charAt(0)));

        System.out.println(wordsGroupedByFirstLetter);  // {a=[apple, apricot], b=[banana, blueberry], c=[cherry]}


        /* Collectors.partitioningBy() */
        Map<Boolean, List<String>> wordsPartitionedByLength = wordList1.stream()
                .collect(Collectors.partitioningBy(word -> word.length() > 6));

        System.out.println(wordsPartitionedByLength);  // {false=[apple, banana, cherry], true=[apricot, blueberry]}


        /* Collectors.averagingInt(), Collectors.summingInt(), Collectors.summarizingInt() */
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        double average = numbers.stream().collect(Collectors.averagingInt(num -> num));
        System.out.println(average); // 3.0

        int sum = numbers.stream().collect(Collectors.summingInt(num -> num));
        System.out.println(sum); // 15

        IntSummaryStatistics summaryStatistics = numbers.stream().collect(Collectors.summarizingInt(num -> num));
        System.out.println(summaryStatistics); // IntSummaryStatistics{count=5, sum=15, min=1, average=3,000000, max=5}


        // Finding the largest number
        Integer maxNumber = Arrays.asList(5,3,9,2,10,7).stream()
                .collect(Collectors.maxBy(Comparator.naturalOrder()))
                .orElse(null);

        System.out.println(maxNumber);

    }
}
