// MeetAtBarrier.java
package com.jdojo.threads;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;

public class MeetAtBarrier extends Thread {
    private final CyclicBarrier barrier;
    private final int ID;
    private static final Random random = new Random();

    public MeetAtBarrier(int ID, CyclicBarrier barrier) {
        this.ID = ID;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            // Generate a random number between 1 and 30 to wait  
            int workTime = random.nextInt(30) + 1;

            System.out.println("Thread #" + ID + " is going to work for "
                    + workTime + " seconds");

            // Yes. Sleeping is working for this thread!!!  
            Thread.sleep(workTime * 1000);

            System.out.println("Thread #" + ID + " is waiting at the barrier...");

            // Wait at barrier for other threads in group to arrive  
            this.barrier.await();

            System.out.println("Thread #" + ID + " passed the barrier...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            System.out.println("Barrier is broken...");
        }
    }

    public static void main(String[] args) {
        // Create a barrier for a group of three threads with a barrier action
        String msg = "We are all together. It's party time...";
        Runnable barrierAction
                = () -> System.out.println(msg);
        CyclicBarrier barrier = new CyclicBarrier(3, barrierAction);

        for (int i = 1; i <= 3; i++) {
            MeetAtBarrier t = new MeetAtBarrier(i, barrier);
            t.start();
        }
    }
}
