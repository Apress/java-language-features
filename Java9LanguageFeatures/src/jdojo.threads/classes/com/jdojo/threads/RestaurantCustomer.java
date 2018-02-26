// RestaurantCustomer.java
package com.jdojo.threads;

import java.util.Random;

class RestaurantCustomer extends Thread {
    private final Restaurant r;
    private final int customerID;
    private static final Random random = new Random();

    public RestaurantCustomer(Restaurant r, int customerID) {
        this.r = r;
        this.customerID = customerID;
    }

    @Override
    public void run() {
        r.getTable(this.customerID); // Get a table  

        try {
            // Eat for some time. Use number between 1 and 30 seconds  
            int eatingTime = random.nextInt(30) + 1;
            System.out.println("Customer #" + this.customerID
                    + " will eat for " + eatingTime + " seconds.");

            Thread.sleep(eatingTime * 1000);

            System.out.println("Customer #" + this.customerID
                    + " is done eating.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            r.returnTable(this.customerID);
        }
    }
}
