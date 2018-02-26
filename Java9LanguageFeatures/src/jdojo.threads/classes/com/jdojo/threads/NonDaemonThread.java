// NonDaemonThread.java
package com.jdojo.threads;

public class NonDaemonThread {
    public static void main(String[] args) {
        Thread t = new Thread(NonDaemonThread::print);

        // t is already a non-daemon thread because the "main" thread that runs
        // the main() method is a non-daemon thread. You can verify it by using 
        // t.isDaemon() method. It will return false. Still we will use 
        // the following statement to make it clear that we want t to be
        // a non-daemon thread.  
        t.setDaemon(false);
        t.start();
        System.out.println("Exiting main method");
    }

    public static void print() {
        int counter = 1;
        while (true) {
            try {
                System.out.println("Counter: " + counter++);
                Thread.sleep(2000); // sleep for 2 seconds  
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
