// SquaredIntsSum.java
package com.jdojo.streams;

import java.util.List;

public class SquaredIntsSum {
    public static void main(String[] args) {
        // Get a list of integers from 1 to 5
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // Compute the sum of the squares of all odd integers in the list
        int sum = numbers.stream()
                         .filter(n -> n % 2 == 1)
                         .map(n -> n * n)
                         .reduce(0, Integer::sum);
        
        System.out.println("Sum = " + sum);
    }
}
