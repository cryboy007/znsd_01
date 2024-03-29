package com.znsd.sportslog.dao;

import com.znsd.sportsbean.commodity.CommodityAndTypeDomain;
import com.znsd.sportsbean.commodity.CommodityHistoryDomain;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeMapper {

    public List<CommodityHistoryDomain> getTypeSize(String userid);

    /**
     * 随机获取商品
     *
     * @param typeid
     * @param page
     * @return
     */
    public CommodityAndTypeDomain RandomShop(String typeid, int page);

    /**
     * 获取类型商品总量
     */
    public int conut(String typeId);

    /**
     * 商品总数
     */
    int shopCount();

    CommodityAndTypeDomain randomShopAll(int page);
}
