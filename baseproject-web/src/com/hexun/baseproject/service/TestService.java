package com.hexun.baseproject.service;

import com.hexun.baseproject.entity.Test;

public interface TestService {
	int deleteByPrimaryKey(String id);

    int insert(Test record);

    int insertSelective(Test record);

    Test selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKey(Test record);
}
