package com.sample.stream;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class ParallelStreamTester {
    public static void main(String[] args) {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        System.out.println(pool.getParallelism());

        Arrays.asList("a1", "a2", "b1", "c2", "c1").parallelStream().
                filter(s -> {
                    System.out.format("filter: %s [%s]\n",
                            s, Thread.currentThread().getName());
                    return true;
                })
                .map(s -> {
                    System.out.format("map: %s [%s]\n",
                            s, Thread.currentThread().getName());
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.format("forEach: %s [%s]\n",
                        s, Thread.currentThread().getName()));
    }
}
