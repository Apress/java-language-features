// RecursiveTest.java
package com.jdojo.lambda;

import java.util.function.IntFunction;

public class RecursiveTest {
    public static void main(String[] args) {
        IntFunction<Long> factorialCalc = RecursiveTest::factorial;

        int n = 5;
        long fact = factorialCalc.apply(n);
        System.out.println("Factorial of " + n + " is " + fact);
    }

    public static long factorial(int n) {
        if (n < 0) {
            String msg = "Number must not be negative.";
            throw new IllegalArgumentException(msg);
        }

        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
