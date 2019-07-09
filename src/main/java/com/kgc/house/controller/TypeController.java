package com.kgc.house.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.house.entity.Type;
import com.kgc.house.service.TypeService;
import com.kgc.house.utils.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @RequestMapping("getType")
    @ResponseBody
    public Map<String,Object> getList(PageParam pageParam){
        PageInfo<Type> info = typeService.getTypeListByPage(pageParam);
        Map<String,Object>map=new HashMap<>();
           map.put("total",info.getTotal());
           map.put("rows",info.getList());
        return map;
    }
    @RequestMapping("addType")
    @ResponseBody
    public String addType(Type Type){
        int b= typeService.insert(Type);
        return "{\"result\":"+b+"}";
    }

    @RequestMapping("updateType")
    @ResponseBody
    public String updateType(Type Type){
        int b= typeService.updateById(Type);
        return "{\"result\":"+b+"}";
    }
    @RequestMapping("getTypeById")
    @ResponseBody
    public Type getTypeById(Integer id){
        Type type =typeService.selectByPrimaryKey(id);
        return type;
    }
    @RequestMapping("deleteType")
    @ResponseBody
    public String deleteType(Integer id){

        int b = typeService.deleteByPrimaryKey(id);
        return "{\"result\":"+b+"}";
    }
    @RequestMapping("deleteListType")
    @ResponseBody
    public String deleteListType(String id)throws Exception{
        List<Integer> ids= new ArrayList<>();
        String[] str = id.split(",");
        for (int i = 0; i <str.length ; i++) {
            ids.add(Integer.parseInt(str[i]));
        }
        Integer rows = typeService.deleteTypeByIds(ids);
        return "{\"result\":"+rows+"}";

    }

}
