package com.example.algo;

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        System.out.println("\n " + fib.fibLoop(5));
    }

    public int fibRec(int index) {

        if ( index == 1 || index == 2)
            return 1;

        return fibRec(index -2 ) + fibRec(index-1);

    }

    public int fibLoop(int index) {

      int n1 = 1;
      int n2 = 1;

      int fib = 0;

      for (int i = 3; i <= index; i++) {
          fib = n1 + n2;
            n2 = n1;
            n1 = fib;

          System.out.printf("\n i:=%s , fib=%s", i, fib );

      }

        return fib;

    }
}
