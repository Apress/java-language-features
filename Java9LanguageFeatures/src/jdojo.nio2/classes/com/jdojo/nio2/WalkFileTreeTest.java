// WalkFileTreeTest.java
package com.jdojo.nio2;

import java.io.IOException;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import static java.nio.file.FileVisitResult.CONTINUE;

public class WalkFileTreeTest {
    public static void main(String[] args) {
        // Get the Path object for the default directory
        Path startDir = Paths.get("");

        // Get a file visitor object
        FileVisitor<Path> visitor = getFileVisitor();

        try {
            // Traverse the contents of the startDir
            Files.walkFileTree(startDir, visitor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static FileVisitor<Path> getFileVisitor() {
        // Declare a local class DirVisitor  that 
        // inherits fron the SimpleFileVisitor<Path> class
        class DirVisitor<Path> extends SimpleFileVisitor<Path> {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                System.out.format("%s [Directory]%n", dir);
                return CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {

                System.out.format("%s [File, Size: %s bytes]%n", file, attrs.size());
                return CONTINUE;
            }
        }

        // Create an object of the DirVisitor
        FileVisitor<Path> visitor = new DirVisitor<>();

        return visitor;
    }
}
