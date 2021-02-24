package com.sample.stream;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectorTest {
    public static void main(String[] args) {

        List<Person> nameList = Arrays.asList(new Person("John", 21), new Person("Smith", 16));

        Map namesMap = nameList.stream().collect(Collectors.toMap(p -> p.name, p-> p.age));

        System.out.println(namesMap);

        Collector<Person, StringJoiner, String> personNameCollector = Collector.of(
                () -> new StringJoiner(" |"), // supplier
                (j,p) -> j.add(p.name.toUpperCase()), // accumulator
                (j1, j2) -> j1.merge(j2) , // combiner
                StringJoiner::toString); // finisher

        String names = nameList.stream().collect(personNameCollector);

        System.out.println(names);

    }

    private static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name;

        }
    }


}
