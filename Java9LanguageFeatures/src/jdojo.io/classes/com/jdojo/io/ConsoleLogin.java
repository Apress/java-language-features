// ConsoleLogin.java
package com.jdojo.io;

import java.io.Console;

public class ConsoleLogin {
    public static void main(String[] args) {
        Console console = System.console();
        if (console != null) {
            console.printf("Console is available.%n");
        } else {
            System.out.println("Console is not available.%n");
            return; // A console is not available
        }

        String userName = console.readLine("User Name: ");
        char[] passChars = console.readPassword("Password: ");
        String passString = new String(passChars);
        if (passString.equals("letmein")) {
            console.printf("Hello %s", userName);
        } else {
            console.printf("Invalid password");
        }
    }
}
