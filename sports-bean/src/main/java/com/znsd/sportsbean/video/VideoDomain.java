package com.znsd.sportsbean.video;

import java.util.Date;

/**
 * 视频表（video_db），和视频合集表关联
 */
public class VideoDomain {
    private String id;//视频编号

    private String name;//视频名称

    private String video;//视频地址

    private String dec;//视频集合描述
    private String typeId;//视频集合类型编号
    private String image;//视频集合封面
    private Double price;//视频集合单价
    private Date times;//上传时间
    private Integer integral;//视频积分
    private String userId;//上传用户编号
    private Integer status;//视频状态（0未审核，1已审核，2已禁用）
    private Integer totalLike; //点赞数
    private Double totalSocre;// 评分  （小于10）
    private Integer totalCollect; //收藏数
    private Integer totalBrowse;//浏览用户数据

    public Integer getTotalLike() {
        return totalLike;
    }

    public void setTotalLike(Integer totalLike) {
        this.totalLike = totalLike;
    }

    public Double getTotalSocre() {
        return totalSocre;
    }

    public void setTotalSocre(Double totalSocre) {
        this.totalSocre = totalSocre;
    }

    public Integer getTotalCollect() {
        return totalCollect;
    }

    public void setTotalCollect(Integer totalCollect) {
        this.totalCollect = totalCollect;
    }

    public Integer getTotalBrowse() {
        return totalBrowse;
    }

    public void setTotalBrowse(Integer totalBrowse) {
        this.totalBrowse = totalBrowse;
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

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }


    public String getDec() {
        return dec;
    }

    public void setDec(String dec) {
        this.dec = dec;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getTimes() {
        return times;
    }

    public void setTimes(Date times) {
        this.times = times;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "VideoDomain{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", video='" + video + '\'' +
                ", dec='" + dec + '\'' +
                ", typeId='" + typeId + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", times=" + times +
                ", integral=" + integral +
                ", userId='" + userId + '\'' +
                ", status=" + status +
                '}';
    }
}
