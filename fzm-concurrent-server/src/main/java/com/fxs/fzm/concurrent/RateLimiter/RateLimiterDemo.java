package com.fxs.fzm.concurrent.RateLimiter;

import com.google.common.util.concurrent.RateLimiter;

/**
 * Title:  令牌算法
 * Description:
 * Copyright: Copyright (c) 2020-09-26
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
public class RateLimiterDemo {
    public static RateLimiter rateLimiter = RateLimiter.create(2);

    public  static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            if (!rateLimiter.tryAcquire()) {   // 500毫秒产生一个令牌，过载的将会被抛弃掉。
                continue;
            }
//            rateLimiter.acquire();  // 拿取令牌，没拿到令牌的等待拿取令牌。
            new Thread(new Task()).start();
        }
    }
}
