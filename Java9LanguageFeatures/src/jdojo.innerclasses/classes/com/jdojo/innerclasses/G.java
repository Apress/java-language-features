// G.java
package com.jdojo.innerclasses;


public class G extends A.B {
    public G(A a) {
        a.super(); // Must be the first statement 
    }
}

