package com.fxs.fzm.concurrent.future;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2020-10-26
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
public class guavaFuture {
    public static void main(String[] args) throws InterruptedException {
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

        ListenableFuture<String> task = service.submit(new RealData("fzm"));

        // 开启线程监听task任务执行
        task.addListener(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("异步处理成功");
                try {
                    System.out.println(task.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }), MoreExecutors.directExecutor());

        System.out.println("main task done ......");
        Thread.sleep(3000);
    }
}
