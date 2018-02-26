// BigObject.java
package com.jdojo.gc;

public class BigObject {
    // Declare a big array of 20 KB. 
    private final long[] anArray = new long[20480];

    // Have an id to track the object
    private final long id;

    public BigObject(long id) {
        this.id = id;
    }

    // Define finalize() to track the object’s finalization
    @SuppressWarnings("deprecation")
    @Override
    public void finalize() {
        System.out.println("finalize() called for id: " + id);
    }

    @Override
    public String toString() {
        return "BigObject: id = " + id;
    }
}
