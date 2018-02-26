// ModifiedOuter2.java
package com.jdojo.innerclasses;

public class ModifiedOuter2 {
    // An instance variable for the ModifiedOuter2 class 
    private int value = 1116;

    // The Inner class starts here 
    public class Inner {
        // An instance variable for the Inner class 
        private int value = 1720;

        public void printValue() {
            System.out.println("\nInner - printValue()...");
            System.out.println("Inner: value = " + value);
            System.out.println("Outer: value = " + ModifiedOuter2.this.value);
        }
    } // The Inner class ends here 

    // An instance method for the ModifiedOuter2 class 
    public void printValue() {
        System.out.println("\nOuter - printValue()...");
        System.out.println("Outer: value = " + value);
    }

    // Another instance method for the ModifiedOuter2 class 
    public void setValue(int newValue) {
        System.out.println("\nSetting Outer's value to " + newValue);
        this.value = newValue;
    }
}
