// WriteLinesTest.java
package com.jdojo.nio2;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import static java.nio.file.StandardOpenOption.WRITE;
import static java.nio.file.StandardOpenOption.CREATE;

public class WriteLinesTest {
    public static void main(String[] args) {
        // Prepare the lines of text to write in a List  
        List<String> texts = new ArrayList<>();
        texts.add("Twinkle, twinkle, little star,");
        texts.add("How I wonder what you are.");
        texts.add("Up above the world so high,");
        texts.add("Like a diamond in the sky.");

        Path dest = Paths.get("twinkle.txt");
        Charset cs = Charset.forName("US-ASCII");
        try {
            Path p = Files.write(dest, texts, cs, WRITE, CREATE);
            System.out.println("Text was written to "
                    + p.toAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
