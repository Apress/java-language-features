// Resurrect.java
package com.jdojo.gc;

public class Resurrect {
    // Declare a static variable of the Resurrect type
    private static Resurrect res = null;

    // Declare an instance variable that stores the name of the object
    private String name = "";

    public Resurrect(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        // We will create objects of the Resurrect class and will not store 
        // their references, so they are eligible for garbage collection immediately.
        for (int count = 1; count <= 1000; count++) {
            new Resurrect("Object #" + count);

            // For every 100 objects created invoke garbage collection
            if (count % 100 == 0) {
                System.gc();
                System.runFinalization();
            }
        }
    }

    public void sayHello() {
        System.out.println("Hello from " + name);
    }

    public static void resurrectIt(Resurrect r) {
        // Set the reference r to static variable res, which makes it reachable 
        // as long as res is reachable.
        res = r;

        // Call a method to show that we really got the object back
        res.sayHello();
    }

    @SuppressWarnings("deprecation")
    @Override
    public void finalize() {
        System.out.println("Inside finalize(): " + name);

        // Resurrect this object
        Resurrect.resurrectIt(this);
    }
}
