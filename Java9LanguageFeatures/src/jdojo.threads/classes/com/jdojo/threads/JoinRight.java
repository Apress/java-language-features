// JoinRight.java
package com.jdojo.threads;

public class JoinRight {
    public static void main(String[] args) {
        Thread t1 = new Thread(JoinRight::print);
        t1.start();

        try {
            t1.join(); // "main" thread waits until t1 is terminated  
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("We are done.");
    }

    public static void print() {
        for (int i = 1; i <= 5; i++) {
            try {
                System.out.println("Counter: " + i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
