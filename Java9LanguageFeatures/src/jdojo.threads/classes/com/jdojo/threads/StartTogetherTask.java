// StartTogetherTask.java
package com.jdojo.threads;

import java.util.Random;
import java.util.concurrent.Phaser;

public class StartTogetherTask extends Thread {
    private final Phaser phaser;
    private final String taskName;
    private static Random rand = new Random();

    public StartTogetherTask(String taskName, Phaser phaser) {
        this.taskName = taskName;
        this.phaser = phaser;
    }

    @Override
    public void run() {
        System.out.println(taskName + ":Initializing...");

        // Sleep for some time between 1 and 5 seconds  
        int sleepTime = rand.nextInt(5) + 1;
        try {
            Thread.sleep(sleepTime * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(taskName + ":Initialized...");

        // Wait for all parties to arrive to start the task  
        phaser.arriveAndAwaitAdvance();
        System.out.println(taskName + ":Started...");
    }
}
