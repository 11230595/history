package com.hexun.personalcms.entity;

import java.util.Date;

public class TsReadCount {
    private String id;

    private String contentId;

    private String userId;

    private Integer tsCount;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId == null ? null : contentId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getTsCount() {
        return tsCount;
    }

    public void setTsCount(Integer tsCount) {
        this.tsCount = tsCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}