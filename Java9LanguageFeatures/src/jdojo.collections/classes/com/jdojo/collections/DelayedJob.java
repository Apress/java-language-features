// DelayedJob.java
package com.jdojo.collections;

import java.time.Instant;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.time.temporal.ChronoUnit.MILLIS;

public class DelayedJob implements Delayed {
    private final Instant scheduledTime;
    String jobName;

    public DelayedJob(String jobName, Instant scheduledTime) {
        this.scheduledTime = scheduledTime;
        this.jobName = jobName;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        // Positive delay means it should stay in queue. Zero or negative delay 
        // means that it ready to be removed from the queue.
        long delay = MILLIS.between(Instant.now(), scheduledTime);

        // Convert the delay in millis into the specified unit
        long returnValue = unit.convert(delay, MILLISECONDS);
        return returnValue;
    }

    @Override
    public int compareTo(Delayed job) {
        long currentJobDelay = this.getDelay(MILLISECONDS);
        long jobDelay = job.getDelay(MILLISECONDS);

        int diff = 0;
        if (currentJobDelay > jobDelay) {
            diff = 1;
        } else if (currentJobDelay < jobDelay) {
            diff = -1;
        }
        return diff;
    }

    @Override
    public String toString() {
        String str = "(" + this.jobName + ", " + "Scheduled Time: "
                + this.scheduledTime + ")";
        return str;
    }
}
