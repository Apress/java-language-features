// MultipleSerialization.java
package com.jdojo.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MultipleSerialization {
    public static void main(String[] args) {
        String fileName = "mutableperson.ser";

        // Write the same object twice to the stream
        serialize(fileName);

        System.out.println("--------------------------------------");

        // Read the two objects back
        deserialize(fileName);
    }

    public static void serialize(String fileName) {
        // Create a MutablePerson objects
        MutablePerson john = new MutablePerson("John", "Male", 6.7);

        File fileObject = new File(fileName);
        try (ObjectOutputStream oos
                = new ObjectOutputStream(new FileOutputStream(fileObject))) {

            // Let’s display the objects we have serialized on the console
            System.out.println("Objects are written to "
                    + fileObject.getAbsolutePath());

            // Write the john object first time to the stream
            oos.writeObject(john);
            System.out.println(john); // Display what we wrote

            // Change john object's name and height
            john.setName("John Jacobs");
            john.setHeight(6.9);

            // Write john object again with changed name and height
            oos.writeObject(john);
            System.out.println(john); // display what we wrote again
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public static void deserialize(String fileName) {
        // personmutable.ser file must exist in the current directory
        File fileObject = new File(fileName);

        try (ObjectInputStream ois
                = new ObjectInputStream(new FileInputStream(fileObject))) {

            // Read the two objects that were written in the serialize() method
            MutablePerson john1 = (MutablePerson) ois.readObject();
            MutablePerson john2 = (MutablePerson) ois.readObject();

            // Display the objects
            System.out.println("Objects are read from "
                    + fileObject.getAbsolutePath());
            System.out.println(john1);
            System.out.println(john2);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
