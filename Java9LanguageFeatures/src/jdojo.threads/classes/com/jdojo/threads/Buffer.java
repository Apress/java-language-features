// Buffer.java
package com.jdojo.threads;

public class Buffer {
    private int data;
    private boolean empty;

    public Buffer() {
        this.empty = true;
    }

    public synchronized void produce(int newData) {
        // Wait until the buffer is empty  
        while (!this.empty) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Store the new data produced by the producer  
        this.data = newData;

        // Set the empty flag to false, so the consumer may consume the data  
        this.empty = false;

        // Notify the waiting consumer in the wait set  
        this.notify();

        System.out.println("Produced: " + newData);
    }

    public synchronized int consume() {
        // Wait until the buffer gets some data  
        while (this.empty) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Set the empty flag to true, so that the producer can store new data  
        this.empty = true;

        // Notify the waiting producer in the wait set  
        this.notify();

        System.out.println("Consumed: " + data);

        return data;
    }
}
