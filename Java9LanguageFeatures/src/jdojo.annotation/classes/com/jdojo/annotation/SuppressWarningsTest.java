// SuppressWarningsTest.java
package com.jdojo.annotation;

import java.util.ArrayList;

public class SuppressWarningsTest {
    @SuppressWarnings({"unchecked", "deprecation"})
    public void test() {
        ArrayList list = new ArrayList();
        list.add("Hello"); // The compiler does not issue an unchecked warning
    }
}
