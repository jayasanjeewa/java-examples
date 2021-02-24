package com.sample.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FlatMapExample {
    public static void main(String[] args) {

        List<Foo> foos = new ArrayList<>();

        IntStream.range(1,4)
                .forEach(i -> foos.add(new Foo("Foo" + i)));

        foos.forEach(f ->
                IntStream.range(1,4).forEach(i -> f.bars.add(new Bar("Bar"+ i + "<- "+ f.name))));

        foos.stream().flatMap(f -> f.bars.stream())
                .forEach(b -> System.out.println(b.name));

        IntStream.range(1, 4)
                .mapToObj(i -> new Foo("Foo" + i))
                .peek(f -> IntStream.range(1, 4)
                        .mapToObj(i -> new Bar("Bar" + i + " <- " + f.name))
                        .forEach(f.bars::add))
                .flatMap(f -> f.bars.stream())
                .forEach(b -> System.out.println(b.name));

    }

    private static class Foo {
        String name;
        List<Bar> bars = new ArrayList<>();

        Foo(String name) {
            this.name = name;
        }
    }

    private static class Bar {
        String name;

        Bar(String name) {
            this.name = name;
        }
    }
}
