package com.ercan.Stream.IntermediateOperations;

import com.ercan.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Filter {
    public static void main(String[] args) {

        /* EXAMPLE 1 */
        List<String> list = Arrays.asList("apple", "google", "microsoft");
        List<String> filteredList = list.stream()
                .filter(l -> l.startsWith("a"))
                .collect(Collectors.toList());  // ["apple"]


        /* EXAMPLE 2 */
        List<User> userList = Arrays.asList(
                new User("Alice", 12),
                new User("Charlie", 25),
                new User("Bob", 33),
                new User("David", 41));

        List<Integer> agesUnder30 = userList.stream()
                .filter(u -> u.getAge() < 30)
                .map(User::getAge)
                .collect(Collectors.toList());

        agesUnder30.forEach(System.out::println);  // [12 25]


        /* EXAMPLE 3 */
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Edward");

        List<String> filteredNames = names.stream()
                .filter(name -> name.length() > 4 && name.toLowerCase().contains("a"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        filteredNames.forEach(System.out::println);


        /* EXAMPLE 4 */
        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("Alice", "Bob"),
                Arrays.asList("Charlie", "David", "Eve"),
                Arrays.asList("Frank", "Grace")
        );

        List<String> filteredNameList = nestedList.stream()
                .flatMap(List::stream)
                .filter(name -> name.toLowerCase().contains("a"))
                .collect(Collectors.toList());

        filteredNameList.forEach(System.out::println);  // [Alice, Charlie, David, Grace]


        /* EXAMPLE 5 */
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> filteredNumbers = numbers.stream()
                .filter(n -> n % 2 == 0 & n > 4)
                .collect(Collectors.toList());

        filteredNumbers.forEach(System.out::println);  // [6, 8, 10]

        OptionalDouble average = filteredNumbers.stream()
                .mapToInt(Integer::intValue)
                .average();

        average.ifPresent(avg -> System.out.println("Average: " + avg));  // Average: 8.0

    }
}
