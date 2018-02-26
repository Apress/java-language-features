// Person.java
package com.jdojo.io;

import java.io.Serializable;

public class Person implements Serializable {
    private String name = "Unknown";
    private String gender = "Unknown";
    private double height = Double.NaN;

    public Person(String name, String gender, double height) {
        this.name = name;
        this.gender = gender;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", Gender: " + this.gender
                + ", Height: " + this.height;
    }
}
