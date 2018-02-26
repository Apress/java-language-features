// BlockedInterrupted.java
package com.jdojo.threads;

public class BlockedInterrupted {
    public static void main(String[] args) {
        Thread t = new Thread(BlockedInterrupted::run);
        t.start();

        // main thread sleeps for 5 seconds  
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Interrupt the sleeping thread  
        t.interrupt();
    }

    public static void run() {
        int counter = 1;
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println("Counter: " + counter++);
            } catch (InterruptedException e) {
                System.out.println("I got interrupted!");

                // Terminate the thread by returning  
                return;
            }
        }

    }
}
