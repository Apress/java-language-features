// ForEachLoop.java
package com.jdojo.collections;

import java.util.ArrayList;
import java.util.List;

public class ForEachLoop {
    public static void main(String[] args) {
        // Create a list of strings
        List<String> names = new ArrayList<>();

        // Add some names to the list
        names.add("Ken");
        names.add("Lee");
        names.add("Joe");

        // Print all elements of the names list
        for (String name : names) {
            System.out.println(name);
        }
    }
}
