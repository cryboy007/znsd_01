package com.znsd.sportsuser.Service.ServiceImpl;

import com.znsd.sportsbean.user.UserAddressDomain;
import com.znsd.sportsuser.Mapper.AddressMapper;
import com.znsd.sportsuser.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public boolean addAddress(UserAddressDomain userAddressDomain) {

        boolean flag = addressMapper.addAddress(userAddressDomain);

        return flag;
    }

    @Override
    public List<UserAddressDomain> queryAddress(String userid) {

        List<UserAddressDomain> userAddressDomains = addressMapper.queryAddress(userid);

        return userAddressDomains;
    }

    @Override
    public boolean updateAddress(int id, String address) {

        boolean flag = addressMapper.updateAddress(id, address);

        return flag;
    }

    @Override
    public boolean deleteAddress(int id) {

        boolean flag = addressMapper.deleteAddress(id);

        return flag;
    }

    @Override
    public UserAddressDomain queryId(int addressId) {
        return addressMapper.queryId(addressId);
    }
}
