// TaskResult.java
package com.jdojo.threads;

public class TaskResult {
    private final int taskId;
    private final int result;

    public TaskResult(int taskId, int result) {
        this.taskId = taskId;
        this.result = result;
    }

    public int getTaskId() {
        return taskId;
    }

    public int getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "Task Name: Task #" + taskId + ", Task Result:" + result + " seconds";
    }
}
