// MachineByteOrder.java
package com.jdojo.nio;

import java.nio.ByteOrder;

public class MachineByteOrder {
    public static void main(String args[]) {
        ByteOrder b = ByteOrder.nativeOrder();
        if (b.equals(ByteOrder.BIG_ENDIAN)) {
            System.out.println("Big endian");
        } else {
            System.out.println("Little endian");
        }
    }
}
