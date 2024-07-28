package com.ercan.Stream.IntermediateOperations;

import com.ercan.model.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Distinct {
    public static void main(String[] args) {

        /* EXAMPLE 1 */
        List<String> distinctList = Arrays.asList("apple", "banana", "apple", "cherry")
                .stream()
                .distinct()
                .collect(Collectors.toList());  // ["apple", "banana", "cherry"]


        /* EXAMPLE 2 */
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 3, 2, 1);
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());  // [1, 2, 3, 4, 5]


        /* EXAMPLE 3 */
        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 20),
                new Person("Alice", 30),
                new Person("Charlie", 25),
                new Person("Bob", 20)
        );

        List<Person> distinctPeople = people.stream()
                .distinct()
                .collect(Collectors.toList()); // [Alice (30), Bob (20), Charlie (25)]

        List<Integer> distinctAges = people.stream()
                .map(Person::getAge)
                .distinct()
                .collect(Collectors.toList());  // [30, 20, 25]


        /* EXAMPLE 4 */
        try (Stream<String> stream = Files.lines(Paths.get("files/example.txt"))) {
            List<String> distinctLines = stream
                    .distinct()
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }


        /* EXAMPLE 5 */
        try (Stream<String> stream = Files.lines(Paths.get("files/example.txt"))) {
            List<String> distinctLines = stream
                    .flatMap(line -> Stream.of(line.split("\\s+")))
                    .distinct()
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }


        /* EXAMPLE 6 */
        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("Alice", "Bob"),
                Arrays.asList("Charlie", "David", "Bob"),
                Arrays.asList("Frank", "Grace", "Alice")
        );

        List<String> distinctElements = nestedList.stream()
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());  // [Alice, Bob, Charlie, David, Frank, Grace]


    }
}
