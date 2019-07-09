package com.kgc.house.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.house.entity.Users;
import com.kgc.house.service.UsersService;
import com.kgc.house.utils.UsersParam;
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
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping("getUsers")
    @ResponseBody
    public Map<String,Object> getList(UsersParam usersParam){
        PageInfo<Users> info = usersService.getUsersListByPage(usersParam);
        Map<String,Object>map=new HashMap<>();
           map.put("total",info.getTotal());
           map.put("rows",info.getList());
        return map;
    }
    @RequestMapping("addUsers")
    @ResponseBody
    public String addUsers(Users Users){
        int b= usersService.insert(Users);
        return "{\"result\":"+b+"}";
    }

    @RequestMapping("updateUsers")
    @ResponseBody
    public String updateUsers(Users Users){
        int b= usersService.updateById(Users);
        return "{\"result\":"+b+"}";
    }
    @RequestMapping("getUsersById")
    @ResponseBody
    public Users getUsersById(Integer id){
        Users Users =usersService.selectByPrimaryKey(id);
        return Users;
    }
    @RequestMapping("deleteUsers")
    @ResponseBody
    public String deleteUsers(Integer id){

        int b = usersService.deleteByPrimaryKey(id);
        return "{\"result\":"+b+"}";
    }
    @RequestMapping("deleteListUsers")
    @ResponseBody
    public String deleteListUsers(String id)throws Exception{
        List<Integer> ids= new ArrayList<>();
        String[] str = id.split(",");
        for (int i = 0; i <str.length ; i++) {
            ids.add(Integer.parseInt(str[i]));
        }
        Integer rows = usersService.deleteUsersByIds(ids);
        return "{\"result\":"+rows+"}";

    }

}
