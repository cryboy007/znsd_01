package com.znsd.sportsuser.Service.ServiceImpl;

import com.znsd.sportsbean.commodity.CommodityDomain;
import com.znsd.sportsbean.commodity.CommodityHistoryDomain;
import com.znsd.sportsbean.commodity.OrderDomain;
import com.znsd.sportsbean.commodity.ShoppingDomain;
import com.znsd.sportsbean.video.SubscribeDomain;
import com.znsd.sportsbean.video.VideoHistoryDomain;
import com.znsd.sportsuser.Mapper.PersonalHobbyMapper;
import com.znsd.sportsuser.Service.PersonalHobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalHobbyServiceImpl implements PersonalHobbyService {

    @Autowired
    private PersonalHobbyMapper hobbyMapper;


    @Override
    public List<SubscribeDomain> querySubscription(String userid) {
        return hobbyMapper.querySubscription(userid);
    }

    @Override
    public List<CommodityHistoryDomain> productBrowsing(String userid) {
        return hobbyMapper.productBrowsing(userid);
    }

    @Override
    public List<VideoHistoryDomain> sBrowse(String userid) {
        return hobbyMapper.sBrowse(userid);
    }

    @Override
    public List<ShoppingDomain> shopCat(String userid) {
        return hobbyMapper.shopCat(userid);
    }

    @Override
    public List<OrderDomain> Order(String userid) {
        return hobbyMapper.Order(userid);
    }
}
