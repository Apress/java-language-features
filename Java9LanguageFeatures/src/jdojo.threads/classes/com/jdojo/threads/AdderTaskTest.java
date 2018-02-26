// AdderTaskTest.java
package com.jdojo.threads;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Phaser;

public class AdderTaskTest {
    public static void main(String[] args) {
        final int PHASE_COUNT = 2;
        Phaser phaser
                = new Phaser() {
            @Override
            public boolean onAdvance(int phase, int parties) {
                // Print the phaser details  
                System.out.println("Phase:" + phase
                        + ", Parties:" + parties
                        + ", Arrived:" + this.getArrivedParties());
                boolean terminatePhaser = false;

                // Terminate the phaser when we reach the PHASE_COUNT
                // or there is no registered party  
                if (phase >= PHASE_COUNT - 1 || parties == 0) {
                    terminatePhaser = true;
                }

                return terminatePhaser;
            }
        };

        // Use a synchronized List  
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());

        // Let’s start three tasks  
        final int ADDER_COUNT = 3;

        // Register parties one more than the number of adder tasks. 
        // The extra party will synchronize to compute the result of 
        // all generated integers by all adder tasks  
        phaser.bulkRegister(ADDER_COUNT + 1);

        for (int i = 1; i <= ADDER_COUNT; i++) {
            // Create the task and start it  
            String taskName = "Task #" + i;
            AdderTask task = new AdderTask(taskName, phaser, list);
            task.start();
        }

        // Wait for the phaser to terminate, so we can compute the sum 
        // of all generated integers by the adder tasks  
        while (!phaser.isTerminated()) {
            phaser.arriveAndAwaitAdvance();
        }

        // Phaser is terminated now. Compute the sum  
        int sum = 0;
        for (Integer num : list) {
            sum = sum + num;
        }

        System.out.println("Sum = " + sum);
    }
}
