// Test.java
package com.jdojo.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {
    public static void main(String[] args) {
        Runnable badTask = Test::run;

        // Create an executor service
        ExecutorService exec = Executors.newSingleThreadExecutor();

        // Submit a task
        Future submittedTask = exec.submit(badTask);

        try {
            // The get method should throw ExecutionException  
            Object result = submittedTask.get();
            System.out.println("Result: " + result);
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

    public static void run() {
        System.out.println("I am running");
    }
}
