package com.fzm.netty.proxy;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;

public class RpcNettyClientProxy {

    public static void main(String[] args) throws Exception {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(new NioEventLoopGroup())
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new StringEncoder());
                    }
                })
                // 建立链接
                .connect(new InetSocketAddress("localhost", 8080))
                .sync()
                // 向服务端发送数据
                .channel().writeAndFlush("test netty");

    }

}
