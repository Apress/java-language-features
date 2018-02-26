// MapTest.java
package com.jdojo.collections;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        // Create a map and add some key-value pairs
        Map<String, String> map = new HashMap<>();
        map.put("John", "(342)113-9878");
        map.put("Richard", "(245)890-9045");
        map.put("Donna", "(205)678-9823");
        map.put("Ken", "(205)678-9823");

        // Print the details
        printDetails(map);

        // Remove all entries from the map  
        map.clear();

        System.out.printf("%nRemoved all entries from the map.%n%n");

        // Print the details
        printDetails(map);
    }

    public static void printDetails(Map<String, String> map) {
        // Get the value for the "Donna" key
        String donnaPhone = map.get("Donna");

        // Print details
        System.out.println("Map: " + map);
        System.out.println("Map Size: " + map.size());
        System.out.println("Map is empty: " + map.isEmpty());
        System.out.println("Map contains Donna key: " + map.containsKey("Donna"));
        System.out.println("Donna Phone: " + donnaPhone);
        System.out.println("Donna key is removed: " + map.remove("Donna"));
    }
}
