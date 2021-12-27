package com.fxs.fzmnettyserver.netty.FixedLengthFrameDecoder;

import com.sun.xml.internal.ws.wsdl.writer.document.soap.Body;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c)
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
public class EchoServerHandler extends ChannelHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String msg1 = (String) msg;
        String body =  "Receive client : [" + msg1 + "]";
        System.out.println(body);
        ByteBuf echo = Unpooled.copiedBuffer(msg1.getBytes());
        ctx.writeAndFlush(echo);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}
