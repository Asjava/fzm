package com.fzm.zookeeper.restful.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class WatchDemo {
    public static void main(String[] args) throws Exception {
        // PathChildrenCache
        // NodeCache
        // TreeCache
        // 2、build方式

        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder().
                connectString("localhost:2181").sessionTimeoutMs(5000).
                retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();

        curatorFramework.start();

        addListenerWithNode(curatorFramework);
        System.in.read();
    }

    private static void addListenerWithNode(CuratorFramework curatorFramework) throws Exception {
        NodeCache nodeCache = new NodeCache(curatorFramework,"/watch", false);
        NodeCacheListener nodeCacheListener = new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                System.out.println("receive node change");
                System.out.println(nodeCache.getCurrentData().getPath() + "-" + new String(nodeCache.getCurrentData().getData()));
            }
        };
        nodeCache.getListenable().addListener(nodeCacheListener);
        nodeCache.start();
    }
}
