// PhaserActionTest.java
package com.jdojo.threads;

import java.util.concurrent.Phaser;

public class PhaserActionTest {
    public static void main(String[] args) {
        // Create a Phaser object using an anonymous class and override its 
        // onAdvance() method to define a phaser action  
        Phaser phaser = new Phaser() {
            @Override
            protected boolean onAdvance(int phase, int parties) {
                System.out.println("Inside onAdvance(): phase = "
                        + phase + ", Registered Parties = " + parties);

                // Do not terminate the phaser by returning false  
                return false;
            }
        };

        // Register the self (the "main" thread) as a party  
        phaser.register();

        // Phaser is not terminated here  
        System.out.println("#1: isTerminated(): " + phaser.isTerminated());

        // Since we have only one party registered, this arrival will advance 
        // the phaser and registered parties reduces to zero  
        phaser.arriveAndDeregister();

        // Trigger another phase advance  
        phaser.register();
        phaser.arriveAndDeregister();

        // Phaser is still not terminated  
        System.out.println("#2: isTerminated(): " + phaser.isTerminated());

        // Terminate the phaser  
        phaser.forceTermination();

        // Phaser is terminated  
        System.out.println("#3: isTerminated(): " + phaser.isTerminated());
    }
}
