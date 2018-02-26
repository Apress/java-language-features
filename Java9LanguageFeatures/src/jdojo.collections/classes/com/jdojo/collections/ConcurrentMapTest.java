// ConcurrentMapTest.java
package com.jdojo.collections;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentMapTest {
    public static void main(String[] args) {
        ConcurrentMap<String, String> cMap = new ConcurrentHashMap<>();
        cMap.put("one", "one");

        System.out.println("Concurrent Map: " + cMap);

        System.out.println(cMap.putIfAbsent("one", "nine"));
        System.out.println(cMap.putIfAbsent("two", "two"));
        System.out.println(cMap.remove("one", "two"));
        System.out.println(cMap.replace("one", "two"));

        System.out.println("Concurrent Map: " + cMap);
    }
}
