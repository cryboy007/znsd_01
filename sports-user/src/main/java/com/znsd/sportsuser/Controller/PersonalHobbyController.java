package com.znsd.sportsuser.Controller;

import com.znsd.sportsbean.commodity.CommodityDomain;
import com.znsd.sportsbean.commodity.CommodityHistoryDomain;
import com.znsd.sportsbean.commodity.OrderDomain;
import com.znsd.sportsbean.commodity.ShoppingDomain;
import com.znsd.sportsbean.video.SubscribeDomain;
import com.znsd.sportsbean.video.VideoHistoryDomain;
import com.znsd.sportsuser.Service.PersonalHobbyService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Mapper
@RestController
public class PersonalHobbyController {


    @Autowired
    private PersonalHobbyService phs;

    // 订单
    @GetMapping("/order")
    public List<OrderDomain> userAndOrder(String userid) {

        List<OrderDomain> orderList = phs.Order(userid);

        return orderList;
    }

    // 商品浏览历史
    @GetMapping("/shopBrows")
    public List<CommodityHistoryDomain> productBrowsing(String userid) {

        List<CommodityHistoryDomain> list = phs.productBrowsing(userid);
        return list;
    }


    // 视频浏历史
    @GetMapping("/videoBrows")
    public List<VideoHistoryDomain> sBrowse(String userid) {

        List<VideoHistoryDomain> list = phs.sBrowse(userid);
        return list;
    }

    //  我的订阅
    @GetMapping("/MySubscriptions")
    public List<SubscribeDomain> querySubscription(String userid) {

        List<SubscribeDomain> subscribeDomains = phs.querySubscription(userid);
        return subscribeDomains;
    }

    //  购物车

    @GetMapping("/shopCat")
    public List<ShoppingDomain> userAndShopCat(String userid) {
        return phs.shopCat(userid);
    }

}
