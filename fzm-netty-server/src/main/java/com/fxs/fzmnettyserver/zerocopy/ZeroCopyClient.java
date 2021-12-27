package com.fxs.fzmnettyserver.zerocopy;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2020-10-26
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
public class ZeroCopyClient {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost",8089));
        socketChannel.configureBlocking(true);
        String fileName = "/Users/fuzhiming/Desktop/javaTool/text/zero.jpg";

        FileChannel fileChannel = new FileInputStream(fileName).getChannel();
        long startTime = System.currentTimeMillis();

        // 方法用了零拷贝，操作系统提供的特性
        long transferCount = fileChannel.transferTo(0, fileChannel.size(), socketChannel);
        long endTime = System.currentTimeMillis();
        System.out.println("发送总字节数" + transferCount + "耗时：" + (endTime - startTime) + "ms");
        fileChannel.close();
    }
}
