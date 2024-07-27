package com.ercan.Stream.StreamCreation;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOfFile {
    public static void main(String[] args) throws IOException {

        /* Reading Lines from a File */
        try (
                Stream<String> streamOfStrings = Files.lines(Paths.get("files/example.txt"));
                Stream<String> streamWithCharset = Files.lines(Paths.get("files/example.txt"), StandardCharsets.UTF_8);
        ) {

            streamOfStrings.forEach(System.out::println);
            //streamWithCharset.forEach(System.out::println); // using with charset
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        /* Filtering and Summing Rows from a File */
        try (Stream<String> stream = Files.lines(Paths.get("files/example.txt"))) {
            List<String> filteredLines = stream.filter(line -> line.contains("Java")).toList();
            filteredLines.forEach(System.out::println);
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        /* Finding the Frequency of Words in a File */
        try (Stream<String> stream = Files.lines(Paths.get("files/example.txt"))) {
            Map<String, Long> wordCounts = stream.flatMap(line -> Stream.of(line.split("\\W+")))
                    .filter(word -> !word.isEmpty())
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            wordCounts.forEach((word, count) -> System.out.println(word + " : " + count));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        /* Reading and Processing Lines from a File and Writing to a New File */
        String inputFileName = "files/example.txt";
        String outputFileName = "files/output.txt";

        try (Stream<String> stream = Files.lines(Paths.get(inputFileName))) {
            List<String> processedLines = stream.map(String::toUpperCase).toList();
            Files.write(Paths.get(outputFileName), processedLines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        /* Reverse Lines in a File */
        String reversedOutputFileName = "files/reversed_output.txt";
        try (Stream<String> stream = Files.lines(Paths.get(inputFileName))) {
            List<String> lines = stream.collect(Collectors.toList()); // new ArrayList<>(stream.toList());
            Collections.reverse(lines);
            Files.write(Paths.get(reversedOutputFileName), lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
