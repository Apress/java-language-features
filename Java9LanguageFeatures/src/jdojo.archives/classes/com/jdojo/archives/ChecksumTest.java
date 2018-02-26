// ChecksumTest.java
package com.jdojo.archives;

import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.CRC32C;
import java.util.zip.Checksum;

public class ChecksumTest {
    public static void main(String[] args) throws Exception {
        String str = "HELLO";
        byte[] data = str.getBytes("UTF-8");
        System.out.println("Adler32, CRC32, and CRC32C checksums for " + str);

        // Compute Adler32 checksum
        Checksum ad = new Adler32();
        ad.update(data);
        long adler32Checksum = ad.getValue();
        System.out.println("Adler32: " + adler32Checksum);

        // Compute CRC32 checksum
        Checksum crc32 = new CRC32();
        crc32.update(data);
        long crc32Checksum = crc32.getValue();
        System.out.println("CRC32: " + crc32Checksum);

        // Compute CRC32C checksum
        Checksum crc32c = new CRC32C();
        crc32c.update(data);
        long crc32cChecksum = crc32c.getValue();
        System.out.println("CRC32C: " + crc32cChecksum);
    }
}
