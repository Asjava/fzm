package com.fxs.fzm.common.base;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;
import java.util.Map;

public interface BaseMapper<T> extends tk.mybatis.mapper.common.BaseMapper<T>,
        MySqlMapper<T>, IdsMapper<T>, ConditionMapper<T>, ExampleMapper<T> {

    List<T> selectByParam(Map<String, Object> paramMap);

    int batchInsert(List<T> entitys);

    int batchUpdate(List<T> entitys);

    int deleteByParam(Map<String, Object> paramMap);

}
