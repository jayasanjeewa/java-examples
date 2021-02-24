package com.sample.intrfc;

public interface PrivateInterface {
    public void m1();

    private void m2() {
        System.out.println("I'm private");
    }

    public default void m3() {
        System.out.println("I'm default: " );
        m2();
    }
}
