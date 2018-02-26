// SortedSetTest.java
package com.jdojo.collections;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetTest {
    public static void main(String[] args) {
        // Create a sorted set of some names  
        SortedSet<String> sortedNames = new TreeSet<>();
        sortedNames.add("John");
        sortedNames.add("Adam");
        sortedNames.add("Eve");
        sortedNames.add("Donna");

        // Print the sorted set of names
        System.out.println(sortedNames);
    }
}
