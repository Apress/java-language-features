// Test.java
package com.jdojo.lambda;

import java.util.List;
import java.util.function.Supplier;

public class Test {
    public static void main(String[] args) {
        Supplier<Integer> supplier = "Ellen"::length;
        System.out.println(supplier.get());

    }

  

}
