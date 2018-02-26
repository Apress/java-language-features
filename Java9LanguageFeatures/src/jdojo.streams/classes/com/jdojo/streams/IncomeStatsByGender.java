// IncomeStatsByGender.java
package com.jdojo.streams;

import java.util.DoubleSummaryStatistics;
import java.util.Map;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summarizingDouble;

public class IncomeStatsByGender {
    public static void main(String[] args) {
        Map<Person.Gender, DoubleSummaryStatistics> incomeStatsByGender = 
            Person.persons()
                  .stream()    
                  .collect(groupingBy(Person::getGender, 
                                      summarizingDouble(Person::getIncome)));

        System.out.println(incomeStatsByGender);
    }
}
