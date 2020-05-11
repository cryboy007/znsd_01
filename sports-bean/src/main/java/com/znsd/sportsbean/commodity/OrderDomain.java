package com.znsd.sportsbean.commodity;

import com.znsd.sportsbean.user.UserDomain;

import java.util.Date;

/**
 * 订单表（order_db）
 */
public class OrderDomain {
    private String id;//订单编号
    private String userId;//用户编号
    private String commodityId;//商品编号
    private Integer status;//订单状态（0,已完成；1 未完成）
    private Date times;//下单时间
    private String address;//收货地址
    private Double sum;//总金额
    private Integer number;//商品数量
    private UserDomain userDomain;
    private CommodityDomain commodityDomain;
    private CommodityTypeDomain commodityTypeDomain;

    public UserDomain getUserDomain() {
        return userDomain;
    }

    public void setUserDomain(UserDomain userDomain) {
        this.userDomain = userDomain;
    }

    public CommodityDomain getCommodityDomain() {
        return commodityDomain;
    }

    public void setCommodityDomain(CommodityDomain commodityDomain) {
        this.commodityDomain = commodityDomain;
    }

    public CommodityTypeDomain getCommodityTypeDomain() {
        return commodityTypeDomain;
    }

    public void setCommodityTypeDomain(CommodityTypeDomain commodityTypeDomain) {
        this.commodityTypeDomain = commodityTypeDomain;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getTimes() {
        return times;
    }

    public void setTimes(Date times) {
        this.times = times;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "OrderDomain{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", commodityId='" + commodityId + '\'' +
                ", status=" + status +
                ", times=" + times +
                ", address='" + address + '\'' +
                ", sum=" + sum +
                ", number=" + number +
                ", userDomain=" + userDomain +
                ", commodityDomain=" + commodityDomain +
                ", commodityTypeDomain=" + commodityTypeDomain +
                '}';
    }
}
