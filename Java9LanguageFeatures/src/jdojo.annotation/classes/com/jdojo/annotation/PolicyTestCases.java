// PolicyTestCases.java
package com.jdojo.annotation;

import java.io.IOException;

public class PolicyTestCases {
    // Must throw IOExceptionn
    @TestCase(willThrow=IOException.class)
    public static void testCase1(){
        // Code goes here
    }
    
    // We are not expecting any exception
    @TestCase()
    public static void testCase2(){
        // Code goes here
    }
}
