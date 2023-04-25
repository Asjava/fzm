package com.fxs.fzmnettyserver.nio;

import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.Iterator;

public class WriterServer {

    public static void main(String[] args) throws Exception {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        ssc.bind(new InetSocketAddress(4001));

        Selector selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT, null);

        while (true) {
            selector.select();
            Iterator<SelectionKey> itr = selector.selectedKeys().iterator();
            while (itr.hasNext()) {
                SelectionKey key = itr.next();
                itr.remove();

                if (key .isAcceptable()) {
                    ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                    SocketChannel socketChannel = channel.accept();
                    socketChannel.register(selector, SelectionKey.OP_READ);
                    socketChannel.configureBlocking(false);
                }
            }
        }
    }
}
