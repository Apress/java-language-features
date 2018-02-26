// ArrayDimension.java
package com.jdojo.reflection;

public class ArrayDimension {
    public static void main(String[] args) {
        int[][][] intArray = new int[6][3][4];
        System.out.println("int[][][] dimension is " + getArrayDimension(intArray)); 
    }

    public static int getArrayDimension(Object array) {
        int dimension = 0;
        Class c = array.getClass();

        // Perform a check that the object is really an array  
        if (!c.isArray()) {            
            throw new IllegalArgumentException("Object is not an array.");
        }

        while (c.isArray()) {
            dimension++;
            c = c.getComponentType();
        }
        
        return dimension;
    }
}
