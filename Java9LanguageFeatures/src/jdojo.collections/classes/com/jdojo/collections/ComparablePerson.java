// ComparablePerson.java
package com.jdojo.collections;

public class ComparablePerson extends Person implements Comparable<ComparablePerson> {
    public ComparablePerson(int id, String name) {
        super(id, name);
    }

    @Override
    public int compareTo(ComparablePerson cp) {        
        int cpId = cp.getId();
        String cpName = cp.getName();

        if (this.getId() < cpId) {
            return -1;
        }

        if (this.getId() > cpId) {
            return 1;
        }

        if (this.getId() == cpId) {
            return this.getName().compareTo(cpName);
        }

        // Should not reach here  
        return 0;
    }
}
