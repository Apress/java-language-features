// DeleteDirectoryTest.java
package com.jdojo.nio2;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import static java.nio.file.FileVisitResult.CONTINUE;
import static java.nio.file.FileVisitResult.TERMINATE;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class DeleteDirectoryTest {
    public static void main(String[] args) {
        /* WARNING!!! 
           Replace YOUR_DIR_PATH_TO_DELETE in the following statement with 
           the path of the directory whose contents you want to delete. 
           You will not be able to get the contents of the directory back 
           after you run this program.
         */
        Path dirToDelete = Paths.get("YOUR_DIR_PATH_TO_DELETE");
        FileVisitor<Path> visitor = getFileVisitor();

        try {
            Files.walkFileTree(dirToDelete, visitor);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static FileVisitor<Path> getFileVisitor() {
        // A inner local class that is used as a file visitor to delete a directory
        class DeleteDirVisitor extends SimpleFileVisitor<Path> {
            @Override
            public FileVisitResult postVisitDirectory(Path dir,
                    IOException e) throws IOException {

                FileVisitResult result = CONTINUE;

                // Now, delete the directory at the end  
                if (e != null) {
                    System.out.format("Error deleting %s. %s%n", dir, e.getMessage());
                    result = TERMINATE;
                } else {
                    Files.delete(dir);
                    System.out.format("Deleted directory %s%n", dir);
                }
                return result;
            }

            @Override
            public FileVisitResult visitFile(Path file,
                    BasicFileAttributes attrs) throws IOException {

                // Delete the file that we are visiting  
                Files.delete(file);

                System.out.format("Deleted file %s%n", file);
                return CONTINUE;
            }
        }

        // Create an object of the DirVisitor
        FileVisitor<Path> visitor = new DeleteDirVisitor();

        return visitor;
    }
}
