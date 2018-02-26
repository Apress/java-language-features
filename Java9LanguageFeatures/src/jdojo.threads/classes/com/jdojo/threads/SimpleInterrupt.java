// SimpleInterrupt.java
package com.jdojo.threads;

public class SimpleInterrupt {
    public static void main(String[] args) {
        System.out.println("#1: " + Thread.interrupted());

        // Now interrupt the main thread  
        Thread.currentThread().interrupt();

        // Check if it has been interrupted  
        System.out.println("#2: " + Thread.interrupted());

        // Check again if it has been interrupted  
        System.out.println("#3: " + Thread.interrupted());
    }
}
