package com.kgc.house.service;

import com.github.pagehelper.PageInfo;
import com.kgc.house.entity.Street;
import com.kgc.house.utils.PageParam;

import java.util.List;

public interface StreetService {
    int deleteByExample(Integer[] ids);

    int deleteByPrimaryKey(Integer id);

    int insert(Street street);

    int updateById(Street street);

    Street selectById(Integer id);

     PageInfo<Street> getStreetListByPage(Integer id,PageParam pageParam);

     int deleteStreetById(List<Integer>ids);

    Street selectByPrimaryKey(Integer id);
    List<Street> getAllStreet(Integer districtId);
}
