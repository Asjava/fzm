package com.fzm.netty.demo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.util.Scanner;

@Slf4j
public class RpcNettyClientDemo1 {

    public static void main(String[] args) throws Exception {
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();
        ChannelFuture channelFuture = bootstrap.group(nioEventLoopGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
//                        ch.pipeline().addLast(new LoggingHandler(LogLevel.DEBUG));
                        ch.pipeline().addLast(new StringEncoder());
                    }
                })
                // 建立链接
                .connect(new InetSocketAddress("localhost", 8080));

        Channel channel = channelFuture.sync().channel();

        Thread thread = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String q = scanner.nextLine();
                if (q.equals("q")) {
                    channel.close();
//                    System.out.println("关闭线程");
                    break;
                }
                channel.writeAndFlush(q);
            }
        }, "input");
        thread.start();

        ChannelFuture closeFuture = channel.closeFuture();
        closeFuture.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                System.out.println("关闭线程");
                nioEventLoopGroup.shutdownGracefully();
            }
        });
//        // 向服务端发送数据
//        Channel channel = channelFuture.channel();
//        channel.writeAndFlush("test netty");
//
//        nioEventLoopGroup.shutdownGracefully();


//        channelFuture.addListener(new ChannelFutureListener() {
//            @Override
//            public void operationComplete(ChannelFuture channelFuture) throws Exception {
//                Channel channel = channelFuture.channel();
//                channel.writeAndFlush("test netty");
//            }
//        });

    }
}
