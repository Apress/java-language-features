// InvokeMethodTest.java
package com.jdojo.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvokeMethodTest {
    public static void main(String[] args) {
        Class<Person> personClass = Person.class;
        
        try {
            // Create an object of Person class  
            Person p = personClass.newInstance();
            
            // Print the details of the Person object
            System.out.println(p);

            // Get the reference of the setName() method  
            Method setName = personClass.getMethod("setName", String.class);

            // Invoke the setName() method on p passing passing "Ann" 
            // as the actual parameter
            setName.invoke(p, "Ann");
            
            // Print the details of the Person object
            System.out.println(p);
        } catch (InstantiationException | IllegalAccessException
                | NoSuchMethodException | SecurityException
                | IllegalArgumentException | InvocationTargetException e) {
            System.out.println(e.getMessage());
        }
    }
}
