// FileWritingWithPrintStream.java
package com.jdojo.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class FileWritingWithPrintStream {
    public static void main(String[] args) {
        String destFile = "luci3.txt";

        try (PrintStream ps = new PrintStream(destFile)) {
            // Write data to the file. println() appends a new line
            // and print() does not append a new line
            ps.println("Upon the moon I fix’d my eye,");
            ps.println("All over the wide lea;");
            ps.println("With quickening pace my horse drew nigh");
            ps.print("Those paths so dear to me.");

            // flush the print stream
            ps.flush();

            System.out.println("Text has been written to "
                    + (new File(destFile).getAbsolutePath()));
        } catch (FileNotFoundException e1) {
            FileUtil.printFileNotFoundMsg(destFile);
        }
    }
}
