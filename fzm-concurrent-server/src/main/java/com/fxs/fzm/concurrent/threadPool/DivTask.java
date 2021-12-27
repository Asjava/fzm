package com.fxs.fzm.concurrent.threadPool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2020-09-26
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
public class DivTask implements Runnable{
    int a;
    int b;

    public DivTask(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
       double re = a/b;
       System.out.println(re);
    }

    public static void main(String[] args) {
        TraceThreadPoolExecutor es = new TraceThreadPoolExecutor(0, Integer.MAX_VALUE,
                0L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>());
        for (int i = 0; i < 5; i++) {
            DivTask divTask = new DivTask(100, i);
            es.execute(divTask);
        }
    }
}
