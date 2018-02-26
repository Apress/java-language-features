// SwallowOutput.java
package com.jdojo.io;

import java.io.PrintStream;

public class SwallowOutput {
    public static void main(String[] args) {
        PrintStream ps = new PrintStream(new DummyStandardOutput());

        // Set the dummy standard output
        System.setOut(ps);

        // The following messages are not going anywhere
        System.out.println("Hello world!");
        System.out.println("Is someone listening?");
        System.out.println("No. We are all taking a nap!!!");
    }
}
