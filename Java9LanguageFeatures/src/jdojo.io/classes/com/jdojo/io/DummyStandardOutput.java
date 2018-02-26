// DummyStandardOutput.java
package com.jdojo.io;

import java.io.OutputStream;
import java.io.IOException;

public class DummyStandardOutput extends OutputStream {
    @Override
    public void write(int b) throws IOException {
        // Do not do anything. Swallow whatever is written
    }
}
