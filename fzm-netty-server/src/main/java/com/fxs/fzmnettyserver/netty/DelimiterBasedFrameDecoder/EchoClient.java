package com.fxs.fzmnettyserver.netty.DelimiterBasedFrameDecoder;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2020-09-23
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
public class EchoClient {

    public void connect(int port, String host) throws  Exception{
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel sc) throws Exception {
                            ByteBuf delimiter = Unpooled.copiedBuffer("$_".getBytes());
                            sc.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, delimiter));
                            sc.pipeline().addLast(new StringDecoder());
                            sc.pipeline().addLast(new EchoClientHandler());
                        }
                    });

            ChannelFuture f = b.connect(host, port).sync();

            // 等待客户端链路关闭
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 8080;
        if (args != null & args.length > 0) {
            Integer.valueOf(args[0]);
        }
        new EchoClient().connect(port, "127.0.0.1");
    }


}
