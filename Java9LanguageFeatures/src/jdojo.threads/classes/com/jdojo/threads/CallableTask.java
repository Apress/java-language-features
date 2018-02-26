// CallableTask.java
package com.jdojo.threads;

import java.util.Random;
import java.util.concurrent.Callable;

public class CallableTask implements Callable<Integer> {
    private final int taskId;
    private final int loopCounter;
    private final Random random = new Random();

    public CallableTask(int taskId, int loopCounter) {
        this.taskId = taskId;
        this.loopCounter = loopCounter;
    }

    @Override
    public Integer call() throws InterruptedException {
        int totalSleepTime = 0;
        
        for (int i = 1; i <= loopCounter; i++) {
            try {
                int sleepTime = random.nextInt(10) + 1;
                
                System.out.println("Task #" + this.taskId
                        + " - Iteration #" + i
                        + " is going to sleep for "
                        + sleepTime + " seconds.");
                
                Thread.sleep(sleepTime * 1000);
                totalSleepTime = totalSleepTime + sleepTime;
            } catch (InterruptedException e) {
                System.out.println("Task #" + this.taskId
                        + " has been interrupted.");
                throw e;
            }
        }
        
        return totalSleepTime;
    }
}
