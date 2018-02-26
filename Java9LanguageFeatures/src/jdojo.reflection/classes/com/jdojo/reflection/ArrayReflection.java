// ArrayReflection.java
package com.jdojo.reflection;

import java.lang.reflect.Array;

public class ArrayReflection {
    public static void main(String[] args) {
        try {
            // Create the array of int of length 2  
            Object arrayObject = Array.newInstance(int.class, 2);

            // Print the values in array element. Default values will be zero
            int n1 = Array.getInt(arrayObject, 0);
            int n2 = Array.getInt(arrayObject, 1);
            System.out.println("n1 = " + n1 + ", n2 = " + n2);

            // Set the values to both elements
            Array.set(arrayObject, 0, 101);
            Array.set(arrayObject, 1, 102);

            // Print the values in array element again  
            n1 = Array.getInt(arrayObject, 0);
            n2 = Array.getInt(arrayObject, 1);
            System.out.println("n1 = " + n1 + ", n2 = " + n2);
        } catch (NegativeArraySizeException | IllegalArgumentException
                | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
