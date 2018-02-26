// QueueTest.java
package com.jdojo.collections;

import java.util.Queue;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class QueueTest {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("John");

        // offer() will work the same as add()
        queue.offer("Richard");
        queue.offer("Donna");
        queue.offer("Ken");

        System.out.println("Queue: " + queue);

        // Let’s remove elements until the queue is empty
        while (queue.peek() != null) {
            System.out.println("Head Element: " + queue.peek());
            queue.remove();
            System.out.println("Removed one element from Queue");
            System.out.println("Queue: " + queue);
        }

        // Now Queue is empty. Try  calling the peek(), 
        // element(), poll() and remove() methods  
        System.out.println("queue.isEmpty(): " + queue.isEmpty());
        System.out.println("queue.peek(): " + queue.peek());
        System.out.println("queue.poll(): " + queue.poll());

        try {
            String str = queue.element();
            System.out.println("queue.element(): " + str);
        } catch (NoSuchElementException e) {
            System.out.println("queue.element(): Queue is empty.");
        }

        try {
            String str = queue.remove();
            System.out.println("queue.remove(): " + str);
        } catch (NoSuchElementException e) {
            System.out.println("queue.remove(): Queue is empty.");
        }
    }
}
