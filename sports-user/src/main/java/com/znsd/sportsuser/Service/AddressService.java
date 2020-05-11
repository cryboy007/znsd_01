package com.znsd.sportsuser.Service;

import com.znsd.sportsbean.user.UserAddressDomain;

import java.util.List;

// 收货地址的CRUD
public interface AddressService {

    //添加
    boolean addAddress(UserAddressDomain userAddressDomain);


    // 查询
    List<UserAddressDomain> queryAddress(String userid);


    // 修改
    boolean updateAddress(int id, String address);


    // 删除
    boolean deleteAddress(int id);

    public UserAddressDomain queryId(int addressId);

}
