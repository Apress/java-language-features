// NavigableMapTest.java
package com.jdojo.collections;

import java.util.TreeMap;
import java.util.NavigableMap;
import java.util.Map.Entry;

public class NavigableMapTest {
    public static void main(String[] args) {
        // Create a sorted map sorted on string keys alphabetically
        NavigableMap<String, String> nMap = new TreeMap<>();
        nMap.put("John", "(342)113-9878");
        nMap.put("Richard", "(245)890-9045");
        nMap.put("Donna", "(205)678-9823");
        nMap.put("Ken", "(205)678-9823");

        System.out.println("Navigable Map:" + nMap);

        // Get the closest lower and higher matches for Ken  
        Entry<String, String> lowerKen = nMap.lowerEntry("Ken");
        Entry<String, String> floorKen = nMap.floorEntry("Ken");
        Entry<String, String> higherKen = nMap.higherEntry("Ken");
        Entry<String, String> ceilingKen = nMap.ceilingEntry("Ken");

        System.out.println("Lower Ken: " + lowerKen);
        System.out.println("Floor Ken: " + floorKen);
        System.out.println("Higher Ken: " + higherKen);
        System.out.println("Ceiling Ken: " + ceilingKen);

        // Get the reverse order view of the map  
        NavigableMap<String, String> reverseMap = nMap.descendingMap();
        System.out.println("Navigable Map(Reverse Order):" + reverseMap);
    }
}
