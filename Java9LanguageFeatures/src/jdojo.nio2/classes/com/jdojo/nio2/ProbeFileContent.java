// ProbeFileContent.java
package com.jdojo.nio2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class ProbeFileContent {
    public static void main(String[] args) {
        Path p = Paths.get("C:\\poems\\luci1.txt");

        try {
            String contentType = Files.probeContentType(p);
            System.out.format("Content type of %s is %s%n", p, contentType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
