package com.kgc.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.house.entity.District;
import com.kgc.house.entity.DistrictExample;
import com.kgc.house.mapper.DistrictMapper;
import com.kgc.house.mapper.StreetMapper;
import com.kgc.house.service.DistrictService;
import com.kgc.house.utils.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictMapper districtMapper;
    @Autowired
    private StreetMapper streetMapper;

    @Override
    public PageInfo<District> getDistrictByPage(PageParam pageParam) {
        PageHelper.startPage(pageParam.getPage(),pageParam.getRows());
        List<District> list = districtMapper.selectByExample(null);
        PageInfo<District> info=new PageInfo<>(list);
        return info;
    }

    @Override
    public Boolean add(District district) {
        return districtMapper.insertSelective(district)>0;
    }

    @Override
    public Boolean update(District district) {
        return districtMapper.updateByPrimaryKeySelective(district)>0;
    }

    @Override
    public Boolean delete(Integer id) {
        return districtMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public Integer deleteList(List<Integer> ids) {
        DistrictExample example = new DistrictExample();
        DistrictExample.Criteria criteria = example.createCriteria();
        if(criteria!=null){
            if(ids!=null&&ids.size()>0){
                criteria.andIdIn(ids);
            }

           }
        return districtMapper.deleteByExample(example);
    }

    @Override
    public District getById(Integer id) {
        return districtMapper.selectByPrimaryKey(id);
    }

    @Override
     @Transactional
    public int deleteDistrictById(List<Integer> ids) {
        int a = streetMapper.deleteStreetByDistrictId(ids);
        int b = districtMapper.deleteDistrictById(ids);
        return a+b;
    }

    @Override
    public List<District> getAllDistrict() {
        return districtMapper.selectByExample(null);
    }
}
