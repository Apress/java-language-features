// BasicFileAttributeViewTest.java
package com.jdojo.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;

public class BasicFileAttributeViewTest {
    public static void main(String[] args) {
        // Change the path to point to your file
        Path path = Paths.get("luci1.txt");

        try {
            // Get the basic view  
            BasicFileAttributeView bfv
                    = Files.getFileAttributeView(path, BasicFileAttributeView.class);

            // Read all basic attributes through the view  
            BasicFileAttributes bfa = bfv.readAttributes();

            // Print some basic attributes  
            System.out.format("Size: %s bytes %n", bfa.size());
            System.out.format("Creation Time: %s %n", bfa.creationTime());
            System.out.format("Last Access Time: %s %n", bfa.lastAccessTime());

            // Update the create time to the current time  
            FileTime newLastModifiedTime = null;
            FileTime newLastAccessTime = null;
            FileTime newCreateTime = FileTime.from(Instant.now());

            // A null for time means you do not want to update that time  
            bfv.setTimes(newLastModifiedTime, newLastAccessTime, newCreateTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
