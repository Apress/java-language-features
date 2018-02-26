// SynchronizedCounter.java
package com.jdojo.threads;

public class SynchronizedCounter {
    private long value;

    public synchronized long next() {
        return ++value;
    }
}
