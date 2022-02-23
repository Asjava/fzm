package com.fzm.zookeeper.restful.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

public class CuratorDemo {

    public static void main(String[] args) throws Exception {
        // 两种方式创建newClient方式、build模式（推荐使用）

        // 1、newClient方式
        // CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient("localhost:2181", new ExponentialBackoffRetry(1000, 3));


        // 2、build方式
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder().
                connectString("localhost:2181").sessionTimeoutMs(5000).
                retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();

        curatorFramework.start();

        createData(curatorFramework);
//        updateData(curatorFramework);
//          deleteData(curatorFramework);
    }

    private static void deleteData(CuratorFramework curatorFramework) {

    }

    private static void updateData(CuratorFramework curatorFramework) throws Exception {
        // 查看节点状态
        Stat stat = new Stat();

//        curatorFramework
        // 根据节点删除对应数据
        curatorFramework.setData().forPath("/date/node1", "test-update".getBytes());
//        curatorFramework.setData().forPath("/date/node1", "test-update".getBytes());
    }

    private static void createData(CuratorFramework curatorFramework) throws Exception {
        // creatingParentsIfNeeded 父节点不存在时允许自动创建
        curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/watch", "test".getBytes());
    }
}
