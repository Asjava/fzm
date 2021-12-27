package com.fxs.fzm.concurrent.future;

import java.util.concurrent.*;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2020-10-26
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
public class RealData implements Callable<String> {
    private String parse;

    public RealData(String parse) {
        this.parse = parse;
    }

    @Override
    public String call() throws Exception {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(parse);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        FutureTask<String> future = new FutureTask<>(new RealData("fzm"));
        // 有结果方式提交：
        executor.submit(future);

        System.out.println("请求完毕");

        Thread.sleep(2000);

        System.out.println("数据 =" + future.get());
    }
}
