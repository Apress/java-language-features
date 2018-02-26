// AclReadEntryTest.java
package com.jdojo.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclEntryPermission;
import java.nio.file.attribute.AclFileAttributeView;

public class AclReadEntryTest {
    public static void main(String[] args) {
        // Change the path to an existing file on Windows
        Path path = Paths.get("luci1.txt");

        AclFileAttributeView aclView =
                Files.getFileAttributeView(path, AclFileAttributeView.class);
        if (aclView == null) {
            System.out.format("ACL view is not supported.%n");
            return;
        }

        try {
            List<AclEntry> aclEntries = aclView.getAcl();
            for (AclEntry entry : aclEntries) {
                System.out.format("Principal: %s%n", entry.principal());
                System.out.format("Type: %s%n", entry.type());
                System.out.format("Permissions are:%n");

                Set<AclEntryPermission> permissions = entry.permissions();
                for (AclEntryPermission p : permissions) {
                    System.out.format("%s %n", p);
                }

                System.out.format("------------------------%n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
