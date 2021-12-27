package com.fxs.fzmnettyserver.buffer;

import java.nio.ByteBuffer;

public class BufferWrap {
    public static void main(String[] args) {
        // 数组包装成ByteBuffer对象
        byte[] bytes = new byte[10];
        ByteBuffer wrap = ByteBuffer.wrap(bytes);

    }
}
