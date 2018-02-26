// RunnableTask.java
package com.jdojo.threads;

import java.util.Random;

public class RunnableTask implements Runnable {
    private final int taskId;
    private final int loopCounter;
    private final Random random = new Random();

    public RunnableTask(int taskId, int loopCounter) {
        this.taskId = taskId;
        this.loopCounter = loopCounter;
    }

    @Override
    public void run() {
        for (int i = 1; i <= loopCounter; i++) {
            try {
                int sleepTime = random.nextInt(10) + 1;
                System.out.println("Task #" + this.taskId
                        + " - Iteration #" + i
                        + " is going to sleep for "
                        + sleepTime + " seconds.");

                Thread.sleep(sleepTime * 1000);
            } catch (InterruptedException e) {
                System.out.println("Task #" + this.taskId
                        + " has been interrupted.");
                break;
            }
        }
    }
}
