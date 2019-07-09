package com.kgc.house.service;

import com.github.pagehelper.PageInfo;
import com.kgc.house.entity.Users;
import com.kgc.house.utils.UsersParam;

import java.util.List;

public interface UsersService {
    int deleteByExample(Integer[] ids);

    int deleteByPrimaryKey(Integer id);

    int insert(Users users);

    int updateById(Users users);

    Users selectById(Integer id);

     PageInfo<Users> getUsersListByPage(UsersParam usersParam);

     int deleteUsersByIds(List<Integer> ids);
     
    Users selectByPrimaryKey(Integer id);

    int getUsersByName(String name);

    int addUsersNotAdmin(Users users);

    Users login(String name,String password);
}
