// PersonDeserializationTest.java
package com.jdojo.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class PersonDeserializationTest {
    public static void main(String[] args) {
        // The input file
        File fileObject = new File("person.ser");

        try (ObjectInputStream ois
                = new ObjectInputStream(new FileInputStream(fileObject))) {

            // Read (or deserialize) the three objects
            Person john = (Person) ois.readObject();
            Person wally = (Person) ois.readObject();
            Person katrina = (Person) ois.readObject();

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
