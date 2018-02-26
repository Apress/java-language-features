// InvokeConstructorTest.java
package com.jdojo.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class InvokeConstructorTest {
    public static void main(String[] args) {
        Class<Person> personClass = Person.class;
        
        try {
            // Get the constructor "Person(int, String)"  
            Constructor<Person> cons = personClass.getConstructor(int.class, String.class);

            // Invoke the constructor with values for id and name  
            Person chris = cons.newInstance(1994, "Chris");
            System.out.println(chris);
        } catch (NoSuchMethodException | SecurityException
                | InstantiationException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException e) {
            System.out.println(e.getMessage());
        }
    }
}
