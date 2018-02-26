// Outer2.java
package com.jdojo.innerclasses;

public class Outer2 {
    // An instance variable for the Outer2 class 
    private int value = 1116;

    // The Inner2 class starts here 
    public class Inner2 {
        // An instance variable for Inner2 class 
        private int value = 1720;

        public void printValue() {
            System.out.println("Inner2: value = " + value);
        }
    } // The Inner2 class ends here 

    // An instance method for the Outer2 class 
    public void printValue() {
        System.out.println("Outer2: value = " + value);
    }

    // Another instance method for the Outer2 class 
    public void setValue(int newValue) {
        this.value = newValue;
    }
}
