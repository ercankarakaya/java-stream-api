package com.ercan.Stream.TerminalOperations;

import com.ercan.model.User;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class AnyMatch {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("apple", "banana", "cherry");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<String> emotyList = Collections.emptyList();
        List<User> users = Arrays.asList(
                new User("Alice", 17),
                new User("Bob", 25),
                new User("Charlie", 16)
        );


        boolean anyMatch = emotyList.stream().anyMatch(word -> word.length() > 3);
        System.out.println(anyMatch); // false

        boolean anyStartsWithC = words.stream().anyMatch(word -> word.startsWith("c"));
        System.out.println(anyStartsWithC); // true

        boolean anyEven = numbers.stream().anyMatch(n -> n % 2 == 0); // Are there any even numbers?
        System.out.println(anyEven);  // true

        boolean anyLongerThanSix = words.stream().anyMatch(w -> w.length() > 6);
        System.out.println(anyLongerThanSix); // false

        boolean anyPositive = Arrays.asList(-1, -2, 3, -4, -5).stream().anyMatch(n -> n > 0);
        System.out.println(anyPositive); // true

        boolean anyPositiveWithPrimitiveStream = IntStream.of(-1, -2, -3, -4, 5).anyMatch(n -> n > 0);
        System.out.println(anyPositiveWithPrimitiveStream); // true

        boolean anyAdult = users.stream().anyMatch(user -> user.getAge() > 18);
        System.out.println(anyAdult); // true

    }
}
