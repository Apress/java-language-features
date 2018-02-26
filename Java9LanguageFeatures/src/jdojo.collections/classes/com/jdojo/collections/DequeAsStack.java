// DequeAsStack.java
package com.jdojo.collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeAsStack {
    public static void main(String[] args) {
        // Create a Deque and use it as stack  
        Deque<String> deque = new ArrayDeque<>();
        deque.push("John");
        deque.push("Richard");
        deque.push("Donna");
        deque.push("Ken");

        System.out.println("Stack: " + deque);

        // Let’s remove all elements from the Deque  
        while (deque.peek() != null) {
            System.out.println("Element at top: " + deque.peek());
            System.out.println("Popped: " + deque.pop());
            System.out.println("Stack: " + deque);
        }

        System.out.println("Stack is empty: " + deque.isEmpty());
    }
}
