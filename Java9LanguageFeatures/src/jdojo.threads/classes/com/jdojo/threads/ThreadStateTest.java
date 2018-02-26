// ThreadStateTest.java
package com.jdojo.threads;

public class ThreadStateTest {
    public static void main(String[] args) {
        Object syncObject = new Object();
        ThreadState ts = new ThreadState(syncObject);
        System.out.println("Before start()-ts.isAlive(): " + ts.isAlive());
        System.out.println("#1: " + ts.getState());

        // Start the thread  
        ts.start();
        System.out.println("After start()-ts.isAlive(): " + ts.isAlive());
        System.out.println("#2: " + ts.getState());
        ts.setWait(true);

        // Make the current thread sleep, so tthe 0s thread starts waiting  
        sleepNow(100);

        synchronized (syncObject) {
            System.out.println("#3: " + ts.getState());
            ts.setWait(false);

            // Wake up the waiting thread  
            syncObject.notifyAll();
        }

        // Make the current thread sleep, so ts thread wakes up  
        sleepNow(2000);
        System.out.println("#4: " + ts.getState());
        ts.setKeepRunning(false);

        // Make the current thread sleep, so the ts thread will wake up  
        sleepNow(2000);
        System.out.println("#5: " + ts.getState());
        System.out.println("At the end. ts.isAlive(): " + ts.isAlive());
    }

    public static void sleepNow(long millis) {
        try {
            Thread.currentThread().sleep(millis);
        } catch (InterruptedException e) {
        }
    }
}
