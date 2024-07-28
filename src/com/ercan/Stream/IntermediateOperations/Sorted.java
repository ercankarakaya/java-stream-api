package com.ercan.Stream.IntermediateOperations;

import com.ercan.model.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sorted {
    public static void main(String[] args) {

        /* EXAMPLE 1 */
        List<String> names = Arrays.asList("Bob", "Alice", "Edward", "David", "Charlie");
        List<String> sortedNames = names.stream()
                .sorted()
                .collect(Collectors.toList());  // [Alice, Bob, Charlie, David, Edward]


        /* EXAMPLE 2 */
        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 9, 4);
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());  // [1, 3, 4, 5, 8, 9]


        /* EXAMPLE 3 */
        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 20),
                new Person("Charlie", 25)
        );

        List<Person> sortedPeopleByAge = people.stream()
                .sorted()
                .collect(Collectors.toList());  // [Bob (20), Charlie (25), Alice (30)]

        List<Person> sortedPeopleByName = people.stream()
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList());  // [Alice (30), Bob (20), Charlie (25)]


        /* EXAMPLE 4 */
        List<Person> personList = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 20),
                new Person("Rick", 25),
                new Person("Charlie", 30),
                new Person("David", 25)
        );

        List<Person> sortedPeopleByAgeAndName = personList.stream()
                .sorted(Comparator.comparingInt(Person::getAge).thenComparing(Person::getName))
                .collect(Collectors.toList());  // [Bob (20), David (25), Rick (25), Alice (30), Charlie (30)]


        /* EXAMPLE 5 */
        List<Integer> reverseSortedNumbers = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());   // [9, 8, 5, 4, 3, 1]


        /* EXAMPLE 6 */
        try (Stream<String> stream = Files.lines(Paths.get("files/example.txt"))) {
            List<String> sortedLines = stream.sorted()
                    .collect(Collectors.toList());

            System.out.println(sortedLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
