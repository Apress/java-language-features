// WrongSoftRef.java
package com.jdojo.gc;

import java.lang.ref.SoftReference;
import java.util.ArrayList;

public class WrongSoftRef {
    public static void main(String[] args) {
        // Create a big object with an id 101 for caching
        BigObject bigObj = new BigObject(101);

        // Wrap soft reference inside a soft reference
        SoftReference<BigObject> sr = new SoftReference<>(bigObj);

        // Let us try to create many big objects storing their 
        // references in an array list, just to use up big memory.
        ArrayList<BigObject> bigList = new ArrayList<>();
        long counter = 102;
        while (true) {
            bigList.add(new BigObject(counter++));
        }
    }
}
