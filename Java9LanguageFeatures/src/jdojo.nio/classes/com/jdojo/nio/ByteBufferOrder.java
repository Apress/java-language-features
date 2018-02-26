// ByteBufferOrder.java
package com.jdojo.nio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ByteBufferOrder {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(2);
        System.out.println("Default Byte Order: " + bb.order());
        bb.putShort((short) 300);
        bb.flip();
        showByteOrder(bb);

        // Repopulate the buffer in little endian byte order
        bb.clear();
        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.putShort((short) 300);
        bb.flip();
        showByteOrder(bb);
    }

    public static void showByteOrder(ByteBuffer bb) {
        System.out.println("Byte Order: " + bb.order());
        while (bb.hasRemaining()) {
            System.out.print(bb.get() + "  ");
        }
        System.out.println();
    }
}
