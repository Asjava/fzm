package com.fxs.fzm.concurrent.cas;

import java.sql.Timestamp;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2020-09-29
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
public class AtomicStampedReferenceDemo {
    public static AtomicStampedReference<Integer> money = new AtomicStampedReference<Integer>(19, 0);

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            int timeStamp = money.getStamp();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        Integer m = money.getReference();
                        if (m < 20) {
                            if (money.compareAndSet(m, m + 20, timeStamp, timeStamp + 1)) {
                                System.out.println("余额小于20元， 充值成功， 余额:"+ money.getReference() + "元");
                                break;
                            }
                        } else {
                            System.out.println("余额大于20元，无须充值");
                            break;
                        }
                    }
                }
            }).start();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    while (true) {
                        int timestamp = money.getStamp();
                        Integer m = money.getReference();
                        if (m > 10) {
                            System.out.println("大于10元");
                            if (money.compareAndSet(m , m - 10, timestamp, timestamp + 1)) {
                                System.out.println("成功消费10元，余额:" + money.getReference());
                                break;
                            }
                        } else {
                            System.out.println("没有足够的余额");
                            break;
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }
}
