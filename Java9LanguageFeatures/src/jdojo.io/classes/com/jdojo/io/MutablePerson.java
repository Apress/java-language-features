// MutablePerson.java
package com.jdojo.io;

import java.io.Serializable;

public class MutablePerson implements Serializable {
    private String name = "Unknown";
    private String gender = "Unknown";
    private double height = Double.NaN;

    public MutablePerson(String name, String gender, double height) {
        this.name = name;
        this.gender = gender;
        this.height = height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", Gender: " + this.gender
                + ", Height: " + this.height;
    }
}
