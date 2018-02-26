// ExchangerProducerConsumerTest.java
package com.jdojo.threads;

import java.util.concurrent.Exchanger;
import java.util.ArrayList;

public class ExchangerProducerConsumerTest {
    public static void main(String[] args) {
        Exchanger<ArrayList<Integer>> exchanger = new Exchanger<>();

        // The producer will produce 5 integers at a time  
        ExchangerProducer producer = new ExchangerProducer(exchanger, 5);
        ExchangerConsumer consumer = new ExchangerConsumer(exchanger);

        producer.start();
        consumer.start();
    }
}
