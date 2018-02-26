// WeakHashMapDemo.java
package com.jdojo.gc;

import java.util.WeakHashMap;

public class WeakHashMapDemo {
    public static void main(String[] args) {
        // Create a WeakHashMap
        WeakHashMap<BigObject, BigObject> wmap = new WeakHashMap<>();

        // Add two key-value pairs to WeakHashMap
        BigObject key1 = new BigObject(10);
        BigObject value1 = new BigObject(110);
        BigObject key2 = new BigObject(20);
        BigObject value2 = new BigObject(210);

        wmap.put(key1, value1);
        wmap.put(key2, value2);

        // Printa  message 
        printMessage("After adding two entries:", wmap);

        /* Invoke gc(). This gc() invocation will not reclaim any of 
           the key objects, because we are still having their strong references. 
         */
        System.out.println("Invoking gc() first time...");
        System.gc();

        // Print a message
        printMessage("After first gc() call:", wmap);

        // Now remove strong references to keys and values
        key1 = null;
        key2 = null;
        value1 = null;
        value2 = null;

        /* Invoke gc(). This gc() invocation will reclaim two key objects 
           with ids 10 and 20. However, the corresponding two value objects
           will still /be strongly referenced by WeakHashMap internally and hence 
           will not be reclaimed at this point.
         */
        System.out.println("Invoking gc() second time...");
        System.gc();

        // Print a message
        printMessage("After second gc() call:", wmap);

        /* Both keys have been reclaimed by now. Just to make value 
           objects reclaimable, we will call clear() method on WeakHashMap. 
           Usually, you will not call this method here in your program.
         */
        wmap.clear();

        // Invoke gc() so that value object will be reclaimed
        System.out.println("Invoking gc() third time...");
        System.gc();

        // Print message
        printMessage("After calling clear() method:", wmap);
    }

    public static void printMessage(String msgHeader, WeakHashMap wmap) {
        System.out.println(msgHeader);

        // Print the size and content of map */
        System.out.println("Size = " + wmap.size());
        System.out.println("Content = " + wmap);
        System.out.println();
    }
}
