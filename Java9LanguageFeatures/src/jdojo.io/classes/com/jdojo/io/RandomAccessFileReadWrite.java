// RandomAccessFileReadWrite.java
package com.jdojo.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileReadWrite {
    public static void main(String[] args) throws IOException {
        String fileName = "randomaccessfile.txt";
        File fileObject = new File(fileName);

        if (!fileObject.exists()) {
            initialWrite(fileName);
        }

        // Read the file twice
        readFile(fileName);
        readFile(fileName);
    }

    public static void readFile(String fileName) throws IOException {
        // Open the file in read-write mode
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            int counter = raf.readInt();
            String msg = raf.readUTF();

            System.out.println("File Read Counter: " + counter);
            System.out.println("File Text: " + msg);
            System.out.println("----------------------------");

            // Increment the file read counter by 1
            incrementReadCounter(raf);
        }
    }

    public static void incrementReadCounter(RandomAccessFile raf) throws IOException {
        // Read the current file pointer position so that we can restore it at the end
        long currentPosition = raf.getFilePointer();

        // Set the file pointer in the beginning
        raf.seek(0);

        // Read the counter and increment it by 1
        int counter = raf.readInt();
        counter++;

        // Set the file pointer to zero again to overwrite the value of the counter
        raf.seek(0);
        raf.writeInt(counter);

        // Restore the file pointer
        raf.seek(currentPosition);
    }

    public static void initialWrite(String fileName) throws IOException {
        // Write the file read counter as zero. Open the file in read-write mode.
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            // Write the file read counter as zero
            raf.writeInt(0);

            // Write a message
            raf.writeUTF("Hello world!");
        }
    }
}
