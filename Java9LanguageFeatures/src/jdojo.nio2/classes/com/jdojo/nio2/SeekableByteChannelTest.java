// SeekableByteChannelTest.java
package com.jdojo.nio2;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import static java.nio.file.StandardOpenOption.READ;
import static java.nio.file.StandardOpenOption.WRITE;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

public class SeekableByteChannelTest {
    public static void main(String[] args) {
        Path src = Paths.get("twinkle2.txt");

        // Get the file encoding for the system  
        String encoding = System.getProperty("file.encoding");
        Charset cs = Charset.forName(encoding);

        try (SeekableByteChannel seekableChannel
                = Files.newByteChannel(src, READ, WRITE, CREATE, TRUNCATE_EXISTING)) {

            // Print the details  
            printDetails(seekableChannel, "Before writing data");

            // First, write some data to the file  
            writeData(seekableChannel, cs);

            // Print the details  
            printDetails(seekableChannel, "After writing data");

            // Reset the position of the seekable channel to 0, 
            // so we can read the data from the beginning  
            seekableChannel.position(0);

            // Print the details  
            printDetails(seekableChannel, "After resetting position to 0");

            // Read the data from the file  
            readData(seekableChannel, cs);

            // Print the details  
            printDetails(seekableChannel, "After reading data");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeData(SeekableByteChannel seekableChannel,
            Charset cs) throws IOException {
        // Get the platform-dependent line separator
        String separator = System.getProperty("line.separator");

        // Prepare the text to write to the file  
        StringBuilder sb = new StringBuilder();
        sb.append("When the blazing sun is gone,");
        sb.append(separator);
        sb.append("When he nothing shines upon,");
        sb.append(separator);
        sb.append("Then you show your little light,");
        sb.append(separator);
        sb.append("Twinkle, twinkle, all the night");
        sb.append(separator);

        // Wrap the text into a char buffer  
        CharBuffer charBuffer = CharBuffer.wrap(sb);

        // Encode the char buffer data into a byte buffer  
        ByteBuffer byteBuffer = cs.encode(charBuffer);

        // Write the data to the file  
        seekableChannel.write(byteBuffer);
    }

    public static void readData(SeekableByteChannel seekableChannel,
            Charset cs) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(128);
        String encoding = System.getProperty("file.encoding");

        while (seekableChannel.read(byteBuffer) > 0) {
            byteBuffer.rewind();
            CharBuffer charBuffer = cs.decode(byteBuffer);
            System.out.print(charBuffer);
            byteBuffer.flip();
        }
    }

    public static void printDetails(SeekableByteChannel seekableChannel, String msg) {
        try {
            System.out.println(msg + ": Size = " + seekableChannel.size()
                    + ", Position = " + seekableChannel.position());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
