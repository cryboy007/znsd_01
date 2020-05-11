package com.znsd.sportsbean.user;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表（user_db），与用户类型表关联（usertype_db）
 */
public class UserDomain implements Serializable {
    private String id;//用户编号
    private String wsid;//伪id
    private String name;//姓名
    private String username;//账号，是手机号哈
    private String password;//密码
    private String email;//邮箱
    private int age;//年龄
    private String gender;//性别
    private String typeid;//用户类型编号
    private String image;//头像地址
    private Double money;//用户余额
    private Integer integral;//用户积分
    private Integer status;//用户状态（0未审核，1已审核，2已禁用）
    private Date birthday; //出生日期

    public String getWsid() {
        return wsid;
    }

    public void setWsid(String wsid) {
        this.wsid = wsid;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "UserDomain{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", typeid='" + typeid + '\'' +
                ", image='" + image + '\'' +
                ", money=" + money +
                ", integral=" + integral +
                ", status=" + status +
                ", birthday=" + birthday +
                '}';
    }
}
