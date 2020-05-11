package com.znsd.sportsbean.user;

/**
 * 用户收货地址表（useraddress_db）,与用户表关联（user_db）
 */
public class UserAddressDomain {
    private Integer id;
    private String userid;//用户编号
    private String address;//收货地址

    public UserAddressDomain() {
    }

    public UserAddressDomain(Integer id, String userid, String address) {
        this.id = id;
        this.userid = userid;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserAddressDomain{" +
                "id=" + id +
                ", userid='" + userid + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
