package com.kgc.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.house.entity.Street;
import com.kgc.house.entity.StreetExample;
import com.kgc.house.mapper.StreetMapper;
import com.kgc.house.service.StreetService;
import com.kgc.house.utils.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StreetServiceImpl implements StreetService {
    @Autowired
    private StreetMapper streetMapper;

    @Override
    public int deleteByExample(Integer[] ids) {
        StreetExample example=new StreetExample();
        StreetExample.Criteria criteria = example.createCriteria();
        List<Integer>id= Arrays.asList(ids);
        criteria.andIdIn(id);
        return streetMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return streetMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Street street) {
        return streetMapper.insertSelective(street);
    }

    @Override
    public int updateById(Street street) {
        return streetMapper.updateByPrimaryKeySelective(street);
    }

    @Override
    public Street selectById(Integer id) {
        return streetMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Street> getStreetListByPage(Integer id,PageParam pageParam) {
        PageHelper.startPage(pageParam.getPage(),pageParam.getRows());
        StreetExample example=new StreetExample();
        StreetExample.Criteria criteria = example.createCriteria();
        criteria.andDistrictIdEqualTo(id);
        List<Street> list = streetMapper.selectByExample(example);
        return new PageInfo<>(list);
    }

    @Override
    public int deleteStreetById(List<Integer> ids) {
        return streetMapper.deleteStreetById(ids);
    }

    @Override
    public Street selectByPrimaryKey(Integer id) {
        return streetMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Street> getAllStreet(Integer districtId) {
        StreetExample example=new StreetExample();
        StreetExample.Criteria criteria = example.createCriteria();
        if(districtId!=null&!districtId.equals("")){
            criteria.andDistrictIdEqualTo(districtId);
        }
        List<Street> list = streetMapper.selectByExample(example);

        return list;
    }
}
