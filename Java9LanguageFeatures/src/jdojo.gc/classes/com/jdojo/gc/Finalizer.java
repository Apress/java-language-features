// Finalizer.java
package com.jdojo.gc;

public class Finalizer {
    // id is used to identify the object
    private final int id;
    
    // Constructor which takes the id as argument
    public Finalizer(int id){
        this.id = id;
    }
    
    // This is the finalizer for the object. The JVM will call this method, 
    // before the object is garbage collected    
    @SuppressWarnings("deprecation")
    @Override
    public void finalize(){
        // Just print a message indicating which object is being garbage
        // collected. Print message when id is a multiple of 100 
        // just to avoid a bigger output.
        if (id % 100 == 0) { 
            System.out.println ("finalize() called for " + id ) ;    
        }    
    }

    public static void main(String[] args) {
        // Create 500000 objects of the Finalizer class
        for(int i = 1; i <= 500000; i++){
            // Do not store reference to the new object
            new Finalizer(i);
        }

        // Invoke the garbage collector
        System.gc();
    }    
}
