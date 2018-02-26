// RootList.java
package com.jdojo.io;

import java.io.File;

public class RootList {
    public static void main(String[] args) {
        File[] roots = File.listRoots();
        System.out.println("List of root directories:");
        for (File f : roots) {
            System.out.println(f.getPath());
        }
    }
}
