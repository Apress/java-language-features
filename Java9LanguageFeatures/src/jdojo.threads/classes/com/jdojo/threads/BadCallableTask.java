// BadCallableTask.java
package com.jdojo.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

public class BadCallableTask {
    public static void main(String[] args) {
        Callable<Object> badTask = () -> {
            throw new RuntimeException("The task threw an exception...");
        };

        // Create an executor service
        ExecutorService exec = Executors.newSingleThreadExecutor();

        // Submit a task
        Future submittedTask = exec.submit(badTask);

        try {
            // The get method should throw ExecutionException  
            Object result = submittedTask.get();
        } catch (ExecutionException e) {
            System.out.println("Execution exception has occurred: "
                    + e.getMessage());
            System.out.println("Execution exception cause is: "
                    + e.getCause().getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        exec.shutdown();
    }
}
