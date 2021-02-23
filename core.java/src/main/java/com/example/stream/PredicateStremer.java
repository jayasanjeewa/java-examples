package com.example.stream;

import com.example.predicate.NumberPredicate;

import java.util.stream.Stream;

public class PredicateStremer {

    public static void main(String [] args) {
        //Stream.of(1,17,2,6).filter(new NumberPredicate()).forEach(s -> System.out.println(s));
        Stream.of(1,17,2,6).filter(n -> n > 6).forEach(s -> System.out.println(s));
    }
}
