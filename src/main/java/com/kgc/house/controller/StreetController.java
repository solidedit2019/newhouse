package com.kgc.house.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.house.entity.Street;
import com.kgc.house.service.StreetService;
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
public class StreetController {
    @Autowired
    private StreetService streetService;

    @RequestMapping("getStreet")
    @ResponseBody
    public Map<String,Object> getList(Integer id, PageParam pageParam){
        PageInfo<Street> info = streetService.getStreetListByPage(id,pageParam);
        Map<String,Object>map=new HashMap<>();
           map.put("total",info.getTotal());
           map.put("rows",info.getList());
        return map;
    }
    @RequestMapping("addStreet")
    @ResponseBody
    public String addStreet(Street Street){
        int b= streetService.insert(Street);
        return "{\"result\":"+b+"}";
    }

    @RequestMapping("updateStreet")
    @ResponseBody
    public String updateStreet(Street Street){
        int b= streetService.updateById(Street);
        return "{\"result\":"+b+"}";
    }
    @RequestMapping("getStreetById")
    @ResponseBody
    public Street getStreetById(Integer id){
        Street street = streetService.selectByPrimaryKey(id);
        return street;
    }
    @RequestMapping("deleteStreet")
    @ResponseBody
    public String deleteStreet(Integer id){

        int b = streetService.deleteByPrimaryKey(id);
        return "{\"result\":"+b+"}";
    }
    @RequestMapping("deleteListStreet")
    @ResponseBody
    public String deleteListStreet(String id)throws Exception{
        List<Integer> ids= new ArrayList<>();
        String[] str = id.split(",");
        for (int i = 0; i <str.length ; i++) {
            ids.add(Integer.parseInt(str[i]));
        }
        Integer rows = streetService.deleteStreetById(ids);
        return "{\"result\":"+rows+"}";

    }

}
