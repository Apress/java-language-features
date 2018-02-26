// MapperTest.java
package com.jdojo.lambda;

public class MapperTest {
    public static void main(String[] args) {
        // Map names using their length
        System.out.println("Mapping names to their lengths:");
        String[] names = {"David", "Li", "Doug"};
        int[] lengthMapping = Mapper.mapToInt(names, (String name) -> name.length());
        printMapping(names, lengthMapping);

        System.out.println("\nMapping integers to their squares:");
        Integer[] numbers = {7, 3, 67};
        int[] countMapping = Mapper.mapToInt(numbers, (Integer n) -> n * n);
        printMapping(numbers, countMapping);
    }

    public static void printMapping(Object[] from, int[] to) {
        for (int i = 0; i < from.length; i++) {
            System.out.println(from[i] + " mapped to " + to[i]);
        }
    }
}
