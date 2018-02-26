// ForEachMethod.java
package com.jdojo.collections;

import java.util.ArrayList;
import java.util.List;

public class ForEachMethod {
    public static void main(String[] args) {
        // Create a list of strings
        List<String> names = new ArrayList<>();

        // Add some names to the list
        names.add("Ken");
        names.add("Lee");
        names.add("Joe");

        // Print all elements of the names list
        names.forEach(System.out::println);
    }
}
