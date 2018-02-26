// TitleListTest.java
package com.jdojo.innerclasses;

import java.util.Iterator;

public class TitleListTest {
    public static void main(String[] args) {
        TitleList tl = new TitleList();

        // Add three titles 
        tl.addTitle("Java 9 Revealed");
        tl.addTitle("Beginning Java 9");
        tl.addTitle("Learn JavaFX 9");
        
        // Get the iterator 
        Iterator<String> iterator = tl.titleIterator();

        // Print all titles using the iterator 
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
