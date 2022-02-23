package com.fzm.zookeeper.restful.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListenerAdapter;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.io.Closeable;
import java.io.IOException;

/**
 * leader Latch与LeaderSelector的区别
 * 共同点都是按顺序节点取最小节点为master
 * 不同点LeaderSelector释放资源后，可重新参与选举
 */
public class LeaderSelectClientB extends LeaderSelectorListenerAdapter implements Closeable {

    private String name;
    private LeaderSelector leaderSelector;

    public LeaderSelectClientB(CuratorFramework curatorFramework, String name, String path) {
        this.name = name;
        leaderSelector= new LeaderSelector(curatorFramework,path, this);

        // 释放资源后，重新进入master竞争选举
        leaderSelector.autoRequeue();
    }

    public void start() {
        leaderSelector.start();
    }

    @Override
    public void takeLeadership(CuratorFramework curatorFramework) throws Exception {
        System.out.println(name + "现在为leader了，持久化为master节点");

        // 阻塞当前线程，如果释放资源，则相关的临时节点也会退出
        System.in.read();
    }

    @Override
    public void close() throws IOException {
        leaderSelector.close();
    }

    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder().
                connectString("localhost:2181").sessionTimeoutMs(5000).
                retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();

        curatorFramework.start();

        LeaderSelectClientB clientA = new LeaderSelectClientB(curatorFramework, "ClientB", "/leader");
        clientA.start();
        System.in.read();
    }
}
