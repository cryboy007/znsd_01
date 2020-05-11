package com.znsd.sportsuser.Mapper;

import com.znsd.sportsbean.commodity.CommodityDomain;
import com.znsd.sportsbean.commodity.CommodityHistoryDomain;
import com.znsd.sportsbean.commodity.OrderDomain;
import com.znsd.sportsbean.commodity.ShoppingDomain;
import com.znsd.sportsbean.user.UserDomain;
import com.znsd.sportsbean.video.SubscribeDomain;
import com.znsd.sportsbean.video.VideoHistoryDomain;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface PersonalHobbyMapper {

    // 查询用户订阅的视频
    List<SubscribeDomain> querySubscription(String userid);

    // 查询用户浏览的商品历史记录
    List<CommodityHistoryDomain> productBrowsing(String userid);

    // 查询用户的视频浏览记录
    List<VideoHistoryDomain> sBrowse(String userid);

    // 查询用户购物车
    List<ShoppingDomain> shopCat(String userid);

    // 查询用户订单
    List<OrderDomain> Order(String userid);

}
