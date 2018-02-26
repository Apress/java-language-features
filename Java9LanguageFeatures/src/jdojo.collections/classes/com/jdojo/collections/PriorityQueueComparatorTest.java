// PriorityQueueComparatorTest.java
package com.jdojo.collections;

import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Comparator;

public class PriorityQueueComparatorTest {
    public static void main(String[] args) {
        Comparator<ComparablePerson> nameComparator
                = Comparator.comparing(ComparablePerson::getName);

        // Create a priority queue with a Comparator
        Queue<ComparablePerson> pq = new PriorityQueue<>(nameComparator);
        pq.add(new ComparablePerson(1, "John"));
        pq.add(new ComparablePerson(4, "Ken"));
        pq.add(new ComparablePerson(2, "Richard"));
        pq.add(new ComparablePerson(3, "Donna"));
        pq.add(new ComparablePerson(4, "Adam"));

        System.out.println("Priority queue: " + pq);

        while (pq.peek() != null) {
            System.out.println("Head Element: " + pq.peek());
            pq.remove();
            System.out.println("Removed one element from Queue");
            System.out.println("Priority queue: " + pq);
        }
    }
}
