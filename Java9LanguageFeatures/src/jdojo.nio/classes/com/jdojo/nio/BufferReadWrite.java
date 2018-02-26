// BufferReadWrite.java
package com.jdojo.nio;

import java.nio.ByteBuffer;

public class BufferReadWrite {
    public static void main(String[] args) {
        // Create a byte buffer with a capacity of 8
        ByteBuffer bb = ByteBuffer.allocate(8);

        // Print the buffer info
        System.out.println("After creation:");
        printBufferInfo(bb);

        // Populate buffer elements from 50 to 57
        for (int i = 50; i < 58; i++) {
            bb.put((byte) i);
        }

        // Print the buffer info 
        System.out.println("After populating data:");
        printBufferInfo(bb);
    }

    public static void printBufferInfo(ByteBuffer bb) {
        int limit = bb.limit();
        System.out.println("Position = " + bb.position() + ", Limit = " + limit);

        // Use absolute reading without affecting the position
        System.out.print("Data: ");
        for (int i = 0; i < limit; i++) {
            System.out.print(bb.get(i) + " ");
        }
        System.out.println();
    }
}
