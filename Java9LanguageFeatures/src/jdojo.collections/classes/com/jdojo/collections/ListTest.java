// ListTest.java
package com.jdojo.collections;

import java.util.List;
import java.util.ArrayList;

public class ListTest {
    public static void main(String[] args) {
        // Create a List and add few elements  
        List<String> list = new ArrayList<>();
        list.add("John");
        list.add("Richard");
        list.add("Donna");
        list.add("Ken");

        System.out.println("List: " + list);

        int count = list.size();
        System.out.println("Size of List: " + count);

        // Print each element with its index  
        for(int i = 0; i < count; i++) {
            String element =  list.get(i);
            System.out.printf("list[%d] = %s%n", i, element);
        }

        List<String> subList = list.subList(1, 3);
        System.out.println("Sub List 1(inclusive) to 3(exclusive): " + subList);

        // Remove "Donna" from the list  
        list.remove("Donna"); // Same as list.remove(2);  
        System.out.println("List after removing Donna: " + list);
        
        // Create a List using the static factory method of()
        List<String> names = List.of("Li", "Xi", "Bo", "Da", "Fa", "Bo");
        System.out.println("List using List.of() method: " + names);        
    }
}
