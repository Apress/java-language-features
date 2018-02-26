// HelloAnonymous.java
package com.jdojo.innerclasses;

public class HelloAnonymous {
    public static void main(String[] args) {
        new Object() {
            // An instance initializer 
            {
                System.out.println ("Hello from an anonymous class.");
            }
        }; // A semicolon is necessary to end the statement 
    }
}
