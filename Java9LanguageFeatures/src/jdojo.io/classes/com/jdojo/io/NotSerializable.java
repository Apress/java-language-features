// NotSerializable.java
package com.jdojo.io;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class NotSerializable implements Serializable {
    // Instance variables go here
    
    private void readObject(ObjectInputStream ois)
            throws IOException, ClassNotFoundException {
        // Throw an exception
        throw new IOException("Not meant for serialization!!!");
    }

    private void writeObject(ObjectOutputStream os) throws IOException {
        // Throw an exception
        throw new IOException("Not meant for serialization!!!");
    }

    // Other code for the class goes here
}
