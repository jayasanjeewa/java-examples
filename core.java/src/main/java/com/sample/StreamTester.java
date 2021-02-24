package com.sample;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTester {
    public static void main(String[] args) {
        IntStream.of(3,7,12, 21).filter(i -> i > 3).map(i -> i + 100 ).max().ifPresent(System.out::println);

        Stream.of("12", "3", "7","21").sorted((s1, s2) -> {
            System.out.printf(" sorting (%s , %s)", s1,s2);
            return s1.compareTo(s2);
        })
                .filter(i -> {
            System.out.println("filter: " + i);
            return true;
        }).forEach(s -> System.out.println("printing: " + s));
    }
}
