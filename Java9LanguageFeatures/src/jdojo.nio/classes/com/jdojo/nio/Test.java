// Test.java
package com.jdojo.nio;

import java.nio.IntBuffer;

public class Test {
    public static void main(String[] args) {
        // Create an IntBuffer
        IntBuffer data = IntBuffer.allocate(1);
        System.out.println(data.isReadOnly());

        // Get a read-only copy of the IntBuffer
        IntBuffer copy = data.asReadOnlyBuffer();
        System.out.println(copy.isReadOnly());

        // Print the contents of the read-only buffer
        System.out.println(copy.get());

        // Write into the original bufffer
        data.put(64);

        // Print the contents of the read-only buffer         
        copy.rewind();
        System.out.println(copy.get());
    }
}
