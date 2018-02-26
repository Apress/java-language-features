// AccessAnnotationTest.java
package com.jdojo.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public class AccessAnnotationTest {
    public static void main(String[] args) {
        // Read annotations on the class declaration
        Class<AccessAnnotation> cls = AccessAnnotation.class;
        System.out.println("Annotations for class: " + cls.getName());
        printAnnotations(cls);

        // Read annotations on the package declaration
        Package p = cls.getPackage();
        System.out.println("Annotations for package: " + p.getName());
        printAnnotations(p);

        // Read annotations on the methods declarations
        System.out.println("Method annotations:");
        Method[] methodList = cls.getDeclaredMethods();
        for (Method m : methodList) {
            System.out.println("Annotations for method: " + m.getName());
            printAnnotations(m);
        }
    }

    public static void printAnnotations(AnnotatedElement programElement) {
        Annotation[] annList = programElement.getAnnotations();
        for (Annotation ann : annList) {
            System.out.println(ann);
            if (ann instanceof Version) {
                Version v = (Version) ann;
                int major = v.major();
                int minor = v.minor();
                System.out.println("Found Version annotation: "
                        + "major=" + major + ", minor=" + minor);
            }
        }

        System.out.println();
    }
}
