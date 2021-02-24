package com.sample.intrfc;

@FunctionalInterface
public interface MyFunctional {
    public void func();

    public default void dfMethod() {
        System.out.println("I'm Default method");
        prvMethod();
    }

    private void prvMethod() {
        System.out.println("I'm Private method");
    }

    public static void stMethod1() {
        System.out.println("I'm Static  method 1");
    }

    public static void stMethod2() {
        System.out.println("I'm Static  method 2");
    }


}
