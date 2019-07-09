package com.kgc.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.house.entity.Type;
import com.kgc.house.entity.TypeExample;
import com.kgc.house.mapper.TypeMapper;
import com.kgc.house.service.TypeService;
import com.kgc.house.utils.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;

    @Override
    public int deleteByExample(Integer[] ids) {
        TypeExample example=new TypeExample();
        TypeExample.Criteria criteria = example.createCriteria();
        List<Integer>id= Arrays.asList(ids);
        criteria.andIdIn(id);
        return typeMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return typeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Type type) {
        return typeMapper.insertSelective(type);
    }

    @Override
    public int updateById(Type type) {
        return typeMapper.updateByPrimaryKeySelective(type);
    }

    @Override
    public Type selectById(Integer id) {
        return typeMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Type> getTypeListByPage(PageParam pageParam) {
        PageHelper.startPage(pageParam.getPage(),pageParam.getRows());
        List<Type> list = typeMapper.selectByExample(null);
        return new PageInfo<>(list);
    }

    @Override
    public int deleteTypeByIds(List<Integer> ids) {
        return typeMapper.deleteTypeByIds(ids);
    }

    @Override
    public Type selectByPrimaryKey(Integer id) {
        return typeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Type> allType() {
        return typeMapper.selectByExample(null);
    }
}
