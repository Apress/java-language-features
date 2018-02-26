// Test.java
package com.jdojo.stackwalker;

public class Test {
    public static void main(String[] args) {
        StackWalker.getInstance()
                 .forEach(frame -> System.out.println(frame.getClassName()));
        
    }
}
