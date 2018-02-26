// FileWritingWithWriter.java
package com.jdojo.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileWritingWithWriter {
    public static void main(String[] args) {
        // The output file
        String destFile = "luci4.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(destFile))) {
            // Write the text to the writer
            bw.append("And now we reach’d the orchard-plot;");
            bw.newLine();
            bw.append("And, as we climb’d the hill,");
            bw.newLine();
            bw.append("The sinking moon to Lucy’s cot");
            bw.newLine();
            bw.append("Came near and nearer still.");

            // Flush the written text
            bw.flush();

            System.out.println("Text was written to "
                    + (new File(destFile)).getAbsolutePath());
        } catch (FileNotFoundException e1) {
            FileUtil.printFileNotFoundMsg(destFile);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
