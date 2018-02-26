// InvokeGC.java
package com.jdojo.gc;

public class InvokeGC {
    public static void main(String[] args) {
        long m1, m2, m3;

        // Get a runtime instance
        Runtime rt = Runtime.getRuntime();

        for (int i = 0; i < 3; i++) {
            // Get free memory
            m1 = rt.freeMemory();

            // Create some objects
            createObjects(2000);

            // Get free memory
            m2 = rt.freeMemory();

            // Invoke garbage collection
            System.gc();

            // Get free memory
            m3 = rt.freeMemory();

            System.out.println("m1 = " + m1 + ", m2 = " + m2 + ", m3 = "
                    + m3 + "\nMemory freed by gc() = " + (m3 - m2));

            System.out.println("-------------------------");
        }
    }

    public static void createObjects(int count) {
        for (int i = 0; i < count; i++) {
            // Do not store the references of new objects, so they become
            // eligible for garbage collection immediately.
            new Object();
        }
    }
}
