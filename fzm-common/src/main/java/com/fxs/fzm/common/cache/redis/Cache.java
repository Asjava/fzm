package com.fxs.fzm.common.cache.redis;

public interface Cache {

    public Object getAndSet(CacheClosure cacheClosure);

    public void del(String key);

    public Object get(CacheClosure cacheClosure);

    public Object set(CacheClosure cacheClosure);

    public void setTimeout(String key, long seconds);

    public long increment(String key, long value);
}
