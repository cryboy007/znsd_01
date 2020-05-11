package com.znsd.sportsuser.Controller;

import com.znsd.sportsbean.user.UserAddressDomain;
import com.znsd.sportslog.annotation.OperationType;
import com.znsd.sportslog.annotation.SystemControllerLog;
import com.znsd.sportsuser.Service.AddressService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Mapper
@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/Aaddress")
    @SystemControllerLog(operationType = OperationType.INSERT, description = "用户收货地址添加")
    public boolean addAddress(UserAddressDomain userAddressDomain) {

        boolean flag = addressService.addAddress(userAddressDomain);
        return flag;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/Qaddress")
    @SystemControllerLog(operationType = OperationType.SELECT, description = "根据用户userID查询")
    public List<UserAddressDomain> queryAddress(String userid) {

        List<UserAddressDomain> userAddressDomains = addressService.queryAddress(userid);

        return userAddressDomains;

    }


    @PutMapping("/Uaddress")
    @SystemControllerLog(operationType = OperationType.UPDATE, description = "根据id修改地址")
    public boolean updateAddress(int id, String address) {

        boolean flag = addressService.updateAddress(id, address);

        return flag;
    }

    @DeleteMapping("/Daddress")
    @SystemControllerLog(operationType = OperationType.DELETE, description = "根据id删除地址")
    public boolean delete(int id) {

        boolean flag = addressService.deleteAddress(id);
        return flag;
    }

    @GetMapping("/queryAddressId")
    public UserAddressDomain queryId(int addressId) {
        return this.addressService.queryId(addressId);
    }
}
