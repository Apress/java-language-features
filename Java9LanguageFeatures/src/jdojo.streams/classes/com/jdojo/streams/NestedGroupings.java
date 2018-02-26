// NestedGroupings.java
package com.jdojo.streams;

import java.time.Month;
import java.util.Map;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.joining;

public class NestedGroupings {
    public static void main(String[] args) {
        Map<Person.Gender, Map<Month, String>> personsByGenderAndDobMonth
            = Person.persons()
                    .stream()
                    .collect(groupingBy(Person::getGender,
                             groupingBy(p -> p.getDob().getMonth(),
                             mapping(Person::getName, joining(", ")))));

        System.out.println(personsByGenderAndDobMonth);
    }
}
