// FunctionUtilTest.java
package com.jdojo.lambda;

import static com.jdojo.lambda.Gender.MALE;
import java.util.List;

public class FunctionUtilTest {
    public static void main(String[] args) {
        List<Person> list = Person.getPersons();

        // Use the forEach() method to print each person in the list
        System.out.println("Original list of persons:");
        FunctionUtil.forEach(list, p -> System.out.println(p));

        // Filter only males
        List<Person> maleList = FunctionUtil.filter(list, p -> p.getGender() == MALE);
        
        System.out.println("\nMales only:");
        FunctionUtil.forEach(maleList, p -> System.out.println(p));

        // Map each person to his/her year of birth
        List<Integer> dobYearList = FunctionUtil.map(list, p -> p.getDob().getYear());
        
        System.out.println("\nPersons mapped to year of their birth:");
        FunctionUtil.forEach(dobYearList, year -> System.out.println(year));

        // Apply an action to each person in the list. Add one year to each male's dob
        FunctionUtil.forEach(maleList, p -> p.setDob(p.getDob().plusYears(1)));
        
        System.out.println("\nMales only after ading 1 year to DOB:");
        FunctionUtil.forEach(maleList, p -> System.out.println(p));
    }
}
