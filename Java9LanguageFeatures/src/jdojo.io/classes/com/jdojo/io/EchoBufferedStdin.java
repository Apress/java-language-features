// EchoBufferedStdin.java
package com.jdojo.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class EchoBufferedStdin {
    public static void main(String[] args) throws IOException {
        // Get a BufferedReader, which wraps the System.in object. Note the use 
        // of InputStreamReader, the bridge class between the byte-based and
        // the character-based stream
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String text;
        while (true) {
            // Prompt user to type some text
            System.out.print("Please type a message (Q/q to quit) "
                    + "and press enter: ");

            // Read the text
            text = br.readLine();
            if (text.equalsIgnoreCase("q")) {
                System.out.println("You have decided to exit the program");
                break;
            } else {
                System.out.println("You typed: " + text);
            }
        }
    }
}
