package com.kgc.house.service;

import com.github.pagehelper.PageInfo;
import com.kgc.house.entity.District;
import com.kgc.house.utils.PageParam;

import java.util.List;

public interface DistrictService {
    PageInfo<District> getDistrictByPage(PageParam pageParam);
    Boolean add(District district);
    Boolean update(District district);
    Boolean delete(Integer id);
    Integer deleteList(List<Integer> ids);
    District getById(Integer id);
    int deleteDistrictById(List<Integer>ids);
    List<District> getAllDistrict();

}
