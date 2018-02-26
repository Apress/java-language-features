// ClassReflection.java
package com.jdojo.reflection;

import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;

public class ClassReflection {
    public static void main(String[] args) {
        // Print the declaration of the Person class
        String clsDecl = getClassDescription(Person.class);
        System.out.println(clsDecl);

        // Print the declaration of the Class class
        clsDecl = getClassDescription(Class.class);
        System.out.println(clsDecl);

        // Print the declaration of the Runnable interface
        clsDecl = getClassDescription(Runnable.class);
        System.out.println(clsDecl);

        // Print the declaration of the class representing the int data type
        clsDecl = getClassDescription(int.class);
        System.out.println(clsDecl);
    }

    public static String getClassDescription(Class<?> cls) {
        StringBuilder classDesc = new StringBuilder();

        // Prepare the modifiers and construct keyword (class, enum, interface etc.)
        int modifierBits = 0;
        String keyword = "";

        // Add keyword @interface, interface or class
        if (cls.isPrimitive()) {
            // We do not want to add anything  
        } else if (cls.isInterface()) {
            modifierBits = cls.getModifiers() & Modifier.interfaceModifiers();

            // An annotation is an interface
            if (cls.isAnnotation()) {
                keyword = "@interface";
            } else {
                keyword = "interface";
            }
        } else if (cls.isEnum()) {
            modifierBits = cls.getModifiers() & Modifier.classModifiers();
            keyword = "enum";
        } else {
            modifierBits = cls.getModifiers() & Modifier.classModifiers();
            keyword = "class";
        }

        // Convert modifiers to their string represenation  
        String modifiers = Modifier.toString(modifierBits);

        // Append modifiers
        classDesc.append(modifiers);

        // Append the construct keyword
        classDesc.append(" ");
        classDesc.append(keyword);

        // Append simple name                
        String simpleName = cls.getSimpleName();
        classDesc.append(" ");
        classDesc.append(simpleName);

        // Append generic parameters
        String genericParms = getGenericTypeParams(cls);
        classDesc.append(genericParms);

        // Append super class  
        Class superClass = cls.getSuperclass();
        if (superClass != null) {
            String superClassSimpleName = superClass.getSimpleName();
            classDesc.append(" extends ");
            classDesc.append(superClassSimpleName);
        }

        // Append Interfaces  
        String interfaces = ClassReflection.getClassInterfaces(cls);
        if (interfaces != null) {
            classDesc.append(" implements ");
            classDesc.append(interfaces);
        }

        return classDesc.toString().trim();
    }

    public static String getClassInterfaces(Class<?> cls) {
        // Get a comma-separated list of interfaces implemented by the class
        Class<?>[] interfaces = cls.getInterfaces();
        if (interfaces.length == 0) {
            return null;
        }

        String[] names = new String[interfaces.length];
        for (int i = 0; i < interfaces.length; i++) {
            names[i] = interfaces[i].getSimpleName();
        }

        String interfacesList = String.join(", ", names);
        return interfacesList;
    }

    public static String getGenericTypeParams(Class<?> cls) {
        StringBuilder sb = new StringBuilder();
        TypeVariable<?>[] typeParms = cls.getTypeParameters();

        if (typeParms.length == 0) {
            return "";
        }

        String[] paramNames = new String[typeParms.length];
        for (int i = 0; i < typeParms.length; i++) {
            paramNames[i] = typeParms[i].getTypeName();
        }

        sb.append('<');
        String parmsList = String.join(",", paramNames);
        sb.append(parmsList);
        sb.append('>');

        return sb.toString();
    }
}
