// ConstructorReflection.java
package com.jdojo.reflection;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class ConstructorReflection {
    public static void main(String[] args) {
        Class<Person> cls = Person.class;

        // Get the declared constructors              
        System.out.println("Constructors for " + cls.getName());
        Constructor[] constructors = cls.getConstructors();
        ArrayList<String> constructDescList = getConstructorsDescription(constructors);
        for (String desc : constructDescList) {
            System.out.println(desc);
        }
    }

    public static ArrayList<String> getConstructorsDescription(Constructor[] constructors) {
        ArrayList<String> constructorList = new ArrayList<>();
        for (Constructor constructor : constructors) {
            String modifiers = ExecutableUtil.getModifiers(constructor);

            // Get the name of the constructor  
            String constructorName = constructor.getName();

            // Get the parameters of the constructor  
            ArrayList<String> paramsList
                    = ExecutableUtil.getParameters(constructor);
            String params = ExecutableUtil.arrayListToString(paramsList, ",");

            // Get the Exceptions thrown by the constructor            
            String throwsClause = ExecutableUtil.getThrowsClause(constructor);

            constructorList.add(modifiers + " " + constructorName
                    + "(" + params + ") " + throwsClause);
        }

        return constructorList;
    }
}
