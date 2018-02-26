// BQProducer.java
package com.jdojo.collections;

import java.util.concurrent.BlockingQueue;
import java.util.Random;

public class BQProducer extends Thread {
    private final BlockingQueue<String> queue;
    private final String name;
    private int nextNumber = 1;
    private final Random random = new Random();

    public BQProducer(BlockingQueue<String> queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String str = name + "-" + nextNumber;
                System.out.println(name + " is trying to add: "
                        + str + ". Remaining capacity: "
                        + queue.remainingCapacity());
                this.queue.put(str);
                nextNumber++;
                System.out.println(name + " added: " + str);

                // Sleep between 1 and 5 seconds  
                int sleepTime = (random.nextInt(5) + 1) * 1000;
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
