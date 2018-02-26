// UncaughtExceptionInThread.java
package com.jdojo.threads;

public class UncaughtExceptionInThread {
    public static void main(String[] args) {
        CatchAllThreadExceptionHandler handler = new CatchAllThreadExceptionHandler();

        // Set an uncaught exception handler for the main thread  
        Thread.currentThread().setUncaughtExceptionHandler(handler);

        // Throw an exception  
        throw new RuntimeException();
    }
}
