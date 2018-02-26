// QualifiedThis.java
package com.jdojo.innerclasses;

public class QualifiedThis {
    // Instance variable - value 
    private int value = 828;

    public void printValue() {
        // Print value using simple name of instance variable 
        System.out.println("value = " + value);

        // Print value using keyword this 
        System.out.println("this.value = " + this.value);

        // Print value using keyword this qualified with the class name 
        System.out.println("QualifiedThis.this.value = " + QualifiedThis.this.value);
    }

    public void printHiddenValue() {
        // Declare a local variable named value, which hides the value instance variable 
        int value = 131;

        // Print value using simple name, which refers to the local variable - 131 
        System.out.println("value = " + value);

        // Print value using keyword this, which refers to the instance 
        // variable value with value 828 
        System.out.println("this.value = " + this.value);

        // Print value using keyword this qualified with the class name, 
        // which refers to instance variable value as 828 
        System.out.println("QualifiedThis.this.value = " + QualifiedThis.this.value);
    }
}
