// DataSourceSink.java
package com.jdojo.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class DataSourceSink {
    private CharBuffer cBuffer = null;
    private ByteBuffer bBuffer = null;

    public DataSourceSink() {
        String text = this.getText();
        cBuffer = CharBuffer.wrap(text);
    }

    public int getByteData(ByteBuffer buffer) {
        if (!bBuffer.hasRemaining()) {
            return -1;
        }

        int count = 0;
        while (bBuffer.hasRemaining() && buffer.hasRemaining()) {
            buffer.put(bBuffer.get());
            count++;
        }
        return count;
    }

    public int getCharData(CharBuffer buffer) {
        if (!cBuffer.hasRemaining()) {
            return -1;
        }

        int count = 0;
        while (cBuffer.hasRemaining() && buffer.hasRemaining()) {
            buffer.put(cBuffer.get());
            count++;
        }

        return count;
    }

    public void storeByteData(ByteBuffer byteData) {
        if (this.bBuffer == null) {
            int total = byteData.remaining();
            this.bBuffer = ByteBuffer.allocate(total);
            while (byteData.hasRemaining()) {
                this.bBuffer.put(byteData.get());
            }
            this.bBuffer.flip();
        } else {
            this.bBuffer = this.appendContent(byteData);
        }
    }

    private ByteBuffer appendContent(ByteBuffer content) {
        // Create a new buffer to accommodate new data 
        int count = bBuffer.limit() + content.remaining();
        ByteBuffer newBuffer = ByteBuffer.allocate(count);

        // Set the position of bBuffer that has some data 
        bBuffer.clear();
        newBuffer.put(bBuffer);
        newBuffer.put(content);
        bBuffer.clear();
        newBuffer.clear();
        return newBuffer;
    }

    public final String getText() {
        String newLine = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        sb.append("My horse moved on; hoof after hoof");
        sb.append(newLine);
        sb.append("He raised, and never stopped:");
        sb.append(newLine);
        sb.append("When down behind the cottage roof,");
        sb.append(newLine);
        sb.append("At once, the bright moon dropped.");

        return sb.toString();
    }
}
