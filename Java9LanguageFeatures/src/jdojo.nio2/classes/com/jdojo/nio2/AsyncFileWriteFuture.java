// AsyncFileWriteFuture.java
package com.jdojo.nio2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.nio.ByteBuffer;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.channels.AsynchronousFileChannel;
import static java.nio.file.StandardOpenOption.WRITE;
import static java.nio.file.StandardOpenOption.CREATE;

public class AsyncFileWriteFuture {
    public static void main(String[] args) {
        Path path = Paths.get("rainbow.txt");

        try (AsynchronousFileChannel afc
                = AsynchronousFileChannel.open(path, WRITE, CREATE)) {

            // Get the data to write in a ByteBuffer  
            ByteBuffer dataBuffer = AsyncFileWrite.getDataBuffer();

            // Perform the asynchronous write operation  
            Future<Integer> result = afc.write(dataBuffer, 0);

            // Keep polling to see if I/O has finished  
            while (!result.isDone()) {
                try {
                    // Let the thread sleep for 2 seconds 
                    // before the next polling  
                    System.out.println("Sleeping for 2 seconds...");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // I/O is complete  
            try {
                int writtenBytes = result.get();
                System.out.format("%s bytes written to %s%n",
                        writtenBytes, path.toAbsolutePath());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
