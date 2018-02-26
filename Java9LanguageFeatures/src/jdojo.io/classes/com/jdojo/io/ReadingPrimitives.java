// ReadingPrimitives.java
package com.jdojo.io;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.DataInputStream;

public class ReadingPrimitives {
    public static void main(String[] args) {
        String srcFile = "primitives.dat";

        try (DataInputStream dis = new DataInputStream(
                new FileInputStream(srcFile))) {
            // Read the data in the same order they were written
            int intValue = dis.readInt();
            double doubleValue = dis.readDouble();
            boolean booleanValue = dis.readBoolean();
            String msg = dis.readUTF();

            System.out.println(intValue);
            System.out.println(doubleValue);
            System.out.println(booleanValue);
            System.out.println(msg);
        } catch (FileNotFoundException e) {
            FileUtil.printFileNotFoundMsg(srcFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
