// SortedMapTest.java
package com.jdojo.collections;

import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapTest {
    public static void main(String[] args) {
        SortedMap<String, String> sMap = new TreeMap<>();
        sMap.put("John", "(342)113-9878");
        sMap.put("Richard", "(245)890-9045");
        sMap.put("Donna", "(205)678-9823");
        sMap.put("Ken", "(205)678-9823");

        System.out.println("Sorted Map: " + sMap);

        // Get a sub map from Donna (inclusive) to Ken(exclusive)  
        SortedMap<String, String> subMap = sMap.subMap("Donna", "Ken");
        System.out.println("Sorted Submap from Donna to Ken(exclusive): " + subMap);

        // Get the first and last keys  
        String firstKey = sMap.firstKey();
        String lastKey = sMap.lastKey();
        System.out.println("First Key: " + firstKey);
        System.out.println("Last key: " + lastKey);
    }
}
