// BadKeyTest.java
package com.jdojo.collections;

import java.util.HashSet;
import java.util.Set;

public class BadKeyTest {
    public static void main(String[] args) {
        Set<BadKey> s = new HashSet<>();
        BadKey bk1 = new BadKey(100);
        BadKey bk2 = new BadKey(200);

        // Add two objects bk1 and bk2 to the set  
        s.add(bk1);
        s.add(bk2);

        System.out.println("Set contains: " + s);
        System.out.println("Set contains bk1: " + s.contains(bk1));

        // Set the id for bk1 to 300  
        bk1.setId(300);
        System.out.println("Set contains: " + s);
        System.out.println("Set contains bk1: " + s.contains(bk1));
    }
}
