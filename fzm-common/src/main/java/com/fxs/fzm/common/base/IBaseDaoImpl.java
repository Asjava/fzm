package com.fxs.fzm.common.base;

import com.fxs.fzm.common.annotation.RepositoryProperty;
import com.fxs.fzm.common.constant.Constant;
import com.fxs.fzm.common.utils.BeanUtil;
import com.fxs.fzm.common.utils.MapUtils;
import com.fxs.fzm.common.utils.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.*;

public abstract class IBaseDaoImpl<T extends BaseEntity> implements IBaseDao<T> {
    private BaseMapper<T> mapper;

    protected abstract BaseMapper<T>  getMapper();
    public Class<T> getTClass() {
        Class<T> tClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return tClass;
    }

    @Override
    public String getNamespace() {
        RepositoryProperty repositoryProperty = this.getClass().getAnnotation(RepositoryProperty.class);
        return repositoryProperty.namespace();
    }

    @Override
    public int insert(T entity) {
        if (entity == null) {
            return 0;
        }
        if (entity instanceof ICreate) {
            ICreate create = (ICreate) entity;
            if (Objects.equal(create.getCreateTime(), null)) {
                create.setCreateTime(new Date());
            }
        }
        if (entity instanceof IModify) {
            IModify modify = (IModify) entity;
            if (Objects.equal(modify.getModifyTime(), null)) {
                modify.setModifyTime(new Date());
            }
        }
        if (BeanUtil.isExistField(entity, "isDelete")) {
            Object isDelete = BeanUtil.getValue(entity, "isDelete");
            if (isDelete == null) {
                BeanUtil.setValue(entity, "isDelete", Constant.DeleteStatus.NO);
            }
        }
        int i = getMapper().insert(entity);
        return i;
    }

    @Override
    public int insertSelective(T entity) {
        if (entity == null) {
            return 0;
        }
        if (entity instanceof ICreate) {
            ICreate create = (ICreate) entity;
            if (Objects.equal(create.getCreateTime(), null)) {
                create.setCreateTime(new Date());
            }
        }
        if (entity instanceof IModify) {
            IModify modify = (IModify) entity;
            if (Objects.equal(modify.getModifyTime(), null)) {
                modify.setModifyTime(new Date());
            }
        }
        if (BeanUtil.isExistField(entity, "isDelete")) {
            Object isDelete = BeanUtil.getValue(entity, "isDelete");
            if (isDelete == null) {
                BeanUtil.setValue(entity, "isDelete", Constant.DeleteStatus.NO);
            }
        }
        int i = getMapper().insertSelective(entity);
        return i;
    }

    @Override
    public int batchInsert(List<T> entitys) {
        if (entitys == null) {
            return 0;
        }
        return getMapper().batchInsert(entitys);
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
        if (entity.equals(old)) {
            return 0;
        }
        if (entity instanceof IModify) {
            IModify modify = (IModify) entity;
            if (Objects.equal(modify.getModifyTime(), null)) {
                modify.setModifyTime(new Date());
            }
        }
        int i = getMapper().updateByPrimaryKey(entity);
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
        if (entity.equals(old)) {
            return 0;
        }
        if (entity instanceof IModify) {
            IModify modify = (IModify) entity;
            if (Objects.equal(modify.getModifyTime(), null)) {
                modify.setModifyTime(new Date());
            }
        }
        int i = getMapper().updateByPrimaryKeySelective(entity);
        return i;
    }

    @Override
    public int batchUpdate(List<T> entitys) {
        if (entitys == null) {
            return 0;
        }
        return getMapper().batchUpdate(entitys);
    }

    @Override
    public int deleteByPrimaryKey(Serializable id) {
        if (id == null) {
            return 0;
        }
        T entity = selectByPrimaryKey(id);
        if (entity != null) {
            int i= getMapper().deleteByPrimaryKey(id);
            return i;
        } else {
            return 0;
        }
    }

    @Override
    public int deleteByParam(Map<String, Object> paramMap) {
         return getMapper().deleteByParam(paramMap);
    }

