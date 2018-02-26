// Test.java
package com.jdojo.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


public class Test {
    static final String str = "My Dear";

    @Target({ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.MODULE, ElementType.PACKAGE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface MyName {
        String first();

        String last();
        Class<?> willThrow() default DefaultException.class;
    }
    
    public static void main(String[] args) throws NoSuchMethodException {

        Annotation[] list = Test.class.getMethod("test").getAnnotations();
        for (Annotation a : list) {
            Class cls = a.getClass();
            Class cls2 = a.annotationType();
            System.out.println(cls + " " + cls.isSynthetic());
            System.out.println(cls2);
            System.out.println(((MyName)a).first());
        }
    }
    
    @MyName(first = "Hello" + Test.str, last = "Kishori")
    public static void test() {
    }
}
