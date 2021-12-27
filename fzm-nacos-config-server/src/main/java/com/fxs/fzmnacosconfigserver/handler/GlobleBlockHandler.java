package com.fxs.fzmnacosconfigserver.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2020-09-07
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
public class GlobleBlockHandler {

    public static String testGlobleBlock(int id, BlockException e) {
        return "测试全局流控规则降级";
    }
}
