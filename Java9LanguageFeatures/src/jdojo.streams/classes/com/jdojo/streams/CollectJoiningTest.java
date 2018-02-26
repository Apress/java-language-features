// CollectJoiningTest.java
package com.jdojo.streams;

import java.util.List;
import java.util.stream.Collectors;

public class CollectJoiningTest {
    public static void main(String[] args) {
        List<Person> persons = Person.persons();
        String names = persons.stream()
                              .map(Person::getName)
                              .collect(Collectors.joining());

        String delimitedNames = persons.stream()
                                       .map(Person::getName)
                                       .collect(Collectors.joining(", "));

        String prefixedNames = persons.stream()
            .map(Person::getName)
            .collect(Collectors.joining(", ", "Hello ", ". Goodbye."));

        System.out.println("Joined names: " + names);
        System.out.println("Joined, delimited names: " + delimitedNames);
        System.out.println(prefixedNames);
    }
}
