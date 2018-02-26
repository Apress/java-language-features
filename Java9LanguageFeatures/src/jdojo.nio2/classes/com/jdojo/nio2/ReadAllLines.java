// ReadAllLines.java
package com.jdojo.nio2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.nio.charset.Charset;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

public class ReadAllLines {
    public static void main(String[] args) {
        Charset cs = Charset.forName("US-ASCII");
        Path source = Paths.get("luci1.txt");

        try {
            // Read all lines in one go  
            List<String> lines = Files.readAllLines(source, cs);

            // Print each line  
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (NoSuchFileException e) {
            System.out.println(source.toAbsolutePath() + " does not exist.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
