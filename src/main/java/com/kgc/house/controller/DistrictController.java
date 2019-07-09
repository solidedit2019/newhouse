package com.kgc.house.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.house.entity.District;
import com.kgc.house.service.DistrictService;
import com.kgc.house.utils.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/admin")
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @RequestMapping("getDistrict")
    @ResponseBody
    public Map<String,Object> getDistrict(PageParam pageParam){
        PageInfo<District> info = districtService.getDistrictByPage(pageParam);
        Map<String,Object> map=new HashMap<>();
        map.put("total",info.getTotal());
        map.put("rows",info.getList());
        return map;
    }
    @RequestMapping("addDistrict")
    @ResponseBody
    public String addDistrict(District district){
       Boolean b= districtService.add(district);
        return "{\"result\":"+b+"}";
    }

    @RequestMapping("updateDistrict")
    @ResponseBody
    public String updateDistrict(District district){
        Boolean b= districtService.update(district);
        return "{\"result\":"+b+"}";
    }
    @RequestMapping("getDistrictById")
    @ResponseBody
    public District getDistrictById(Integer id){
        District district = districtService.getById(id);
        return district;
    }
    @RequestMapping("deleteDistrict")
    @ResponseBody
    public String deleteDistrict(Integer id){

        Boolean b = districtService.delete(id);
        return "{\"result\":"+b+"}";
    }
    @RequestMapping("deleteListDistrict")
    @ResponseBody
    public String deleteListDistrict(String id)throws Exception{
        List<Integer>ids= new ArrayList<>();
        String[] str = id.split(",");
        for (int i = 0; i <str.length ; i++) {
            ids.add(Integer.parseInt(str[i]));
        }
        Integer rows = districtService.deleteDistrictById(ids);
            return "{\"result\":"+rows+"}";

    }
}
