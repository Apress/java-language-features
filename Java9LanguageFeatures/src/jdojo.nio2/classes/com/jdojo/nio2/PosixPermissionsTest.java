// PosixPermissionsTest.java
package com.jdojo.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumSet;
import java.util.Set;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import static java.nio.file.attribute.PosixFilePermission.OWNER_READ;
import static java.nio.file.attribute.PosixFilePermission.OWNER_WRITE;
import static java.nio.file.attribute.PosixFilePermission.GROUP_READ;

public class PosixPermissionsTest {
    public static void main(String[] args) {
        Path path = Paths.get("luci");
        PosixFileAttributeView posixView =
                Files.getFileAttributeView(path, PosixFileAttributeView.class);
        if (posixView == null) {
            System.out.println("POSIX attribute view is not supported.");
            return;
        }

        readPermissions(posixView);
        updatePermissions(posixView);
    }

    public static void readPermissions(PosixFileAttributeView posixView) {
        try {
            PosixFileAttributes attribs;
            attribs = posixView.readAttributes();
            Set<PosixFilePermission> permissions = attribs.permissions();

            // Convert the set of posix file permissions into rwxrwxrwx form 
            String rwxFormPermissions = PosixFilePermissions.toString(permissions);
            System.out.println(rwxFormPermissions);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void updatePermissions(PosixFileAttributeView posixView) {
        try {
            Set<PosixFilePermission> permissions = 
                    EnumSet.of(OWNER_READ, OWNER_WRITE, GROUP_READ);
            posixView.setPermissions(permissions);
            System.out.println("Permissions set successfully.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
