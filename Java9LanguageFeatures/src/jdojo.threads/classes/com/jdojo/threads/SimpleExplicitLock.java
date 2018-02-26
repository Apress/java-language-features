// SimpleExplicitLock.java
package com.jdojo.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleExplicitLock {
    // Instantiate the lock object  
    private final Lock myLock = new ReentrantLock();

    public void updateResource() {
        // Acquire the lock  
        myLock.lock();

        try {
            // Logic for updating/reading the shared resource goes here
        } finally {
            // Release the lock  
            myLock.unlock();
        }
    }
}
