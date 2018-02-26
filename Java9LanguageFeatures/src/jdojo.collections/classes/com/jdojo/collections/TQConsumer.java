// TQConsumer.java
package com.jdojo.collections;

import java.util.Random;
import java.util.concurrent.TransferQueue;

public class TQConsumer extends Thread {
    private final String name;
    private final TransferQueue<Integer> tQueue;
    private final Random rand = new Random();

    public TQConsumer(String name, TransferQueue<Integer> tQueue) {
        this.name = name;
        this.tQueue = tQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Sleep for 1 to 5 random number of seconds  
                int sleepTime = rand.nextInt(5) + 1;
                Thread.sleep(sleepTime * 1000);

                int item = tQueue.take();
                System.out.printf("%s removed: %d%n", name, item);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
