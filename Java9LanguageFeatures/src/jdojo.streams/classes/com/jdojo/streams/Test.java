// Test.java
package com.jdojo.streams;

import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        Map<Person.Gender, Long> countByGender = Person.persons()
                .stream()                
                .collect(Collectors.toMap(Person::getGender, p -> 1L,
                        (oldCount, newCount) -> oldCount + 1));

        System.out.println(countByGender);

    }
}
