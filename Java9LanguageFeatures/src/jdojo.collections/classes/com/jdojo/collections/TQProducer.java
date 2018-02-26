// TQProducer.java
package com.jdojo.collections;

import java.util.Random;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class TQProducer extends Thread {
    private final String name;
    private final TransferQueue<Integer> tQueue;
    private final AtomicInteger sequence;
    private Random rand = new Random();

    public TQProducer(String name, TransferQueue<Integer> tQueue, AtomicInteger sequence) {
        this.name = name;
        this.tQueue = tQueue;
        this.sequence = sequence;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Sleep for 1 to 5 random number of seconds  
                int sleepTime = rand.nextInt(5) + 1;
                Thread.sleep(sleepTime * 1000);

                // Generate a sequence number  
                int nextNum = this.sequence.incrementAndGet();

                // An even number is enqueued. An odd number is handed off 
                // to a consumer  
                if (nextNum % 2 == 0) {
                    System.out.printf("%s: Enqueuing: %d%n", name, nextNum);
                    tQueue.put(nextNum); // Enqueue  
                } else {
                    System.out.printf("%s: Handing off: %d%n", name, nextNum);
                    System.out.printf("%s: has a waiting consumer: %b%n",
                            name, tQueue.hasWaitingConsumer());
                    tQueue.transfer(nextNum); // A hand off  
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
