// FieldReflection.java
package com.jdojo.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class FieldReflection {
    public static void main(String[] args) {
        Class<Person> cls = Person.class;

        // Print declared fields 
        ArrayList<String> fieldsDescription = getDeclaredFieldsList(cls);

        System.out.println("Declared Fields for " + cls.getName());
        for (String desc : fieldsDescription) {
            System.out.println(desc);
        }

        // Get the accessible public fields  
        fieldsDescription = getFieldsList(cls);

        System.out.println("\nAccessible Fields for " + cls.getName());
        for (String desc : fieldsDescription) {
            System.out.println(desc);
        }

    }

    public static ArrayList<String> getFieldsList(Class c) {
        Field[] fields = c.getFields();
        ArrayList<String> fieldsList = getFieldsDescription(fields);
        return fieldsList;
    }

    public static ArrayList<String> getDeclaredFieldsList(Class c) {
        Field[] fields = c.getDeclaredFields();
        ArrayList<String> fieldsList = getFieldsDescription(fields);
        return fieldsList;
    }

    public static ArrayList<String> getFieldsDescription(Field[] fields) {
        ArrayList<String> fieldList = new ArrayList<>();

        for (Field f : fields) {
            // Get the modifiers for the field  
            int mod = f.getModifiers() & Modifier.fieldModifiers();
            String modifiers = Modifier.toString(mod);

            // Get the simple name of the field type  
            Class<?> type = f.getType();
            String typeName = type.getSimpleName();

            // Get the name of the field  
            String fieldName = f.getName();

            fieldList.add(modifiers + " " + typeName + " " + fieldName);
        }

        return fieldList;
    }
}
