// InnerClassFile.java
package com.jdojo.innerclasses;

public class InnerClassFile {
    public class MemberInnerClass {
    }

    public static class NestedClass {
    }

    public void testMethod1() {
        // A local class 
        class LocalInnerClass {
            // A local class 
            class LocalInnerClass2 {
            }
        }

        // A local class 
        class AnotherLocalInnerClass {
        }

        // Anonymous Inner class 
        new Object() {
        };
    }

    public void testMethod2() {
        // A local class. Its name is the same as a local class in testMethod1() method 
        class AnotherLocalInnerClass {
        }

        // Another local class 
        class TestLocalClass {
        }
    }
}
