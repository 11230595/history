package com.notepad.entity;

import java.util.Date;

public class FavoriteUrl {
    private String id;

    private String url;

    private String name;

    private String favoriteId;

    private String urlCode;

    private String urlPassword;

    private String favoriteDesc;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(String favoriteId) {
        this.favoriteId = favoriteId == null ? null : favoriteId.trim();
    }

    public String getUrlCode() {
        return urlCode;
    }

    public void setUrlCode(String urlCode) {
        this.urlCode = urlCode == null ? null : urlCode.trim();
    }

    public String getUrlPassword() {
        return urlPassword;
    }

    public void setUrlPassword(String urlPassword) {
        this.urlPassword = urlPassword == null ? null : urlPassword.trim();
    }

    public String getFavoriteDesc() {
        return favoriteDesc;
    }

    public void setFavoriteDesc(String favoriteDesc) {
        this.favoriteDesc = favoriteDesc == null ? null : favoriteDesc.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}