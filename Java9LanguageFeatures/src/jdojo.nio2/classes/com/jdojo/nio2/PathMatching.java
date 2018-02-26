// PathMatching.java
package com.jdojo.nio2;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class PathMatching {
    public static void main(String[] args) {
        String globPattern = "glob:**txt";
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(globPattern);
        Path path = Paths.get("C:\\Java9LanguageFeatures\\luci1.txt");
        boolean matched = matcher.matches(path);
        System.out.format("%s matches %s: %b%n", globPattern, path, matched);
    }
}
