package com.sample.stream;

import java.util.Arrays;
import java.util.List;

public class ReduceStream {
    public static void main(String[] args) {
        List<ReduceStream.Person> persons = Arrays.asList(new ReduceStream.Person("John", 21), new ReduceStream.Person("Smith", 16), new ReduceStream.Person("Steve", 32));

        persons.stream().reduce((p1,p2) -> p1.age > p2.age ? p1 : p2)
                .ifPresent(System.out::println);



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
