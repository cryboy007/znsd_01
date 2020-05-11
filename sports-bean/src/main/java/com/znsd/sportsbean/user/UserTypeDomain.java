package com.znsd.sportsbean.user;

/**
 * 用户类型表（UserType_db）,
 * 与用户表关联（user_db）
 * 无中间表
 */
public class UserTypeDomain {
    private String id;
    private String typeName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "UserTypeDomain{" +
                "id='" + id + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
