// Mapper.java
package com.jdojo.lambda;

@FunctionalInterface
public interface Mapper<T> {
    // An abstract method
    int map(T source);

    // A generic static method
    public static <U> int[] mapToInt(U[] list, Mapper<? super U> mapper) {
        int[] mappedValues = new int[list.length];

        for (int i = 0; i < list.length; i++) {
            // Map the object to an int
            mappedValues[i] = mapper.map(list[i]);
        }

        return mappedValues;
    }
}
