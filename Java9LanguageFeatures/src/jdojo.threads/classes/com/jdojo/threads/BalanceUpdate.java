// BalanceUpdate.java
package com.jdojo.threads;

public class BalanceUpdate {
    // Initialize balance to 100  
    private static int balance = 100;

    public static void main(String[] args) {
        startBalanceUpdateThread(); // Thread to update the balance value  
        startBalanceMonitorThread(); // Thread to monitor the balance value  
    }

    public static void updateBalance() {
        // Add 10 to balance and subtract 10 from balance  
        balance = balance + 10;
        balance = balance - 10;
    }

    public static void monitorBalance() {
        int b = balance;
        if (b != 100) {
            System.out.println("Balance changed: " + b);
            System.exit(0); // Exit the program  
        }
    }

    public static void startBalanceUpdateThread() {
        // Start a new thread that calls the updateBalance() method in an infinite loop  
        Thread t = new Thread(() -> {
            while (true) {
                updateBalance();
            }
        });
        t.start();
    }

    public static void startBalanceMonitorThread() {
        // Start a thread that monitors the balance value  
        Thread t = new Thread(() -> {
            while (true) {
                monitorBalance();
            }
        });
        t.start();
    }
}
