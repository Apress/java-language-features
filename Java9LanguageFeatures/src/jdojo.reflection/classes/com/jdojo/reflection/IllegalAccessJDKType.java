// IllegalAccess1.java
package com.jdojo.reflection;

import java.lang.reflect.Field;

public class IllegalAccessJDKType {
    public static void main(String[] args) throws Exception {
        // Create a Long object
        Long num = 1969L;
        System.out.println("#1: num = " + num);

        // Get the class reference for the Long class
        String className = "java.lang.Long";
        Class<?> cls = Class.forName(className);

        // Get the value field reference
        Field valueField = cls.getDeclaredField("value");

        // try making the value field accessible before accessing it        
        boolean accessEnabled = valueField.trySetAccessible();

        if (accessEnabled) {
            // Get and print the current value of the Long.value private field of the 
            // num object that you created in the beginning of this method
            Long value = (Long) valueField.get(num);

            System.out.println("#2: num = " + value);

            // Change the value of the Long.valeu field
            valueField.set(num, 1968L);
            value = (Long) valueField.get(num);

            System.out.println("#3: num = " + value);
        } else {
            System.out.println("The Long.value field is not accessible.");
        }
    }
}
