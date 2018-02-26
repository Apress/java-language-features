// Outer.java
package com.jdojo.innerclasses;

public class Outer { 
    private int value = 1116;

    // The Inner class starts here 
    public class Inner {
        public void printValue() {
            System.out.println("Inner: value = " + value);
        }
    } // The Inner class ends here 

    // An instance method for the Outer class 
    public void printValue() {
        System.out.println("Outer: value = " + value);
    }

    // Another instance method for the Outer class 
    public void setValue(int newValue) {
        this.value = newValue;
    }
}
