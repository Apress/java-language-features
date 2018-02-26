// Philosopher.java
package com.jdojo.threads;

import java.util.concurrent.locks.Lock;

public class Philosopher {
    private final Lock leftFork;
    private final Lock rightFork;
    private final String name; // Philosopher's name  

    public Philosopher(Lock leftFork, Lock rightFork, String name) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.name = name;
    }

    public void think() {
        System.out.println(name + " is thinking...");
    }

    public void eat() {
        // Try to get the left fork  
        if (leftFork.tryLock()) {
            try {
                // try to get the right fork  
                if (rightFork.tryLock()) {
                    try {
                        // Got both forks. Eat now  
                        System.out.println(name + " is eating...");
                    } finally {
                        // release the right fork  
                        rightFork.unlock();
                    }
                }
            } finally {
                // release the left fork  
                leftFork.unlock();
            }
        }
    }
}
