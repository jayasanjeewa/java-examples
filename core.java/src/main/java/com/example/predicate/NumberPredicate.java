package com.example.predicate;

import java.util.function.Predicate;

public class NumberPredicate implements Predicate<Integer> {
    @Override
    public boolean test(Integer number) {
        return number > 3;

    }
}
