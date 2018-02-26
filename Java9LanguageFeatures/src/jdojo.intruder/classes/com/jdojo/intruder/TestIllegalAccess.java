// TestIllegalAccess.java
package com.jdojo.intruder;

import java.lang.reflect.Field;

public class TestIllegalAccess {
    public static void main(String[] args) throws Exception {
        Long id = 1969L;        
        Class<Long> cls = Long.class;
        Field valueField = cls.getDeclaredField("value");
        valueField.setAccessible(true);
        
        // Read the value in the Long variable using its private field value
        long idValue = (long) valueField.get(id);
        System.out.println("Long.value = " + idValue);
        
        // Read the value in the Long variable using its private field value
        valueField.set(id, 1968L);
        
        // Read the value in the Long variable using its private field value
        idValue = (long) valueField.get(id);
        System.out.println("Long.value = " + idValue);
    }
}
