package com.znsd.sportsuser.Mapper;

import com.znsd.sportsbean.user.UserDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserMapper {

    // 添加用户
    boolean addUser(UserDomain user);


    // 根据 ID 查询用户信息
    UserDomain queryUser(String id);


    // 查询所有用户信息
    List<UserDomain> queryAll();


    // 查询所有用户信息-分页
    List<UserDomain> fenYe(int page, int limit);


    // 根据用户名、姓名模糊查询
    List<UserDomain> fuzzyQuery(String value, int page, int limit);


    //  根据 username 判断用户是否存在
    UserDomain queryName(String userName);


    // 修改用户信息
    boolean updateUser(UserDomain user);


    // 删除用户
    boolean deleteUser(String id);

    // 用户登录
    UserDomain sigInUser(String username, String password);

    public int updateMoney(String userId, double money);

}
