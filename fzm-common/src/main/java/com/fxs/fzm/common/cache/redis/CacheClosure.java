package com.fxs.fzm.common.cache.redis;


import org.codehaus.jackson.type.TypeReference;

public interface CacheClosure {

    /**
     * 缓存键
     * @return
     */
    public String getKey();

    /**
     * 缓存值
     * @return
     */
    public Object getValue();

    /**
     * 类型
     * @return
     */
    public TypeReference<?> getTypeReference();

    /**
     * 时间,单位:秒,为空表示永久有效
     * @return
     */
    public Integer getTime();

    /**
     * 当值为空时，是否设置默认值标志
     * @return
     */
    public boolean getIfNullSetDefaultValue();

    /**
     * 当值为空时，设置的默认值
     * @return
     */
    public String getIfNullDefaultValue();
}
