// SortedSetSubset.java
package com.jdojo.collections;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetSubset {
    public static void main(String[] args) {
        // Create a sorted set of names
        SortedSet<String> names = new TreeSet<>();
        names.add("John");
        names.add("Adam");
        names.add("Eve");
        names.add("Donna");

        // Print the sorted set
        System.out.println("Sorted Set: " + names);

        // Print the first and last elements in the sorted set
        System.out.println("First: " + names.first());
        System.out.println("Last: " + names.last());

        SortedSet ssBeforeDonna = names.headSet("Donna");
        System.out.println("Head Set Before Donna: " + ssBeforeDonna);

        SortedSet ssBetwenDonnaAndJohn = names.subSet("Donna", "John");
        System.out.println("Subset between Donna and John (exclusive): "
                + ssBetwenDonnaAndJohn);

        // Note the trick "John" + "\0" to include "John" in the subset  
        SortedSet ssBetwenDonnaAndJohn2 = names.subSet("Donna", "John" + "\0");
        System.out.println("Subset between Donna and John (Inclusive): "
                + ssBetwenDonnaAndJohn2);

        SortedSet ssDonnaAndAfter = names.tailSet("Donna");
        System.out.println("Subset from Donna onwards: " + ssDonnaAndAfter);
    }
}
