// NamesList.java
package com.jdojo.collections;

import java.util.ArrayList;
import java.util.List;

public class NamesList {
    public static void main(String[] args) {
        // Create a list of strings
        List<String> names = new ArrayList<>();

        // Print the list details
        System.out.printf("After creation: Size = %d, Elements = %s%n",
                names.size(), names);

        // Add some names to the list
        names.add("Ken");
        names.add("Lee");
        names.add("Joe");

        // Print the list details
        System.out.printf("After adding 3 elements: Size = %d, Elements = %s%n",
                names.size(), names);

        // Remove Lee from the list
        names.remove("Lee");

        // Print the list details
        System.out.printf("After removing 1 element: Size = %d, Elements = %s%n",
                names.size(), names);

        // Clear all elements
        names.clear();

        // Print the list details
        System.out.printf("After clearing all elements: Size = %d, Elements = %s%n",
                names.size(), names);
    }
}
