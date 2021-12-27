package com.fxs.fzm.common.base;


import com.fxs.fzm.common.utils.Page;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface IBaseService<T extends BaseEntity> {

    int insert(T entity);

    int insertSelective(T entity);

    int batchInsert(List<T> entitys);

    int updateByPrimaryKey(T entity);

    int updateByPrimaryKeySelective(T entity);

    int batchUpdate(List<T> entitys);

    int deleteByPrimaryKey(Serializable id);

    int deleteByParam(Map<String, Object> paramMap);

    T selectByPrimaryKey(Serializable id);

    T selectOne(Map<String, Object> paramMap);

    List<T> selectByParam(Map<String, Object> paramMap);

    List<T> selectAll();

    Page<T> selectPage(Map<String, Object> paramMap);

    Page<Map<String, Object>> selectMapPage(String methodName, Map<String, Object> paramMap);

    List<Map<String, Object>> selectMapList(String methodName, Map<String, Object> paramMap);

    Page<T> selectPageByMethod(String methodName, Map<String, Object> paramMap);

    List<T> selectListByMethod(String methodName, Map<String, Object> paramMap);

    int count(T entity);
}
