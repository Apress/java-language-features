// JARUtility.java
package com.jdojo.archives;

import java.util.jar.Manifest;
import java.util.jar.Attributes;
import java.util.Map;
import java.util.jar.JarOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.zip.Deflater;
import java.io.BufferedOutputStream;
import java.util.jar.JarEntry;

public class JARUtility {
    public static void main(String[] args) throws Exception {
        // Create a Manifest object
        Manifest manifest = getManifest();

        // Store jar entries in a String array
        String jarFileName = "jartest.jar";
        String[] entries = new String[2];
        entries[0] = "images/logo.bmp";
        entries[1] = "com/jdojo/archives/Test.class";

        createJAR(jarFileName, entries, manifest);
    }

    public static void createJAR(String jarFileName,
            String[] jarEntries, Manifest manifest) {
        // Get the current directory for later use
        String currentDirectory = System.getProperty("user.dir");

        // Create the JAR file        
        try (JarOutputStream jos = new JarOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(jarFileName)
                ), manifest)) {

            // Set the compression level to best compression
            jos.setLevel(Deflater.BEST_COMPRESSION);

            // Add each entry to JAR file
            for (String jarEntry : jarEntries) {
                // Make sure the entry file exists
                File entryFile = new File(jarEntry);
                if (!entryFile.exists()) {
                    System.out.println("The entry file " + entryFile.getAbsolutePath()
                            + " does not exist");
                    System.out.println("Aborted processing.");
                    System.exit(1);
                }
                // Create a JarEntry object
                JarEntry je = new JarEntry(jarEntry);
                // Add jar entry object to JAR file
                jos.putNextEntry(je);
                // Add the entry's contents to the JAR file
                addEntryContent(jos, jarEntry);
                // Inform the JAR output stream that we are done 
                // working with the current entry
                jos.closeEntry();
            }

            System.out.println("Output has been written to "
                    + currentDirectory + File.separator + jarFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addEntryContent(JarOutputStream jos, String entryFileName)
            throws IOException, FileNotFoundException {

        // Create an input stream to read data from the entry file
        try (BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream(entryFileName))) {
            byte[] buffer = new byte[1024];
            int count;
            while ((count = bis.read(buffer)) != -1) {
                jos.write(buffer, 0, count);
            }
        }
    }

    public static Manifest getManifest() {
        Manifest manifest = new Manifest();

        /* Add main attributes
         1. Manifest Version
         2. Main-Class
         3. Sealed
         */
        Attributes mainAttribs = manifest.getMainAttributes();
        mainAttribs.put(Attributes.Name.MANIFEST_VERSION, "1.0");
        mainAttribs.put(Attributes.Name.MAIN_CLASS, "com.jdojo.archives.Test");
        mainAttribs.put(Attributes.Name.SEALED, "true");

        /* Add two individual sections */
 /* Do not seal the com/jdojo/archives/ package. Note that you 
           have sealed the whole JAR file and to exclude this package 
           you we must add a Sealed: false attribute for this package 
           separately. 
         */
        Map<String, Attributes> attribsMap = manifest.getEntries();

        // Create an attribute "Sealed : false" and 
        // add it for individual entry "Name: com/jdojo/archives/"
        Attributes a1 = getAttribute("Sealed", "false");
        attribsMap.put("com/jdojo/archives/", a1);

        // Create an attribute "Content-Type: image/bmp" and 
        // add it for images/logo.bmp
        Attributes a2 = getAttribute("Content-Type", "image/bmp");
        attribsMap.put("images/logo.bmp", a2);

        return manifest;
    }

    public static Attributes getAttribute(String name, String value) {
        Attributes a = new Attributes();
        Attributes.Name attribName = new Attributes.Name(name);
        a.put(attribName, value);
        return a;
    }
}
