// CopyTest.java
package com.jdojo.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.DirectoryNotEmptyException;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static java.nio.file.StandardCopyOption.COPY_ATTRIBUTES;

public class CopyTest {
    public static void main(String[] args) {
        // Change the paths for the source and target files
        // before you run the program
        Path source = Paths.get("C:\\poems\\luci1.txt");
        Path target = Paths.get("C:\\poems\\luci1_backup.txt");

        try {
            Path p = Files.copy(source, target,
                    REPLACE_EXISTING, COPY_ATTRIBUTES);
            System.out.println(source + " has been copied to " + p);
        } catch (FileAlreadyExistsException e) {
            System.out.println(target + " already exists.");
        } catch (DirectoryNotEmptyException e) {
            System.out.println(target + " is not empty.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
