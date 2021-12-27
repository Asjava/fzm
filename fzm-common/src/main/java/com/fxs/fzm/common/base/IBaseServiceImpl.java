package com.fxs.fzm.common.base;

import com.fxs.fzm.common.annotation.ServiceProperty;
import com.fxs.fzm.common.cache.redis.Cache;
import com.fxs.fzm.common.cache.redis.CacheClosure;
import com.fxs.fzm.common.constant.CacheConstants;
import com.fxs.fzm.common.utils.Page;
import org.codehaus.jackson.type.TypeReference;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract class IBaseServiceImpl<T extends BaseEntity> implements IBaseService<T> {

    protected abstract IBaseDao<T> getDao();

    protected abstract Cache getRedisCache();

    protected abstract TypeReference<?> getCacheTypeReference(int type);

    protected void clearCaches(T entity) {
        ServiceProperty serviceProperty = this.getClass().getAnnotation(ServiceProperty.class);
        if (serviceProperty == null || !serviceProperty.remote()) {
            return;
        }

        // 主键缓存
        BaseEntity base = (BaseEntity) entity;
        String key = getDao().getNamespace() + CacheConstants.NAME_SPACE + base.id();
        if (serviceProperty.remote()) {
            getRedisCache().del(key);
        }
        // 全局缓存
        key = getDao().getNamespace()  +CacheConstants.NAME_SPACE + CacheConstants.CACHE_DEFAULT_ALL;
        if (serviceProperty.remote()) {
            getRedisCache().del(key);
        }
    }

    @Override
    public int insert(T entity) {
        if (entity == null) {
            return 0;
        }
        int i = getDao().insert(entity);
        if (i > 0) {
            clearCaches(entity);
        }
        return i;
    }

    @Override
    public int insertSelective(T entity) {
        if (entity == null) {
            return 0;
        }
        int i = getDao().insertSelective(entity);
        if (i > 0) {
            clearCaches(entity);
        }
        return i;
    }

    @Override
    public int batchInsert(List<T> entitys) {
        if (entitys == null || entitys.isEmpty()) {
            return 0;
        }
        int i = getDao().batchInsert(entitys);
        if (i > 0) {
            clearCaches(entitys.get(0));
        }
        return i;
    }

    @Override
    public int updateByPrimaryKey(T entity) {
        if (entity == null) {
            return 0;
        }
        BaseEntity base = (BaseEntity) entity;
        if (base.id() == null) {
            return 0;
        }
        T old = selectByPrimaryKey(base.id());
        if (old == null) {
            return 0;
        }
        int i = getDao().updateByPrimaryKey(entity);
        if (i > 0) {
            clearCaches(old);
        }
        return i;
    }

    @Override
    public int updateByPrimaryKeySelective(T entity) {
        if (entity == null) {
            return 0;
        }
        BaseEntity base = (BaseEntity) entity;
        if (base.id() == null) {
            return 0;
        }
        T old = selectByPrimaryKey(base.id());
        if (old == null) {
            return 0;
        }
        int i = getDao().updateByPrimaryKeySelective(entity);
        if (i > 0) {
            clearCaches(old);
        }
        return i;
    }

    @Override
    public int batchUpdate(List<T> entitys) {
        if (entitys == null || entitys.isEmpty()) {
            return 0;
        }
        int i = getDao().batchUpdate(entitys);
        if (i > 0) {
            for (T entity : entitys) {
                clearCaches(entity);
            }
        }
        return i;
    }

    @Override
    public int deleteByPrimaryKey(Serializable id) {
        if (id == null) {
            return 0;
        }
        T entity = selectByPrimaryKey(id);
        if (entity == null) {
            return 0;
        }
        int i = getDao().deleteByPrimaryKey(id);
        if (i > 0) {
            clearCaches(entity);
        }
        return i;
    }

    @Override
    public int deleteByParam(Map<String, Object> paramMap) {
        List<T> lst = selectByParam(paramMap);
        if (lst == null || lst.isEmpty()) {
            return 0;
        }
        int i = getDao().deleteByParam(paramMap);
        if (i > 0) {
            for (T entity : lst) {
                clearCaches(entity);
            }
        }
        return i;
    }

    @Override
    public T selectByPrimaryKey(Serializable id) {
        if (id == null) {
            return null;
        }
        T rtn;
        ServiceProperty serviceProperty = this.getClass().getAnnotation(ServiceProperty.class);
        final Serializable queryId = id;
        final String key = getDao().getNamespace() +CacheConstants.NAME_SPACE+ id;
        if (serviceProperty != null && serviceProperty.remote()) {
            rtn = (T) getRedisCache().getAndSet(new CacheClosure() {
                @Override
                public String getKey() {
                    return key;
                }

                @Override
                public T getValue() {
                    return getDao().selectByPrimaryKey(queryId);
                }

                @Override
                public TypeReference getTypeReference() {
                    return getCacheTypeReference(1);
                }

                @Override
                public Integer getTime() {
                    return null;
                }

                @Override
                public boolean getIfNullSetDefaultValue() {
                    return true;
                }

                @Override
                public String getIfNullDefaultValue() {
                    return CacheConstants.CACHE_DEFAULT_VALUE;
                }
            });

            if (rtn != null) {
                return rtn;
            }
        }

        rtn = getDao().selectByPrimaryKey(queryId);
        return rtn;

    }

    @Override
    public T selectOne(Map<String, Object> paramMap) {
        return getDao().selectOne(paramMap);
    }

    @Override
    public List<T> selectByParam(Map<String, Object> paramMap) {
        List<T> list = getDao().selectByParam(paramMap);
        return list;
    }

    @Override
    public List<T> selectAll() {
        ServiceProperty serviceProperty = this.getClass().getAnnotation(ServiceProperty.class);
        List<T> rtn = null;
        final String key = getDao().getNamespace() + CacheConstants.NAME_SPACE + CacheConstants.CACHE_DEFAULT_ALL;
        if (serviceProperty != null && serviceProperty.remote()) {
            rtn = (List<T>) getRedisCache().getAndSet(new CacheClosure() {
                @Override
                public String getKey() {
                    return key;
                }

                @Override
                public Object getValue() {
                    return getDao().selectAll();
                }

                @Override
                public TypeReference getTypeReference() {
                    return getCacheTypeReference(2);
                }

                @Override
                public Integer getTime() {
                    return null;
                }

                @Override
                public boolean getIfNullSetDefaultValue() {
                    return true;
                }

                @Override
                public String getIfNullDefaultValue() {
                    return CacheConstants.CACHE_DEFAULT_VALUE;
                }
            });
            if (rtn != null) {
                return rtn;
            }
        }
        rtn = getDao().selectAll();
        return rtn;
    }

    @Override
    public Page<T> selectPage(Map<String, Object> paramMap) {
        Page<T> page = getDao().selectPage(paramMap);
        return page;
    }

    @Override
    public Page<Map<String, Object>> selectMapPage(String methodName, Map<String, Object> paramMap) {
        Page<Map<String, Object>> page = getDao().selectMapPage(methodName, paramMap);
        return page;
    }

    @Override
    public List<Map<String, Object>> selectMapList(String methodName, Map<String, Object> paramMap) {
        List<Map<String, Object>> page = getDao().selectMapList(methodName, paramMap);
        return page;
    }

    @Override
    public Page<T> selectPageByMethod(String methodName, Map<String, Object> paramMap) {
        Page<T> page = getDao().selectPageByMethod(methodName, paramMap);
        return page;
    }

    @Override
    public List<T> selectListByMethod(String methodName, Map<String, Object> paramMap) {
        List<T> page = getDao().selectListByMethod(methodName, paramMap);
        return page;
    }

    @Override
    public int count(T entity) {
        return getDao().count(entity);
    }

}
