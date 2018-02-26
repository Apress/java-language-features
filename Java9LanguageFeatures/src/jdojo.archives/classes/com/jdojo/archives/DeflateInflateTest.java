// DeflateInflateTest.java
package com.jdojo.archives;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import static java.util.zip.Deflater.BEST_COMPRESSION;

public class DeflateInflateTest {
    public static void main(String[] args) throws Exception {
        String input = "Hello world!";
        byte[] uncompressedData = input.getBytes("UTF-8");

        // Compress the data 
        byte[] compressedData = compress(uncompressedData, BEST_COMPRESSION, false);

        // Decompress the data 
        byte[] decompressedData = decompress(compressedData, false);

        String output = new String(decompressedData, "UTF-8");

        // Display the statistics 
        System.out.println("Input String: " + input);
        System.out.println("Uncompressed data length: " + uncompressedData.length);
        System.out.println("Compressed data length: " + compressedData.length);
        System.out.println("Decompressed data length: " + decompressedData.length);
        System.out.println("Output String: " + output);
    }

    public static byte[] compress(byte[] input, int compressionLevel,
            boolean GZIPFormat) throws IOException {

        // Create a Deflater object to compress data 
        Deflater compressor = new Deflater(compressionLevel, GZIPFormat);

        // Set the input for the compressor 
        compressor.setInput(input);

        // Call the finish() method to indicate that we have 
        // no more input for the compressor object 
        compressor.finish();

        // Compress the data 
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        byte[] readBuffer = new byte[1024];

        while (!compressor.finished()) {
            int readCount = compressor.deflate(readBuffer);
            if (readCount > 0) {
                // Write compressed data to the output stream 
                bao.write(readBuffer, 0, readCount);
            }
        }

        // End the compressor 
        compressor.end();

        // Return the written bytes from output stream 
        return bao.toByteArray();
    }

    public static byte[] decompress(byte[] input, boolean GZIPFormat)
            throws IOException, DataFormatException {

        // Create an Inflater object to compress the data 
        Inflater decompressor = new Inflater(GZIPFormat);

        // Set the input for the decompressor 
        decompressor.setInput(input);

        // Decompress data 
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        byte[] readBuffer = new byte[1024];
        
        while (!decompressor.finished()) {
            int readCount = decompressor.inflate(readBuffer);
            if (readCount > 0) {
                // Write the data to the output stream 
                bao.write(readBuffer, 0, readCount);
            }
        }

        // End the decompressor 
        decompressor.end();

        // Return the written bytes from the output stream 
        return bao.toByteArray();
    }
}
