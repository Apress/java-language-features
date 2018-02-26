// FileOwnerManagement.java
package com.jdojo.nio2;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalLookupService;

public class FileOwnerManagement {
    public static void main(String[] args) throws IOException {
        try {
            // Change the file path to an existing file on your machine
            Path path = Paths.get("luci1.txt");

            FileOwnerAttributeView foav
                    = Files.getFileAttributeView(path, FileOwnerAttributeView.class);

            UserPrincipal owner = foav.getOwner();
            System.out.format("Original owner of %s is %s%n", path, owner.getName());

            FileSystem fs = FileSystems.getDefault();
            UserPrincipalLookupService upls = fs.getUserPrincipalLookupService();

            // Change the file owner to brice  
            UserPrincipal newOwner = upls.lookupPrincipalByName("brice");
            foav.setOwner(newOwner);

            UserPrincipal changedOwner = foav.getOwner();
            System.out.format("New owner of %s is %s%n", path, changedOwner.getName());
        } catch (UnsupportedOperationException | IOException e) {
            e.printStackTrace();
        }
    }
}
