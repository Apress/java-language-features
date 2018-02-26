// LowerCaseReaderTest.java
package com.jdojo.io;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LowerCaseReaderTest {
    public static void main(String[] args) {
        String fileName = "luci4.txt";
        try (LowerCaseReader lcr
                = new LowerCaseReader(new FileReader(fileName))) {
            System.out.println("Reading luci4.txt using LowerCaseReader:");

            int c;
            while ((c = lcr.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (FileNotFoundException e) {
            FileUtil.printFileNotFoundMsg(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(
                new LowerCaseReader(new FileReader(fileName)))) {

            System.out.println("\n\nReading luci4.txt using "
                    + "LowerCaseReader and BufferedReader:");

            String str;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            FileUtil.printFileNotFoundMsg(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
