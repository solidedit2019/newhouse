package com.kgc.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.house.entity.House;
import com.kgc.house.mapper.HouseMapper;
import com.kgc.house.service.HouseService;
import com.kgc.house.utils.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseMapper mapper;
    @Override
    public int add(House house) {
        return mapper.insertSelective(house);
    }

    @Override
    public PageInfo<House> getPageHouse(Integer id, PageParam pageParam) {
        PageHelper.startPage(pageParam.getPage(),pageParam.getRows());
        List<House> listHouse = mapper.getListHouse(id);

        return new PageInfo<>(listHouse);
    }

    @Override
    public int delete(String id) {

        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(House house) {

        return mapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public House getHouseById(String id) {

        return mapper.getHouseById(id);
    }
}
