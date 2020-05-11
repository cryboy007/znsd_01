package com.znsd.sportsbean.video;

/**
 * 视频集合类型表（videotype_db），
 * 与视频集合表(video_collection)关联
 */
public class VideoTypeDomain {
    private Integer id;//视频集合类型
    private String typeName;//视频集合类型名称

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
