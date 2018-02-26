// NavigableSetTest.java
package com.jdojo.collections;

import java.util.TreeSet;
import java.util.NavigableSet;

public class NavigableSetTest {
    public static void main(String[] args) {
        // Create a navigable set and add some integers  
        NavigableSet<Integer> ns = new TreeSet<>();
        ns.add(1);
        ns.add(2);
        ns.add(3);
        ns.add(4);
        ns.add(5);

        // Get a reverse view of the navigable set
        NavigableSet reverseNs = ns.descendingSet();

        // Print the normal and reverse views
        System.out.println("Normal view of the Set: " + ns);
        System.out.println("Reverse view of the set: " + reverseNs);

        // Get and print a subset of the navigable set
        System.out.println("\nGetting subset of the set");

        NavigableSet threeOrMore = ns.tailSet(3, true);
        System.out.println("3 or more: " + threeOrMore);

        // Search the navigable set        
        System.out.println("\nSearching through the set");

        System.out.println("lower(3): " + ns.lower(3));
        System.out.println("floor(3): " + ns.floor(3));
        System.out.println("higher(3): " + ns.higher(3));
        System.out.println("ceiling(3): " + ns.ceiling(3));

        // Poll the navigable set        
        System.out.println("\nPolling elements from the set");

        // Poll elements one by one and look at the set  
        System.out.println("pollFirst(): " + ns.pollFirst());
        System.out.println("Navigable Set: " + ns);

        System.out.println("pollLast(): " + ns.pollLast());
        System.out.println("Navigable Set: " + ns);

        System.out.println("pollFirst(): " + ns.pollFirst());
        System.out.println("Navigable Set: " + ns);

        System.out.println("pollFirst(): " + ns.pollFirst());
        System.out.println("Navigable Set: " + ns);

        System.out.println("pollFirst(): " + ns.pollFirst());
        System.out.println("Navigable Set: " + ns);

        // Since the set is empty, polling will return null  
        System.out.println("pollFirst(): " + ns.pollFirst());
        System.out.println("pollLast(): " + ns.pollLast());
    }
}
