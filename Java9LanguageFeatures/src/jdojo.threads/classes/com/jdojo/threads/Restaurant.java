// Restaurant.java
package com.jdojo.threads;

import java.util.concurrent.Semaphore;

public class Restaurant {
    private final Semaphore tables;

    public Restaurant(int tablesCount) {
        // Create a semaphore using number of tables we have  
        this.tables = new Semaphore(tablesCount);
    }

    public void getTable(int customerID) {
        try {
            System.out.println("Customer #" + customerID
                    + " is trying to get a table.");

            // Acquire a permit for a table  
            tables.acquire();

            System.out.println("Customer #" + customerID + " got a table.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void returnTable(int customerID) {
        System.out.println("Customer #" + customerID + " returned a table.");
        tables.release();
    }

    public static void main(String[] args) {
        // Create a restaurant with two dining tables  
        Restaurant restaurant = new Restaurant(2);

        // Create five customers  
        for (int i = 1; i <= 5; i++) {
            RestaurantCustomer c = new RestaurantCustomer(restaurant, i);
            c.start();
        }
    }
}
