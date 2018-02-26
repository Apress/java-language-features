// AsyncFileRead.java
package com.jdojo.nio2;

import java.nio.ByteBuffer;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.channels.CompletionHandler;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.charset.Charset;
import static java.nio.file.StandardOpenOption.READ;

public class AsyncFileRead {
    // Used as an attachment to the CompletionHandler  
    private static class Attachment {
        public Path path;
        public ByteBuffer buffer;
        public AsynchronousFileChannel asyncChannel;
    }

    // An inner class to handle completion of the asynchronous read operation  
    private static class ReadHandler implements CompletionHandler<Integer, Attachment> {
        @Override
        public void completed(Integer result, Attachment attach) {
            System.out.format("%s bytes read from %s%n", result, attach.path);
            System.out.format("Read data is:%n");

            byte[] byteData = attach.buffer.array();
            Charset cs = Charset.forName("UTF-8");
            String data = new String(byteData, cs);
            System.out.println(data);

            try {
                // Close the channel  
                attach.asyncChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void failed(Throwable e, Attachment attach) {
            System.out.format("Read operation on %s file failed."
                    + " The error is: %s%n",
                    attach.path, e.getMessage());

            try {
                // Close the channel  
                attach.asyncChannel.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Path path = Paths.get("rainbow.txt");
        try {
            // Get an async channel
            AsynchronousFileChannel afc = AsynchronousFileChannel.open(path, READ);

            // Get a completion handler  
            ReadHandler handler = new ReadHandler();

            // Get the data size in bytes to read  
            int fileSize = (int) afc.size();
            ByteBuffer dataBuffer = ByteBuffer.allocate(fileSize);

            // Prepare the attachment  
            Attachment attach = new Attachment();
            attach.asyncChannel = afc;
            attach.buffer = dataBuffer;
            attach.path = path;

            // Perform the asynchronous read operation  
            afc.read(dataBuffer, 0, attach, handler);

            try {
                // Let the thread sleep for five seconds, 
                // to allow the asynchronous read to complete  
                System.out.println("Sleeping for 5 seconds...");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Done...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
