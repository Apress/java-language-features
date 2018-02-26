// IllegalAccess1.java
package com.jdojo.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class IllegalAccess3 {
    public static void main(String[] args) throws Exception {
        // Get the class reference for the Phone class
        String className = "com.jdojo.reflection.model.Phone";
        Class<?> cls = Class.forName(className);

        // Create a Phone object
        Constructor<?> cons = cls.getConstructor();
        Object phone = cons.newInstance();

        // Get the reference of the number field
        Field numberField = cls.getDeclaredField("number");

        // try making the number field accessible before accessing it        
        boolean accessEnabled = numberField.trySetAccessible();

        if (accessEnabled) {
            // Try accessing the number field by reading its value
            String number = (String) numberField.get(phone);

            // Print the phone number
            System.out.println("number=" + number);
        } else {
            System.out.println("The Phone.number field is not accessible.");
        }
    }
}
