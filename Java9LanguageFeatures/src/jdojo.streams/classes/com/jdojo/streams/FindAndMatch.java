// FindAndMatch.java
package com.jdojo.streams;

import java.util.List;
import java.util.Optional;

public class FindAndMatch {
public static void main(String[] args) {
        // Get the list of persons
        List<Person> persons = Person.persons();
        
        // Check if all persons are males
        boolean allMales = persons.stream()
                                  .allMatch(Person::isMale);
        System.out.println("All males: " + allMales);
        
        // Check if any person was born in 1970
        boolean anyoneBornIn1970 =  persons.stream()
                                           .anyMatch(p -> p.getDob().getYear() == 1970);
        System.out.println("Anyone born in 1970: " + anyoneBornIn1970);
        
        // Check if any person was born in 1955
        boolean anyoneBornIn1955 = persons.stream()
                                          .anyMatch(p -> p.getDob().getYear() == 1955);
        System.out.println("Anyone born in 1955: " + anyoneBornIn1955);
        
        // Find any male
        Optional<Person> anyMale = persons.stream()
                                          .filter(Person::isMale)
                                          .findAny();
        if (anyMale.isPresent()) {
            System.out.println("Any male: " + anyMale.get());
        } else {
            System.out.println("No male found.");
        }
        
        // Find the first male
        Optional<Person> firstMale = persons.stream()
                                            .filter(Person::isMale)
                                            .findFirst();
        if (firstMale.isPresent()) {
            System.out.println("First male: " + anyMale.get());
        } else {
            System.out.println("No male found.");
        }
    }
}
