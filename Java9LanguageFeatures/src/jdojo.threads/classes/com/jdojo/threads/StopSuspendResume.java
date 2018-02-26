// StopSuspendResume.java
package com.jdojo.threads;

public class StopSuspendResume extends Thread {
    private volatile boolean keepRunning = true;
    private boolean suspended = false;

    public synchronized void stopThread() {
        this.keepRunning = false;

        // Notify the thread in case it is suspended when this method 
        // is called, so  it will wake up and stop.
        this.notify();
    }

    public synchronized void suspendThread() {
        this.suspended = true;
    }

    public synchronized void resumeThread() {
        this.suspended = false;
        this.notify();
    }

    @Override
    public void run() {
        System.out.println("Thread started...");
        while (keepRunning) {
            try {
                System.out.println("Going to sleep...");
                Thread.sleep(1000);

                // Check for a suspended condition must be made inside a 
                // synchronized block to call the wait() method  
                synchronized (this) {
                    while (suspended) {
                        System.out.println("Suspended...");
                        this.wait();
                        System.out.println("Resumed...");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread stopped...");
    }

    public static void main(String[] args) {
        StopSuspendResume t = new StopSuspendResume();

        // Start the thread  
        t.start();

        // Sleep for 2 seconds  
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Suspend the thread  
        t.suspendThread();

        // Sleep for 2 seconds  
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Resume the thread  
        t.resumeThread();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Stop the thread  
        t.stopThread();
    }
}
