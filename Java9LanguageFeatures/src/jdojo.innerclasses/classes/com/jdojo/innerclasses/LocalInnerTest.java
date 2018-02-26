// LocalInnerTest.java
package com.jdojo.innerclasses;

public class LocalInnerTest {
    public static void main(String[] args) {
        // Generate random integers using the RandomInteger class 
        RandomInteger rTop = new RandomInteger();
        System.out.println("Random integers using a top-level class:");
        System.out.println(rTop.getValue());
        System.out.println(rTop.getValue());
        System.out.println(rTop.getValue());

        // Generate random integers using the RandomIntegerLocal class 
        RandomLocal local = new RandomLocal();
        RandomInteger rLocal = local.getRandomInteger();

        System.out.println("\nRandom integers using a local inner class:");
        System.out.println(rLocal.getValue());
        System.out.println(rLocal.getValue());
        System.out.println(rLocal.getValue());
    }
}
