// Test.java
package com.jdojo.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;

public class Test {
    public static void main(String[] args) throws IOException {
        Path p = Paths.get("");
        FileTime ft = Files.getLastModifiedTime(p);
        System.out.println(ft);
    }
}
