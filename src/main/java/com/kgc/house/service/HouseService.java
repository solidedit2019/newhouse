package com.kgc.house.service;

import com.github.pagehelper.PageInfo;
import com.kgc.house.entity.House;
import com.kgc.house.utils.PageParam;

public interface HouseService {
    int add(House house);
    PageInfo<House> getPageHouse(Integer id, PageParam pageParam);
    int delete(String id);
    int update(House house);
    House getHouseById(String id);
}
