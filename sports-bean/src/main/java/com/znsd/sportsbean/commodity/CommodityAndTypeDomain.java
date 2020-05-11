package com.znsd.sportsbean.commodity;

import java.io.Serializable;

public class CommodityAndTypeDomain implements Serializable {
    private String id;//商品编号
    private String name;//商品名称
    private String bewrite;//描述
    private Double price;//单价
    private Integer inventory;//积分
    private Integer sales;//总销量
    private String image;//图片地址
    private Integer sum;//库存
    private String typeId;//商品类型编号
    private String commodityid;//商品类型编号
    private String typeName;//商品类型名称


    @Override
    public String toString() {
        return "CommodityAndTypeDomain{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", bewrite='" + bewrite + '\'' +
                ", price=" + price +
                ", inventory=" + inventory +
                ", sales=" + sales +
                ", image='" + image + '\'' +
                ", sum=" + sum +
                ", typeId='" + typeId + '\'' +
                ", commodityid='" + commodityid + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBewrite() {
        return bewrite;
    }

    public void setBewrite(String bewrite) {
        this.bewrite = bewrite;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getCommodityid() {
        return commodityid;
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

    public int hashCode() {
        return id.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        CommodityAndTypeDomain other = (CommodityAndTypeDomain) obj;
        return other.id.equals(this.id);
    }

}
