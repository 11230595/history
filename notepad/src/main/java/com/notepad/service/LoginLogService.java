package com.notepad.service;

import com.notepad.entity.LoginLog;

/**
 * 登录日志
 * @author zhoudong-ds
 *
 */
public interface LoginLogService {
    int deleteByPrimaryKey(String id);

    int insert(LoginLog record);

    int insertSelective(LoginLog record);

    LoginLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(LoginLog record);

    int updateByPrimaryKey(LoginLog record);
}
