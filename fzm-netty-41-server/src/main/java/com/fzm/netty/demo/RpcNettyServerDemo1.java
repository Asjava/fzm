package com.fzm.netty.demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.DefaultEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RpcNettyServerDemo1 {

    public static void main(String[] args) throws Exception {
        ServerBootstrap bootstrap = new ServerBootstrap();
        NioEventLoopGroup bossGrouo = new NioEventLoopGroup(); // 负责io任务、普通任务、定时任务
        NioEventLoopGroup workGroup = new NioEventLoopGroup();

        DefaultEventLoop eventLoop = new DefaultEventLoop(); // 只负责普通任务与定时任务

        bootstrap.group(bossGrouo, workGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new StringDecoder());
                        ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {
                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                log.debug(msg.toString());
                                ctx.fireChannelRead(msg);
                            }
                        });
                        ch.pipeline().addLast(eventLoop, "handler1",new ChannelInboundHandlerAdapter() {
                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                log.debug(msg.toString());
                            }
                        });
                    }
                }).bind(8080).sync();
    }
}
