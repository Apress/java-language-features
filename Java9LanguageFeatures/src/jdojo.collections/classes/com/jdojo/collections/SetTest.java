// SetTest.java
package com.jdojo.collections;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        // Create a set  
        Set<String> s1 = new HashSet<>();

        // Add a few elements  
        s1.add("John");
        s1.add("Donna");
        s1.add("Ken");
        s1.add("Ken"); // Duplicate!!! No effect  

        // Create another set by copying s1  
        Set<String> s2 = new HashSet<>(s1);

        // Add a few more elements  
        s2.add("Ellen");
        s2.add("Sara");
        s2.add(null); // one null is fine  
        s2.add(null); // Duplicate!!! No effect

        // Create an immutable Set using the Set.of() method
        Set<String> s3 = Set.of("Corky", "Paul", "Tom");

        // Create an empty immutable Set using the Set.of() method
        Set<String> s4 = Set.of();

        // Print the sets
        System.out.println("s1: " + s1);
        System.out.println("s1.size(): " + s1.size());

        System.out.println("s2: " + s2);
        System.out.println("s2.size(): " + s2.size());

        System.out.println("s3: " + s3);
        System.out.println("s3.size(): " + s3.size());

        System.out.println("s4: " + s4);
        System.out.println("s4.size(): " + s4.size());
    }
}
