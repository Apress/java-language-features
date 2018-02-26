// LinkedHashSetTest.java
package com.jdojo.collections;

import java.util.Set;
import java.util.LinkedHashSet;
import java.util.HashSet;

public class LinkedHashSetTest {
    public static void main(String[] args) {
        Set<String> s1 = new LinkedHashSet<>();
        s1.add("John");
        s1.add("Adam");
        s1.add("Eve");
        s1.add("Donna");
        System.out.println("LinkedHashSet: " + s1);

        // Add the same elements to this set
        Set<String> s2 = new HashSet<>();
        s2.add("John");
        s2.add("Adam");
        s2.add("Eve");
        s2.add("Donna");
        System.out.println("HashSet: " + s2);

        System.out.println("s1.equals(s2): " + s1.equals(s2));
    }
}
