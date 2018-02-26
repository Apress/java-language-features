// CharEncoderDecoder.java
package com.jdojo.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;

public class CharEncoderDecoder {
    public static void main(String[] args) throws Exception {
        DataSourceSink dss = new DataSourceSink();

        // Display the text we are going to encode 
        System.out.println("Original Text:");
        System.out.println(dss.getText());
        System.out.println("--------------------");

        // Encode the text using UTF-8 encoding. We will store 
        // encoded bytes in the dss object during the encoding process 
        encode(dss, "UTF-8");

        // Decode bytes stored in the dss object using UTF-8 encoding 
        System.out.println("Decoded Text:");
        decode(dss, "UTF-8");
    }

    public static void encode(DataSourceSink ds, String charset) {
        CharsetEncoder encoder = Charset.forName(charset).newEncoder();

        CharBuffer input = CharBuffer.allocate(8);
        ByteBuffer output = ByteBuffer.allocate(8);

        // Initialize variables for loop 
        boolean endOfInput = false;
        CoderResult result = CoderResult.UNDERFLOW;

        while (!endOfInput) {
            if (result == CoderResult.UNDERFLOW) {
                input.clear();
                endOfInput = (ds.getCharData(input) == -1);
                input.flip();
            }

            // Encode the input characters 
            result = encoder.encode(input, output, endOfInput);

            // Drain output when
            // 1. It is an overflow. Or,
            // 2. It is an underflow and it is the end of the input 
            if (result == CoderResult.OVERFLOW
                    || (endOfInput && result == CoderResult.UNDERFLOW)) {
                output.flip();
                ds.storeByteData(output);
                output.clear();
            }
        }

        // Flush the internal state of the encoder
        while (true) {
            output.clear();
            result = encoder.flush(output);
            output.flip();
            if (output.hasRemaining()) {
                ds.storeByteData(output);
                output.clear();
            }

            // Underflow means flush() method has flushed everything 
            if (result == CoderResult.UNDERFLOW) {
                break;
            }
        }
    }

    public static void decode(DataSourceSink dss, String charset) {
        CharsetDecoder decoder = Charset.forName(charset).newDecoder();
        ByteBuffer input = ByteBuffer.allocate(8);
        CharBuffer output = CharBuffer.allocate(8);

        boolean endOfInput = false;
        CoderResult result = CoderResult.UNDERFLOW;

        while (!endOfInput) {
            if (result == CoderResult.UNDERFLOW) {
                input.clear();
                endOfInput = (dss.getByteData(input) == -1);
                input.flip();
            }

            // Decode the input bytes 
            result = decoder.decode(input, output, endOfInput);

            // Drain output when 
            // 1. It is an overflow. Or,
            // 2. It is an underflow and it is the end of the input              
            if (result == CoderResult.OVERFLOW
                    || (endOfInput && result == CoderResult.UNDERFLOW)) {

                output.flip();
                while (output.hasRemaining()) {
                    System.out.print(output.get());
                }
                output.clear();
            }
        }

        // Flush the internal state of the decoder
        while (true) {
            output.clear();
            result = decoder.flush(output);
            output.flip();
            while (output.hasRemaining()) {
                System.out.print(output.get());
            }

            if (result == CoderResult.UNDERFLOW) {
                break;
            }
        }
    }
}
