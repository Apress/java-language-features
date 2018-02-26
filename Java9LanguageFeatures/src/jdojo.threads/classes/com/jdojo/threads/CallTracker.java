// CallTracker.java
package com.jdojo.threads;

public class CallTracker {
    // threadLocal variable is used to store counters for all threads  
    private static final ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

    public static void call() {
        Integer counterObject = threadLocal.get();

        // Initialize counter to 1
        int counter = 1;
        
        if (counterObject != null) {
            counter = counterObject + 1;
        }

        // Set the new counter  
        threadLocal.set(counter);

        // Print how many times this thread has called this method  
        String threadName = Thread.currentThread().getName();
        System.out.println("Call counter for " + threadName + " = " + counter);
    }
}
