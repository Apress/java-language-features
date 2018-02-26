// AvailableCharsets.java
package com.jdojo.nio;

import java.util.Map;
import java.nio.charset.Charset;
import java.util.Set;

public class AvailableCharsets {
    public static void main(String[] args) {
        Map<String, Charset> map = Charset.availableCharsets();
        Set<String> keys = map.keySet();
        System.out.println("Available Character Set Count: " + keys.size());

        for(String charsetName : keys) {
            System.out.println(charsetName);
        }
    }
}
