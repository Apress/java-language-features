// BufferedFileReading.java
package com.jdojo.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedFileReading {
    public static void main(String[] args) {
        String srcFile = "luci1.txt";

        try (BufferedInputStream bis
                = new BufferedInputStream(new FileInputStream(srcFile))) {
            // Read one byte at a time and display the read data
            byte byteData;
            while ((byteData = (byte) bis.read()) != -1) {
                System.out.print((char) byteData);
            }
        } catch (FileNotFoundException e1) {
            FileUtil.printFileNotFoundMsg(srcFile);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
