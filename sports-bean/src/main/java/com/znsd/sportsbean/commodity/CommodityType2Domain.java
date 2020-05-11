package com.znsd.sportsbean.commodity;

/**
 * 商品类型表（commodittype_db），与商品表（commodity_db）关联
 */

public class CommodityType2Domain {
    private String id;//商品类型编号
    private String typeName;//商品类型名称
    private CommodityDomain commodityDomain;

    public CommodityDomain getCommodityDomain() {
        return commodityDomain;
    }


    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CommodityType2Domain{" +
                "id='" + id + '\'' +
                ", typeName='" + typeName + '\'' +
                ", commodityDomain=" + commodityDomain +
                '}';
    }
}
