// CustomStdOut.java
package com.jdojo.io;

import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.File;

public class CustomStdOut {
    public static void main(String[] args) throws Exception {
        // Create a PrintStream for file stdout.txt
        File outFile = new File("stdout.txt");
        PrintStream ps = new PrintStream(new FileOutputStream(outFile));

        //Print a message on console
        System.out.println("Messages will be redirected to "
                + outFile.getAbsolutePath());

        // Set the standard out to the file
        System.setOut(ps);

        // The following messages will be sent to the stdout.txt file
        System.out.println("Hello world!");
        System.out.println("Java I/O is cool!");
    }
}
