// AtomicCounter.java
package com.jdojo.threads;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicCounter {
    private final AtomicLong value = new AtomicLong(0L);

    public long next() {
        return value.incrementAndGet();
    }
}
