// FileUtil.java
package com.jdojo.io;

import java.io.Closeable;
import java.io.IOException;

public class FileUtil {
    // Prints the location details of a file
    public static void printFileNotFoundMsg(String fileName) {
        String workingDir = System.getProperty("user.dir");
        System.out.println("Could not find the file '"
                + fileName + "' in '" + workingDir + "' directory ");
    }
    
    // Closes a Closeable resource such as an input/output stream
    public static void close(Closeable resource) {
        if (resource != null) {
            try {
                resource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
