package com.znsd.sportsbean.commodity;

import org.springframework.stereotype.Service;

/**
 * 商品类型表（commodittype_db），与商品表（commodity_db）关联
 */

public class CommodityTypeDomain {
    private String commodityid;//商品类型编号
    private String typeName;//商品类型名称
    private CommodityDomain commodityDomain;

    public String getCommodityid() {
        return commodityid;
    }

    public CommodityDomain getCommodityDomain() {
        return commodityDomain;
    }

    public void setCommodityDomain(com.znsd.sportsbean.commodity.CommodityDomain commodityDomain) {
        this.commodityDomain = commodityDomain;
    }

    public void setCommodityid(String commodityid) {
        this.commodityid = commodityid;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "CommodityTypeDomain{" +
                "commodityid='" + commodityid + '\'' +
                ", typeName='" + typeName + '\'' +
                ", commodityDomain=" + commodityDomain +
                '}';
    }
}
