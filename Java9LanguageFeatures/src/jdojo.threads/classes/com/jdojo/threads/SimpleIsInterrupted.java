// SimpleIsInterrupted.java
package com.jdojo.threads;

public class SimpleIsInterrupted {
    public static void main(String[] args) {
        // Check if the main thread is interrupted  
        System.out.println("#1: " + Thread.interrupted());

        // Now interrupt the main thread  
        Thread mainThread = Thread.currentThread();
        mainThread.interrupt();

        // Check if it has been interrupted  
        System.out.println("#2: " + mainThread.isInterrupted());

        // Check if it has been interrupted  
        System.out.println("#3: " + mainThread.isInterrupted());

        // Now check if it has been interrupted using the static method 
        // which will clear the interrupted status  
        System.out.println("#4: " + Thread.interrupted());

        // Now, isInterrupted() should return false, because previous 
        // statement Thread.interrupted() has cleared the flag  
        System.out.println("#5: " + mainThread.isInterrupted());
    }
}
