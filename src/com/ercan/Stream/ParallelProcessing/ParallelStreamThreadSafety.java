package com.ercan.Stream.ParallelProcessing;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamThreadSafety {

    private static int sum = 0;
    private static AtomicInteger atomicSum = new AtomicInteger(0);

    public static void main(String[] args) {

        /* EXAMPLE 1 : Using `forEachOrdered` */
        List<Integer> largeList = IntStream.range(0, 1000000).boxed().collect(Collectors.toList());
        largeList.parallelStream().forEach(number -> sum += number); // Not Thread-safe
        System.out.println("Sum (without ordered) : " + sum);  // It may not be the expected result.

        sum = 0;
        largeList.parallelStream().forEachOrdered(number -> sum += number); // Thread-safe
        System.out.println("Sum (with ordered) : " + sum);  // Expected result.


        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // Using forEachOrdered for ordered output
        // numbers.parallelStream().forEachOrdered(System.out::println); // Thread-safe


        /* EXAMPLE 2 : Using `synchronized` */
        sum = 0;
        Object lock = new Object();

        largeList.parallelStream()
                .forEach(number -> {
                    synchronized (lock) {
                        sum += number;
                    }
                });

        System.out.println("Sum (with synchronized) : " + sum);


        /* EXAMPLE 3 : Using `Atomic` */
        largeList.parallelStream().forEach(number -> atomicSum.addAndGet(number));
        System.out.println("Sum (atomic) : "+atomicSum.get());  // Expected result.

        /* EXAMPLE 4 : Using `Collector` */
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        Set<String> uniqueWords = words.parallelStream()
                .collect(Collectors.toCollection(ConcurrentSkipListSet::new));

        System.out.println(uniqueWords);


        /* EXAMPLE 5 : Using `Reduce` */

        int sum = largeList.parallelStream()
                .reduce(0, Integer::sum); // Thread-safe

        System.out.println("Sum (reduce): " + sum); // Expected result.

    }
}
