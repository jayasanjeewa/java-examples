package com.sample.intrfc;

public class FuncClass {
    public static void main(String[] args) {
        MyFunctional mf = () -> {
            System.out.println("Its me Functional");
        };

        mf.func();

        mf.dfMethod();

        MyFunctional.stMethod1();
        MyFunctional.stMethod2();


    }
}
