// CleanerTest.java
package com.jdojo.gc;

public class CleanerTest { 
    public static void main(String[] args) throws InterruptedException {
        // Let us try a CleanBigObject in a try-with-resources block        
        try (CleanBigObject cbo1 = new CleanBigObject(1969);) {
            System.out.println(cbo1 + " created inside a try-with-resources block.");
        }

        // Let us create and clean a CleanBigObject explicitly
        CleanBigObject cbo2 = new CleanBigObject(1968);
        System.out.println(cbo2 + " created.");
        cbo2.close();
        cbo2 = null;
        
        // Let us create many CleanBigObject and let the Cleaner
        // clean those objects automatically
        new CleanBigObject(1982);
        System.gc();

        // Wait for 2 seconds for the garbage collector to finish
        Thread.sleep(20000);
    }
}
