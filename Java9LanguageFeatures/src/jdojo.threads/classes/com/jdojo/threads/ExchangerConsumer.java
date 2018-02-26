// ExchangerConsumer.java
package com.jdojo.threads;

import java.util.concurrent.Exchanger;
import java.util.ArrayList;
import java.util.Random;

public class ExchangerConsumer extends Thread {
    private final Exchanger<ArrayList<Integer>> exchanger;
    private ArrayList<Integer> buffer = new ArrayList<>();
    private final Random random = new Random();

    public ExchangerConsumer(Exchanger<ArrayList<Integer>> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        // keep consuming the integers  
        while (true) {
            try {
                // Let’s wait for the consumer to exchange data  
                System.out.println("Consumer is waiting to exchange the data...");

                buffer = exchanger.exchange(buffer);
                System.out.println("Consumer has received:" + buffer);
                System.out.println("Consumer is emptying data from the buffer...");

                // Wait for some time by sleeping  
                int sleepTime = random.nextInt(20) + 1;

                // Sleep for some time  
                Thread.sleep(sleepTime * 1000);

                // Empty the buffer  
                this.emptyBuffer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void emptyBuffer() {
        buffer.clear();
    }
}
