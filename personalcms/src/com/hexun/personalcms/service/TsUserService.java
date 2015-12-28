package com.hexun.personalcms.service;

import com.hexun.personalcms.entity.TsUser;

public interface TsUserService {
	int deleteByPrimaryKey(String id);

    int insert(TsUser record);

    int insertSelective(TsUser record);

    TsUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TsUser record);

    int updateByPrimaryKey(TsUser record);

	TsUser login(String userCode, String password);
}
