package com.ercan.StreamCreation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamBuilderMethod {
    public static void main(String[] args) {

        /* Example 1 */
        Stream<String> stream = Stream.<String>builder().add("apple").add("banana").add("cherry").build();
        stream.forEach(System.out::println);

        /* Example 2 */
        List<String> strList = new ArrayList<>();
        strList.add("a");
        strList.add("b");

        Stream.Builder<String> builder = Stream.builder();
        for (String s : strList){
            builder.add(s);
        }

        Stream<String> strStream = builder.build();
        strStream.forEach(System.out::println);

    }
}
