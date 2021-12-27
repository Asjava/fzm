package com.fxs.fzmnettyserver.zerocopy;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Title:  byteBuffer.rewind(); 一般把数据重写入Buffer前调用
 * Description:
 * Copyright: Copyright (c) 2020-10-26
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
public class ZeroCopyServer {

    public static void main(String[] args) throws IOException {
        InetSocketAddress address = new InetSocketAddress(8089);
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.setReuseAddress(true);
        serverSocket.bind(address);

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(true);
            int readCount = 0;
            while (readCount != -1) {
                readCount = socketChannel.read(byteBuffer);
                byteBuffer.rewind();
            }
        }
    }
}
