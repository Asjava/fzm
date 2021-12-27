package com.fxs.fzmnettyserver.file;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c)
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
public class HttpFileServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
    private String url;
    public HttpFileServerHandler(String url) {
        this.url = url;
    }

    @Override
    public void messageReceived(ChannelHandlerContext channelHandlerContext, FullHttpRequest request) throws Exception {
//        if (!request.getDecoderResult().isSuccess()) {
//            sendError(ctx, BAD_REQUEST);
//            return;
//        }
    }
}
