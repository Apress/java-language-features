// ScheduledTaskTest.java
package com.jdojo.threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledTaskTest {
    public static void main(String[] args) {
        // Get an executor with 3 threads  
        ScheduledExecutorService sexec = Executors.newScheduledThreadPool(3);

        // Task #1 and Task #2  
        ScheduledTask task1 = new ScheduledTask(1);
        ScheduledTask task2 = new ScheduledTask(2);

        // Task #1 will run after 2 seconds  
        sexec.schedule(task1, 2, TimeUnit.SECONDS);

        // Task #2 runs after 5 seconds delay and keep running every 10 seconds
        sexec.scheduleAtFixedRate(task2, 5, 10, TimeUnit.SECONDS);

        // Let the current thread sleep for 60 seconds and shut down the 
        // executor that will cancel the task #2 because it is scheduled 
        // to run after every 10 seconds 
        try {
            TimeUnit.SECONDS.sleep(60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Shut down the executor  
        sexec.shutdown();
    }
}
