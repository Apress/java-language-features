// Consumer.java
package com.jdojo.threads;

public class Consumer extends Thread {
    private final Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int data;
        while (true) {
            // Consume the data from the buffer. We are not using the consumed 
            // data for any other puporse here  
            data = buffer.consume();
        }
    }
}
