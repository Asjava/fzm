package com.fxs.fzm.concurrent.concurrent;

import java.util.concurrent.*;

/**
 * Title:
 *         常用并发容器：
 *         ConcurrentHashMap<String, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();
 *         CopyOnWriteArrayList<Object> objects = new CopyOnWriteArrayList<>();
 *         ConcurrentSkipListMap<Object, Object> objectObjectConcurrentSkipListMap = new ConcurrentSkipListMap<>();
 *         ConcurrentLinkedQueue<Object> objects1 = new ConcurrentLinkedQueue<>();
 *         BlockingQueue<Object> objects2 = new LinkedBlockingDeque<>();
 * Description:
 * Copyright: Copyright (c) 2020-09-27
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
public class concurrentDemo {

    public static void main(String[] args) {
        ConcurrentHashMap<String, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();
        CopyOnWriteArrayList<Object> objects = new CopyOnWriteArrayList<>();
        ConcurrentSkipListMap<Object, Object> objectObjectConcurrentSkipListMap = new ConcurrentSkipListMap<>();
        ConcurrentLinkedQueue<Object> objects1 = new ConcurrentLinkedQueue<>();
        BlockingQueue<Object> objects2 = new LinkedBlockingDeque<>();
    }


}
