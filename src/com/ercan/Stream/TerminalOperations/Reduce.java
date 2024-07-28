package com.ercan.Stream.TerminalOperations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reduce {
    public static void main(String[] args) {

        /* EXAMPLE 1 */
        List<String> stringList = Arrays.asList("a", "b", "c");
        String concatenatedString = stringList.stream().reduce("", (a, b) -> a + b);
        System.out.println(concatenatedString);  // abc


        /* EXAMPLE 2 */
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int sum = numbers.stream().reduce(0, Integer::sum); // veya `Integer::sum` yerine (a,b) -> a+b
        System.out.println(sum);  // 15

        int multiply = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println(multiply); // 120

        int min = numbers.stream().reduce(Integer.MAX_VALUE, Integer::min); // veya (a,b) -> a < b ? a : b
        System.out.println(min); // 1

        int max = numbers.stream().reduce(Integer.MIN_VALUE, Integer::max); // veya (a,b) -> a > b ? a : b
        System.out.println(max); // 5


        /* EXAMPLE 3 */
        Optional<Integer> optSum = numbers.stream().reduce((a, b) -> a + b);
        optSum.ifPresent(System.out::println);  // 15

        List<Integer> emptyList = Arrays.asList();
        Optional<Integer> emptySum = emptyList.stream().reduce((a, b) -> a + b);
        System.out.println(emptySum.isPresent());  // false

        Optional<String> concatenatedStringOpt = stringList.stream().reduce((s1, s2) -> s1 + ", " + s2);
        System.out.println(concatenatedStringOpt); // Optional[a, b, c]

    }
}
