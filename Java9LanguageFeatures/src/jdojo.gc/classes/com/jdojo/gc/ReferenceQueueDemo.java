// ReferenceQueueDemo.java
package com.jdojo.gc;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class ReferenceQueueDemo {
    public static void main(String[] args) {
        // Create a reference queue
        ReferenceQueue<BigObject> q = new ReferenceQueue<>();

        // Wrap a BigObject inside a soft reference. 
        // Also register the soft reference with the reference queue 
        BigObject bigObj = new BigObject(131);
        WeakReference<BigObject> wr = new WeakReference<>(bigObj, q);

        // Clear the strong reference to the big object
        bigObj = null;

        // Check if weak reference has been queued
        System.out.println("Before calling gc():");
        printMessage(wr, q);

        // Invoke garbage collector. If it runs, it will clear the weak reference 
        System.out.println("Invoking garbage collector...");
        System.gc();
        System.out.println("Garbage collector finished...");

        // Check if weak reference has been queued
        System.out.println("After calling gc():");
        printMessage(wr, q);
    }

    public static void printMessage(WeakReference<BigObject> wr, 
            ReferenceQueue<BigObject> q) {
        System.out.println("wr.get() = " + wr.get());
        System.out.println("wr.isEnqueued() = " + wr.isEnqueued());
        WeakReference<BigObject> temp = (WeakReference<BigObject>) q.poll();
        if (temp == wr) {
            System.out.println("q.poll() returned wr");
        } else {
            System.out.println("q.poll() = " + temp);
        }
    }
}
