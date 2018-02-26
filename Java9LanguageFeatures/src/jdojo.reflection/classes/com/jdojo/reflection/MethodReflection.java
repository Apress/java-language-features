// MethodReflection.java
package com.jdojo.reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class MethodReflection {
    public static void main(String[] args) {
        Class<Person> cls = Person.class;

        // Get the declared methods  
        ArrayList<String> methodsDescription = getDeclaredMethodsList(cls);
        System.out.println("Declared Methods for " + cls.getName());
        for (String desc : methodsDescription) {
            System.out.println(desc);
        }

        /* Uncomment the following code to print all methods in the Person class
        // Get the accessible public methods  
        methodsDescription = getMethodsList(c);
        System.out.println("\nMethods for " + c.getName());
        for (String desc : methodsDescription) {
            System.out.println(desc);
        }
         */
    }

    public static ArrayList<String> getMethodsList(Class c) {
        Method[] methods = c.getMethods();
        ArrayList<String> methodsList = getMethodsDescription(methods);
        return methodsList;
    }

    public static ArrayList<String> getDeclaredMethodsList(Class c) {
        Method[] methods = c.getDeclaredMethods();
        ArrayList<String> methodsList = getMethodsDescription(methods);
        return methodsList;
    }

    public static ArrayList<String> getMethodsDescription(Method[] methods) {
        ArrayList<String> methodList = new ArrayList<>();

        for (Method m : methods) {
            String modifiers = ExecutableUtil.getModifiers(m);

            // Get the method return type  
            Class returnType = m.getReturnType();
            String returnTypeName = returnType.getSimpleName();

            // Get the name of the method  
            String methodName = m.getName();

            // Get the parameters of the method  
            ArrayList<String> paramsList = ExecutableUtil.getParameters(m);
            String params = ExecutableUtil.arrayListToString(paramsList, ",");

            // Get the Exceptions thrown by method              
            String throwsClause = ExecutableUtil.getThrowsClause(m);

            methodList.add(modifiers + " " + returnTypeName + " "
                    + methodName + "(" + params + ") " + throwsClause);
        }

        return methodList;
    }
}
