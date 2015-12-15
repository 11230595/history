package com.hexun.baseproject.service;

import java.util.List;

import com.hexun.baseproject.entity.Test;

public interface TestService {
	int deleteByPrimaryKey(String id);

    int insert(Test record);

    int insertSelective(Test record);

    Test selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKey(Test record);

	Test findByCode(String code);

	List<Test> findByNameOrCode(String name, String code);
}
