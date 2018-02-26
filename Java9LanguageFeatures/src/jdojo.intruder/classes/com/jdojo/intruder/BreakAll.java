// BreakAll.java
package com.jdojo.intruder;

public class BreakAll {
    public static void main(String[] args) {
        try {
            TestNonExported.main(new String[0]);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        try {
            TestNonOpen.main(new String[0]);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        try {
            TestIllegalAccess.main(new String[0]);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
