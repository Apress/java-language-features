// Outer2Test.java
package com.jdojo.innerclasses;

public class Outer2Test {
    public static void main(String[] args) {
        Outer2 out = new Outer2();
        Outer2.Inner2 in = out.new Inner2();

        // Print the value 
        out.printValue();
        in.printValue();

        // Set a new value 
        out.setValue(828);

        // Print the value 
        out.printValue();
        in.printValue();
    }
}
