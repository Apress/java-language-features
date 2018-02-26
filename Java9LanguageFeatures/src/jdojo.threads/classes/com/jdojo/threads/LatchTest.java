// LatchTest.java
package com.jdojo.threads;

import java.util.concurrent.CountDownLatch;

public class LatchTest {
    public static void main(String[] args) {
        // Create a countdown latch with 2 as its counter  
        CountDownLatch latch = new CountDownLatch(2);

        // Create and start the main service  
        LatchMainService ms = new LatchMainService(latch);
        ms.start();

        // Create and start two helper services  
        for (int i = 1; i <= 2; i++) {
            LatchHelperService lhs = new LatchHelperService(i, latch);
            lhs.start();
        }
    }
}
