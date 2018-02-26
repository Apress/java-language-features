// PushbackFileReading.java
package com.jdojo.io;

import java.io.PushbackInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PushbackFileReading {
    public static void main(String[] args) {
        String srcFile = "luci1.txt";

        try (PushbackInputStream pis
                = new PushbackInputStream(new FileInputStream(srcFile))) {

            // Read one byte at a time and display it
            byte byteData;
            while ((byteData = (byte) pis.read()) != -1) {
                System.out.print((char) byteData);

                // Unread the last byte that we have just read
                pis.unread(byteData);

                // Reread the byte we unread (or pushed back)
                byteData = (byte) pis.read();
                System.out.print((char) byteData);
            }
        } catch (FileNotFoundException e1) {
            FileUtil.printFileNotFoundMsg(srcFile);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
