package com.fxs.fzmnettyserver.nio;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2020-09-21
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
public class TimeServer {
    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            port = Integer.valueOf(args[0]);
        }

        MultiplexerTimeServer multiplexerTimeServer = new MultiplexerTimeServer(port);


    }
}
