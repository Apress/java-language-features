// Person.java
package com.jdojo.collections;

public class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person)) {
            return false;
        }

        // id must be the same for two Persons to be equal  
        Person p = (Person) o;
        
        return this.id == p.getId();
    }

    @Override
    public int hashCode() {
        // A trivial implementation        
        return this.id;
    }

    @Override
    public String toString() {
        return "(" + id + ", " + name + ")";
    }
}
