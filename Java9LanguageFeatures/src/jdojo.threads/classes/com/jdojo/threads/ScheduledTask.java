// ScheduledTask.java
package com.jdojo.threads;

import java.time.LocalDateTime;

public class ScheduledTask implements Runnable {
    private final int taskId;

    public ScheduledTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Task #" + this.taskId + " ran at " + now);
    }
}
