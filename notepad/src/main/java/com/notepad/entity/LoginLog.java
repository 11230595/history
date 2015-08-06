package com.notepad.entity;

import java.util.Date;
import java.util.UUID;

public class LoginLog {
    private String id;

    private String appName;

    private Integer loginType;

    private String loginName;

    private Date createTime;

    private String errorInfo;

    private String ipAddr;

    private String addr;

    
    public static final String APP_NAME = "收藏夹";
    
    public LoginLog(String appName, Integer loginType,
			String loginName, String errorInfo, String ipAddr,
			String addr) {
		super();
		this.id = UUID.randomUUID().toString();
		this.appName = appName;
		this.loginType = loginType;
		this.loginName = loginName;
		this.errorInfo = errorInfo;
		this.ipAddr = ipAddr;
		this.addr = addr;
	}

	public LoginLog() {
		super();
	}
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public Integer getLoginType() {
        return loginType;
    }

    public void setLoginType(Integer loginType) {
        this.loginType = loginType;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo == null ? null : errorInfo.trim();
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr == null ? null : ipAddr.trim();
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }
}