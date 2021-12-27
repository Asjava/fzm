package com.fxs.fzmnettyserver.netty.MessagePack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.msgpack.MessagePack;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2020-09-24
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
public class MsgpackEncode extends MessageToByteEncoder<Object> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object object, ByteBuf byteBuf) throws Exception {
        MessagePack messagePack = new MessagePack();
        byte[] body = messagePack.write(object);
        byteBuf.writeBytes(body);
    }
}
