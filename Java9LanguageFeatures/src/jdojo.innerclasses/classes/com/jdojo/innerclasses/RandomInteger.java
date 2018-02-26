// RandomInteger.java
package com.jdojo.innerclasses;

import java.util.Random;

public class RandomInteger {
    protected Random rand = new Random();

    public int getValue() {
        return rand.nextInt();
    }
}
