// FileChannelWrite.java
package com.jdojo.nio;

import java.io.File;
import java.nio.channels.FileChannel;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.io.FileOutputStream;

public class FileChannelWrite {
    public static void main(String[] args) {
        // The output file to write to 
        File outputFile = new File("luci5.txt");

        try (FileChannel fileChannel = new FileOutputStream(outputFile).getChannel()) {

            // Get the text as string
            String text = getText();

            // Convert text into byte array
            byte[] byteData = text.getBytes("UTF-8");

            // Create a ByteBuffer using the byte array
            ByteBuffer buffer = ByteBuffer.wrap(byteData);

            // Write bytes to the file
            fileChannel.write(buffer);

            System.out.println("Data has been written to " 
                    + outputFile.getAbsolutePath());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public static String getText() {
        String lineSeparator = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        sb.append("In one of those sweet dreams I slept,");
        sb.append(lineSeparator);
        sb.append("Kind Nature’s gentlest boon!");
        sb.append(lineSeparator);
        sb.append("And all the while my eyes I kept");
        sb.append(lineSeparator);
        sb.append("On the descending moon.");

        return sb.toString();
    }
}
