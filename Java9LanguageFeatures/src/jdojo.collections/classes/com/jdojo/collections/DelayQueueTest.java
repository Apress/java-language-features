// DelayQueueTest.java
package com.jdojo.collections;

import java.time.Instant;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

public class DelayQueueTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<DelayedJob> queue = new DelayQueue<>();
        Instant now = Instant.now();

        // Create three delayed job and add them to the queue
        // Jobs should run in a sequence as
        // 1. Populate Data (After 3 seeconds)
        // 2. Balance Data (After 6 seconds)
        // 3. Print Data (After 9 seconds)        
        queue.put(new DelayedJob("Print Data", now.plusSeconds(9)));
        queue.put(new DelayedJob("Populate Data", now.plusSeconds(3)));
        queue.put(new DelayedJob("Balance Data", now.plusSeconds(6)));

        while (queue.size() > 0) {
            System.out.println("Waiting to take a job from the queue...");
            DelayedJob job = queue.take();
            System.out.println("Took Job: " + job);
        }

        System.out.println("Finished running all jobs.");
    }
}
