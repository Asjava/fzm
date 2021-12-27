package com.fxs.fzmnettyserver.buffer;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedBuffer {

    public static void main(String[] args) throws Exception {
        RandomAccessFile raf = new RandomAccessFile("/Users/fuzhiming/Desktop/javaTool/text/buffer.txt", "rw");
        FileChannel fc = raf.getChannel();

        MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0, 26);
        mbb.put(0, (byte) 97);
        mbb.put(25, (byte) 122);

        raf.close();


    }
}
