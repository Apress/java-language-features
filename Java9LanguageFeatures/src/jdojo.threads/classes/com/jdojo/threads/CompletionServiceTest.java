// CompletionServiceTest.java
package com.jdojo.threads;

import java.util.concurrent.Future;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;

public class CompletionServiceTest {
    public static void main(String[] args) {
        // Get an executor with three threads in its thread pool  
        ExecutorService exec = Executors.newFixedThreadPool(3);

        // Completed task returns an object of the TaskResult class  
        ExecutorCompletionService<TaskResult> completionService
                = new ExecutorCompletionService<>(exec);

        // Submit five tasks and each task will sleep three times for a 
        // random period between 1 and 10 seconds  
        for (int i = 1; i <= 5; i++) {
            SleepingTask task = new SleepingTask(i, 3);
            completionService.submit(task);
        }

        // Print the result of each task as they are completed  
        for (int i = 1; i <= 5; i++) {
            try {
                Future<TaskResult> completedTask = completionService.take();
                TaskResult result = completedTask.get();
                System.out.println("Completed a task - " + result);
            } catch (ExecutionException ex) {
                System.out.println("Error in executing the task.");
            } catch (InterruptedException ex) {
                System.out.println("Task execution has been interrupted.");
            }
        }

        // Let’s shut down the executor  
        exec.shutdown();
    }
}
