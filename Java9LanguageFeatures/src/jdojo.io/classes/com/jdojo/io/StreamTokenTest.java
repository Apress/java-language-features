// StreamTokenTest.java
package com.jdojo.io;

import java.io.StreamTokenizer;
import static java.io.StreamTokenizer.*;
import java.io.StringReader;
import java.io.IOException;

public class StreamTokenTest {
    public static void main(String[] args) throws Exception {
        String str = "This is a test, 200.89 which is simple 50";
        StringReader sr = new StringReader(str);
        StreamTokenizer st = new StreamTokenizer(sr);

        try {
            while (st.nextToken() != TT_EOF) {
                switch (st.ttype) {
                    case TT_WORD:
                        /* a word has been read */
                        System.out.println("String value: "
                                + st.sval);
                        break;
                    case TT_NUMBER:
                        /* a number has been read */
                        System.out.println("Number value: "
                                + st.nval);
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
