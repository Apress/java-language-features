// VarTest.java
package com.jdojo.java10.newfeatures;

import java.util.List;
import java.util.Arrays;

public class VarTest {
    public static void main(String[] args) {
        // Inferred type of personId is int
        var personId = 1001;
        System.out.println("personID = " + personId);

        // Inferred type of prompt is String
        var prompt = "Enter a message:";
        System.out.println("prompt = " + prompt);

        // You can use methods of the String class on prompt as you did 
        // when you declared it as "String prompt = ..."
        System.out.println("prompt.length() = " + prompt.length());
        System.out.println("prompt.substring(0, 5) = " + prompt.substring(0, 5));

        // Use an explicit type name (double)
        double salary = 1878.89;
        System.out.println("salary = " + salary);

        // Inferred type of luckyNumbers is List<Integer>
        var luckyNumbers = List.of(9, 19, 1969);
        System.out.println("luckyNumbers = " + luckyNumbers);

        // Inferred type of cities is String[]
        var cities = new String[]{"Altanta", "Patna", "Paris", "Gaya"};
        System.out.println("cities = " + Arrays.toString(cities));
        System.out.println("cities.getClass() = " + cities.getClass());

        // Inferred type of the index, I, is int
        System.out.println("\nList of cities using a for loop:");
        for (var i = 0; i < cities.length; i++) {
            System.out.println(cities[i]);
        }

        // Inferred type of the index, city, is String
        System.out.println("\nList of cities using a for-each loop:");
        for (var city : cities) {
            System.out.println(city);
        }
    }
}
