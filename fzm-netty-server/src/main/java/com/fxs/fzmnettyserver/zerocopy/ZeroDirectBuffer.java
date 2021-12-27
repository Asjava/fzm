package com.fxs.fzmnettyserver.zerocopy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ZeroDirectBuffer {
    public static void main(String[] args) throws Exception {
        String infile = "/Users/fuzhiming/Desktop/javaTool/text/zero.jpg";
        FileInputStream fileInputStream = new FileInputStream(infile);
        FileChannel fcin = fileInputStream.getChannel();


        String outfile = "/Users/fuzhiming/Desktop/javaTool/text/zero_copy.jpg";
        FileOutputStream outputStream = new FileOutputStream(outfile);
        FileChannel fcout = outputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        while(true) {
            buffer.clear();
            int r = fcin.read(buffer);

            if (r == -1) {
                break;
            }

            buffer.flip();
            fcout.write(buffer);
        }
    }
}
