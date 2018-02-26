// AsyncFileWrite.java
package com.jdojo.nio2;

import java.nio.ByteBuffer;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.channels.CompletionHandler;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.charset.Charset;
import static java.nio.file.StandardOpenOption.WRITE;
import static java.nio.file.StandardOpenOption.CREATE;

public class AsyncFileWrite {
    // Used as an attachment to the CompletionHandler  
    private static class Attachment {
        public Path path;
        public ByteBuffer buffer;
        public AsynchronousFileChannel asyncChannel;
    }

    // An inner class to handle completion of the asynchronous write operation  
    private static class WriteHandler implements CompletionHandler<Integer, Attachment> {
        @Override
        public void completed(Integer result, Attachment attach) {
            System.out.format("%s bytes written to %s%n",
                    result, attach.path.toAbsolutePath());

            try {
                // Close the channel  
                attach.asyncChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void failed(Throwable e, Attachment attach) {
            System.out.format("Write operation on %s file failed."
                    + " The error is:  %s%n", attach.path, e.getMessage());
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
            AsynchronousFileChannel afc = 
                    AsynchronousFileChannel.open(path, WRITE, CREATE);

            // Get a completion handler  
            WriteHandler handler = new WriteHandler();

            // Get the data to write in a ByteBuffer  
            ByteBuffer dataBuffer = getDataBuffer();

            // Prepare the attachment  
            Attachment attach = new Attachment();
            attach.asyncChannel = afc;
            attach.buffer = dataBuffer;
            attach.path = path;

            // Perform the asynchronous write operation  
            afc.write(dataBuffer, 0, attach, handler);

            try {
                // Let the thread sleep for 5 seconds, 
                // to allow the asynchronous write is complete  
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

    public static ByteBuffer getDataBuffer() {
        String lineSeparator = System.getProperty("line.separator");

        StringBuilder sb = new StringBuilder();
        sb.append("My heart leaps up when I behold");
        sb.append(lineSeparator);
        sb.append("A Rainbow in the sky");
        sb.append(lineSeparator);
        sb.append(lineSeparator);
        sb.append("So was it when my life began;");
        sb.append(lineSeparator);
        sb.append("So is it now I am a man;");
        sb.append(lineSeparator);
        sb.append("So be it when I shall grow old,");
        sb.append(lineSeparator);
        sb.append("Or let me die!");
        sb.append(lineSeparator);
        sb.append(lineSeparator);
        sb.append("The Child is father of the man;");
        sb.append(lineSeparator);
        sb.append("And I could wish my days to be");

        String str = sb.toString();
        Charset cs = Charset.forName("UTF-8");
        ByteBuffer bb = ByteBuffer.wrap(str.getBytes(cs));

        return bb;
    }
}
