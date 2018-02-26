// RunnableTaskTest.java
package com.jdojo.threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class RunnableTaskTest {
    public static void main(String[] args) {
        final int THREAD_COUNT = 3;
        final int LOOP_COUNT = 3;
        final int TASK_COUNT = 5;

        // Get an executor with three threads in its thread pool  
        ExecutorService exec = Executors.newFixedThreadPool(THREAD_COUNT);

        // Create five tasks and submit them to the executor  
        for (int i = 1; i <= TASK_COUNT; i++) {
            RunnableTask task = new RunnableTask(i, LOOP_COUNT);
            exec.submit(task);
        }

        // Let’s shutdown the executor  
        exec.shutdown();        
    }
}
