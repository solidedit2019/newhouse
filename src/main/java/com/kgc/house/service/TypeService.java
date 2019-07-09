package com.kgc.house.service;

import com.github.pagehelper.PageInfo;
import com.kgc.house.entity.Type;
import com.kgc.house.utils.PageParam;

import java.util.List;

public interface TypeService {
    int deleteByExample(Integer[] ids);

    int deleteByPrimaryKey(Integer id);

    int insert(Type type);

    int updateById(Type type);

    Type selectById(Integer id);

     PageInfo<Type> getTypeListByPage(PageParam pageParam);

     int deleteTypeByIds(List<Integer> ids);
     
    Type selectByPrimaryKey(Integer id);
       List<Type> allType();
}
