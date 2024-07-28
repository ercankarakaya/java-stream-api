package com.ercan.Stream.IntermediateOperations;

import com.ercan.model.Deparment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMap {
    public static void main(String[] args) {

        /* EXAMPLE 1 */
        List<List<String>> listOflists = Arrays.asList(
                Arrays.asList("Alice", "Bob"),
                Arrays.asList("Charlie", "David", "Eve"),
                Arrays.asList("Frank", "Grace")
        );  // Nested List

        List<String> flatList = listOflists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());  // [Alice, Bob, Charlie, David, Eve, Frank, Grace]


        /* EXAMPLE 2 */
        List<String> sentences = Arrays.asList("Hello World", "Java Streams", "FlatMap Example");
        List<String> words = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .collect(Collectors.toList());  // [Hello, World, Java, Streams, FlatMap, Example]


        /* EXAMPLE 3 */
        String[][] nestedArray = {{"Alice", "Bob"}, {"Charlie", "David", "Rick"}, {"Frank", "Grace"}};
        String[] flattenedArray = Arrays.stream(nestedArray)
                .flatMap(Arrays::stream)
                .toArray(String[]::new);

        System.out.println(Arrays.toString(flattenedArray)); // [Alice, Bob, Charlie, David, Eve, Frank, Grace]


        /* EXAMPLE 4 */
        List<Deparment> deparments = Arrays.asList(
                new Deparment("HR", Arrays.asList("Alice", "Bob")),
                new Deparment("IT", Arrays.asList("Charlie", "David", "Rick")),
                new Deparment("Finance", Arrays.asList("Frank", "Grace"))
        );

        List<String> employees = deparments.stream()
                .flatMap(d -> d.getEmployees().stream())
                .collect(Collectors.toList());  // [Alice, Bob, Charlie, David, Eve, Frank, Grace]


        /* EXAMPLE 5 */
        String fileName = "files/example.txt";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            List<String> wordList = stream
                    .flatMap(line -> Arrays.stream(line.split("\\s+"))) // Splits lines into words.
                    .collect(Collectors.toList());
            wordList.forEach(System.out::println);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        /* EXAMPLE 6 */
        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("Alice", "Bob"),
                Arrays.asList("Charlie", "David", "Eve"),
                Arrays.asList("Frank", "Grace")
        );

        List<String> filteredFlattenedList = nestedList.stream()
                .flatMap(List::stream)
                .filter(name -> name.startsWith("A") || name.startsWith("E"))
                .collect(Collectors.toList());

        filteredFlattenedList.forEach(System.out::println); // [Alice, Eve]
    }
}
