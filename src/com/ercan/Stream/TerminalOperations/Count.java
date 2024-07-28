package com.ercan.Stream.TerminalOperations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Count {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("apple", "banana", "cherry", "apple");

        long count1 = words.stream().count();
        System.out.println(count1); // 4

        long count2 = words.stream().distinct().count();
        System.out.println(count2);  // 3

        long count3 = words.stream().filter(word -> word.length() > 5).count();
        System.out.println(count3); // 2

        long count4 = IntStream.range(1, 10).count();
        System.out.println(count4);  // 9

        long count5 = Stream.empty().count();
        System.out.println(count5);  // 0

        long count6 = LongStream.rangeClosed(1,1_000_000).count();
        System.out.println(count6);  // 1000000


    }
}
