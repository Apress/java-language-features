// Test.java
package com.jdojo.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws FileNotFoundException, IOException {
       File tempDir = new File("C:\\kishori\\temp");
       File tempFile = File.createTempFile("kkk", ".txt", tempDir);
       System.out.println(tempFile);
    }
}
