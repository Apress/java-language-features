// ThreadPriority.java
package com.jdojo.threads;

public class ThreadPriority {
    public static void main(String[] args) {
        // Get the reference of the current thread  
        Thread t = Thread.currentThread();
        System.out.println("main Thread Priority: " + t.getPriority());

        // Thread t1 gets the same priority as the main thread at this point  
        Thread t1 = new Thread();
        System.out.println("Thread(t1) Priority: " + t1.getPriority());

        t.setPriority(Thread.MAX_PRIORITY);
        System.out.println("main Thread Priority: " + t.getPriority());

        // Thread t2 gets the same priority as main thread at this point, which is 
        // Thread.MAX_PRIORITY (10)  
        Thread t2 = new Thread();
        System.out.println("Thread(t2) Priority: " + t2.getPriority());

        // Change thread t2 priority to minimum  
        t2.setPriority(Thread.MIN_PRIORITY);
        System.out.println("Thread(t2) Priority: " + t2.getPriority());
    }
}