    @Override
    public T selectByPrimaryKey(Serializable id) {
        if (id == null) {
            return null;
        }
        T object = getMapper().selectByPrimaryKey(id);

        return object;
    }

    @Override
    public T selectOne(Map<String, Object> paramMap) {
        paramMap.put(Constant.LIMIT, 1);
        List<T> list = getMapper().selectByParam(paramMap);
        if(null != list && !list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<T> selectByParam(Map<String, Object> paramMap) {
        List<T> list = getMapper().selectByParam(paramMap);
        return list;
    }

    @Override
    public List<T> selectAll() {
        List<T> list = getMapper().selectByParam(null);
        return list;
    }

    @Override
    public Page<T> selectPage(Map<String, Object> paramMap) {
        if(null == paramMap) {
            paramMap = new HashMap<String, Object>();
        }
        Integer pageNum = MapUtils.getInteger(paramMap, Constant.PAGE_NUM, Constant.PAGE_NUM_VALUE);
        Integer pageSize = MapUtils.getInteger(paramMap, Constant.PAGE_SIZE, Constant.PAGE_SIZE_VALUE);

        PageHelper.startPage(pageNum, pageSize);
        List<T> list = getMapper().selectByParam(paramMap);
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        Page<T> pg = new Page(list, (int) pageInfo.getTotal(), pageNum, pageSize);
        return pg;
    }

    @Override
    public Page<Map<String, Object>> selectMapPage(String name, Map<String, Object> paramMap) {
        if(null == paramMap) {
            paramMap = new HashMap<String, Object>();
        }
        Integer pageNum = MapUtils.getInteger(paramMap, Constant.PAGE_NUM, Constant.PAGE_NUM_VALUE);
        Integer pageSize = MapUtils.getInteger(paramMap, Constant.PAGE_SIZE, Constant.PAGE_SIZE_VALUE);

        Page<Map<String, Object>> pg = null;
        try {
            PageHelper.startPage(pageNum, pageSize);
            Method m = getMapper().getClass().getMethod(name, new Class[] { Map.class });
            List<Map<String, Object>> list  = (List<Map<String, Object>>) m.invoke(getMapper(), new Object[] { paramMap });
            PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
            pg = new Page(list, (int) pageInfo.getTotal(), pageNum, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("执行方法：" + name + "出错");
        }
        return pg;
    }

    @Override
    public List<Map<String, Object>> selectMapList(String name, Map<String, Object> paramMap) {
        List<Map<String, Object>> list = null;
        try {
            Method m = getMapper().getClass().getMethod(name, new Class[] { Map.class });
            list  = (List<Map<String, Object>>) m.invoke(getMapper(), new Object[] { paramMap });
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("执行方法：" + name + "出错");
        }
        return list;
    }

    @Override
    public Page<T> selectPageByMethod(String methodName, Map<String, Object> paramMap) {
        if(null == paramMap) {
            paramMap = new HashMap<String, Object>();
        }
        Integer pageNum = MapUtils.getInteger(paramMap, Constant.PAGE_NUM, Constant.PAGE_NUM_VALUE);
        Integer pageSize = MapUtils.getInteger(paramMap, Constant.PAGE_SIZE, Constant.PAGE_SIZE_VALUE);

        Page<T> pg = null;
        try {
            PageHelper.startPage(pageNum, pageSize);
            Method m = getMapper().getClass().getMethod(methodName, new Class[] { Map.class });
            List<T> list  = (List<T>) m.invoke(getMapper(), new Object[] { paramMap });
            PageInfo<T> pageInfo = new PageInfo<T>(list);
            pg = new Page(list, (int) pageInfo.getTotal(), pageNum, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("执行方法：" + methodName + "出错");
        }
        return pg;
    }

    @Override
    public List<T> selectListByMethod(String methodName, Map<String,Object> paramMap) {
        List<T> list = null;
        try {
            Method m = getMapper().getClass().getMethod(methodName, new Class[] { Map.class });
            list  = (List<T>) m.invoke(getMapper(), new Object[] { paramMap });
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("执行方法：" + methodName + "出错");
        }
        return list;
    }

    @Override
    public int count(T entity) {
        return getMapper().selectCount(entity);
    }

}
