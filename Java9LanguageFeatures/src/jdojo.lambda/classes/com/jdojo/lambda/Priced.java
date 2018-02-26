// Priced.java
package com.jdojo.lambda;

public interface Priced {
    default double getPrice() {
        return 1.0;
    }
}
