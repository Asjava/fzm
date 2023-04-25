package com.java8.stream.concurrent.cfuture;

import lombok.Data;

import java.util.concurrent.TimeUnit;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2022-10-18 11:08
 * Company: 厦门船顺科技有限公司
 *
 * @author: fuzhm
 */
@Data
public class Shop {

    private double price;
    private double distict;

    public Shop(double price, double distict) {
        this.price = price;
        this.distict = distict;
    }

    public double getDistictPrice() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return price * distict;
    }

}
