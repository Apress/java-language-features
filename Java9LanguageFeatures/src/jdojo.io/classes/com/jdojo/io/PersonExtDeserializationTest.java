// PersonExtDeserializationTest.java
package com.jdojo.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class PersonExtDeserializationTest {
    public static void main(String[] args) {
        // The input file
        File fileObject = new File("personext.ser");

        try (ObjectInputStream ois
                = new ObjectInputStream(new FileInputStream(fileObject))) {

            // Read (or deserialize) the three objects
            PersonExt john = (PersonExt) ois.readObject();
            PersonExt wally = (PersonExt) ois.readObject();
            PersonExt katrina = (PersonExt) ois.readObject();

            // Let’s display the objects that are read
            System.out.println(john);
            System.out.println(wally);
            System.out.println(katrina);

            // Print the input path
            System.out.println("Objects were read from "
                    + fileObject.getAbsolutePath());
        } catch (FileNotFoundException e) {
            FileUtil.printFileNotFoundMsg(fileObject.getPath());
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}
