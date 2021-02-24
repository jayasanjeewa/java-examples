package com.sample.intrfc;

public class InterfaceTester {
    public static void main(String[] args) {
        var privateClass = new PrivateClassImpl();

        privateClass.m1();
        privateClass.m3();
    }
}
