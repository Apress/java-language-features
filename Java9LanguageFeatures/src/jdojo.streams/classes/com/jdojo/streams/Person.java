// Person.java
package com.jdojo.streams;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Person {
    // An enum to represent the gender of a person
    public static enum Gender {
        MALE, FEMALE
    }

    private long id;
    private String name;
    private Gender gender;
    private LocalDate dob;
    private double income;
    
    public Person(long id, String name, Gender gender, LocalDate dob, double income) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.income = income;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public boolean isMale() {
        return this.gender == Gender.MALE;
    }

    public boolean isFemale() {
        return this.gender == Gender.FEMALE;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public static List<Person> persons() {
        Person ken = new Person(1, "Ken", Gender.MALE,
                LocalDate.of(1970, Month.MAY, 4), 6000.0);
        Person jeff = new Person(2, "Jeff", Gender.MALE,
                LocalDate.of(1970, Month.JULY, 15), 7100.0);
        Person donna = new Person(3, "Donna", Gender.FEMALE,
                LocalDate.of(1962, Month.JULY, 29), 8700.0);
        Person chris = new Person(4, "Chris", Gender.MALE,
                LocalDate.of(1993, Month.DECEMBER, 16), 1800.0);
        Person laynie = new Person(5, "Laynie", Gender.FEMALE,
                LocalDate.of(2012, Month.DECEMBER, 13), 0.0);
        Person lee = new Person(6, "Li", Gender.MALE,
                LocalDate.of(2001, Month.MAY, 9), 2400.0);

        // Create a list of persons 
        List<Person> persons = List.of(ken, jeff, donna, chris, laynie, lee);

        return persons;
    }

    @Override
    public String toString() {
        String str = String.format("(%s, %s, %s, %s, %.2f)",
                id, name, gender, dob, income);
        return str;
    }
}
