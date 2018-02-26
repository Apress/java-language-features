// AsyncFileReadFuture.java
package com.jdojo.nio2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.nio.ByteBuffer;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.charset.Charset;
import static java.nio.file.StandardOpenOption.READ;

public class AsyncFileReadFuture {
    public static void main(String[] args) {
        Path path = Paths.get("rainbow.txt");

        try (AsynchronousFileChannel afc = AsynchronousFileChannel.open(path, READ)) {

            // Get a data buffer of the file size to read  
            int fileSize = (int) afc.size();
            ByteBuffer dataBuffer = ByteBuffer.allocate(fileSize);

            // Perform the asynchronous read operation  
            Future<Integer> result = afc.read(dataBuffer, 0);

            System.out.println("Waiting for reading to be finished...");
            try {
                // Let us wait until reading is finished  
                int readBytes = result.get();

                System.out.format("%s bytes read from %s%n", readBytes, path);
                System.out.format("Read data is:%n");

                // Read the data from the buffer  
                byte[] byteData = dataBuffer.array();
                Charset cs = Charset.forName("UTF-8");
                String data = new String(byteData, cs);

                System.out.println(data);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
