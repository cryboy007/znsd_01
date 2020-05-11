package com.znsd.sportsuser.Service;


import com.github.pagehelper.PageInfo;
import com.znsd.sportsbean.user.UserDomain;

import java.util.List;


public interface UserService {

    // 添加用户
    boolean addUser(UserDomain user);


    // 根据 ID 查询用户信息
    UserDomain queryUser(String id);

    // 查询所有用户信息
    List<UserDomain> queryAll();


    // 查询所有用户信息-分页
    PageInfo<UserDomain> fenYe(int page, int limit);


    //  根据 username 判断用户是否存在
    UserDomain queryName(String userName);

    // 根据用户名、姓名模糊查询
    PageInfo<UserDomain> fuzzyQuery(String value, int page, int limit);

    // 修改用户信息
    boolean updateUser(UserDomain user);


    // 删除用户信息
    boolean deleteUser(String id);


    // 用户登录
    UserDomain sigInUser(String username, String password);

    int updateMoney(String userId, double money);

}
