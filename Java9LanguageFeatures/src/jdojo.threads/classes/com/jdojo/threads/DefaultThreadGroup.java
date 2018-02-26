// DefaultThreadGroup.java
package com.jdojo.threads;

public class DefaultThreadGroup {
    public static void main(String[] args) {
        // Get the current thread, which is called "main"  
        Thread t1 = Thread.currentThread();

        // Get the thread group of the main thread  
        ThreadGroup tg1 = t1.getThreadGroup();

        System.out.println("Current thread's name: " + t1.getName());
        System.out.println("Current thread's group name: " + tg1.getName());

        // Creates a new thread. Its thread group is the same that of the main thread.
        Thread t2 = new Thread("my new thread");

        ThreadGroup tg2 = t2.getThreadGroup();
        System.out.println("New thread's name: " + t2.getName());
        System.out.println("New thread's group name: " + tg2.getName());
    }
}
