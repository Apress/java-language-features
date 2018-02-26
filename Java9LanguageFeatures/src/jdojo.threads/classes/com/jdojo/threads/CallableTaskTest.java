// CallableTaskTest.java
package com.jdojo.threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

public class CallableTaskTest {
    public static void main(String[] args) {
        // Get an executor with three threads in its thread pool  
        ExecutorService exec = Executors.newFixedThreadPool(3);

        // Create the callable task with loop counter as 3  
        CallableTask task = new CallableTask(1, 3);

        // Submit the callable task to executor  
        Future<Integer> submittedTask = exec.submit(task);

        try {
            Integer result = submittedTask.get();
            System.out.println("Task's total sleep time: " + result + " seconds");
        } catch (ExecutionException e) {
            System.out.println("Error in executing the task.");
        } catch (InterruptedException e) {
            System.out.println("Task execution has been interrupted.");
        }

        // Let’s shutdown the executor  
        exec.shutdown();
    }
}
