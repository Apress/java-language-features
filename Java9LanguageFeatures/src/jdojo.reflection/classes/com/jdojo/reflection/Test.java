// Test.java
package com.jdojo.reflection;

import java.lang.reflect.Field;

public class Test<U extends Person> {
    static int x = 100;
    public static void main(String[] args) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException  {              
        Class<?> cls = Test.class;
        Field f = cls.getDeclaredField("x");
        f.setAccessible(true);
        int x2 = f.getInt(cls);
        System.out.println(x2);
    }
    
    public void test() {
        
    }
}
