package com.fxs.fzmnettyserver.buffer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BuffeDemo {

    public static void main(String[] args) throws Exception {
        // 初始化buffer
        ByteBuffer buffer = ByteBuffer.allocate(10);
        output("初始化", buffer);

        // 读取数据到buffer中
        FileInputStream inputStream = new FileInputStream("/Users/fuzhiming/Desktop/javaTool/text/buffer.txt");
        FileChannel channel = inputStream.getChannel();
        channel.read(buffer);
        output("调用read", buffer);

        //buffer模式切换flip
        buffer.flip();
        output("模式切换flip", buffer);

        //buffer读取
        while(buffer.remaining() > 0) {
            byte b = buffer.get();
        }
        output("调用get", buffer);

        //清空数据
        Buffer clear = buffer.clear();
        output("调用clear", buffer);


    }

    public static void output(String message, Buffer buffer){
        System.out.println(message + "===========");
        System.out.println("position: " + buffer.position() +" ,limit: " + buffer.limit() + ",capacity: " + buffer.capacity());
    }
}
