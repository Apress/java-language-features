// TestNonOpen.java
package com.jdojo.intruder;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestNonOpen {
    public static void main(String[] args) throws Exception {
        String className = "com.jdojo.contact.Phone";

        // Get the class reference
        Class<?> cls = Class.forName(className);

        // Get the no-args constructor
        Constructor constructor = cls.getConstructor(String.class);

        // Create an Object of the Phone class
        Object phone = constructor.newInstance("2222222222");

        // Call the getPhoneNumber() method to get the phone number value
        Method getPhoneNumberRef = cls.getMethod("getPhoneNumber");
        String phoneNumber = (String) getPhoneNumberRef.invoke(phone);
        System.out.println("Using method reference, Phone: " + phoneNumber);

        // Use the private phoneNumber instance variable to read its value
        Field phoneNumberField = cls.getDeclaredField("phoneNumber");
        phoneNumberField.setAccessible(true);
        String phoneNumber2 = (String)phoneNumberField.get(phone);
        System.out.println("Using private field reference, Phone: " + phoneNumber2);
    }
}
