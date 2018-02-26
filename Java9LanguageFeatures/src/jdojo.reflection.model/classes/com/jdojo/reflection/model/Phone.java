// Phone.java
package com.jdojo.reflection.model;

public class Phone {   
    private String number = "9999999999";
    
    public Phone() {        
    }
    
    public Phone(String number) {
        this.number = number;
    }
    
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    
    @Override
    public String toString() {
        return this.number;
    }
}
