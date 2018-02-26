// IllegalAccess1.java
package com.jdojo.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class IllegalAccess1 {
    public static void main(String[] args) throws Exception {
        // Get the class reference for the Person class
        String className = "com.jdojo.reflection.Person";
        Class<?> cls = Class.forName(className);
        
        // Create a Person object
        Constructor<?> cons = cls.getConstructor();
        Object person = cons.newInstance();
        
        // Get the reference of the name field
        Field nameField = cls.getDeclaredField("name");
        
        // Try accessing the name field by reading its value
        String name = (String) nameField.get(person);
        
        // Print the person and its name separately
        System.out.println(person);
        System.out.println("name=" + name);
    }
}
