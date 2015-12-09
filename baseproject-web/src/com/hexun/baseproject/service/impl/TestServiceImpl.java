package com.hexun.baseproject.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hexun.baseproject.entity.Test;
import com.hexun.baseproject.mapper.TestMapper;
import com.hexun.baseproject.service.TestService;

@Service
public class TestServiceImpl implements TestService{
	@Resource
	private TestMapper testMapper;

	@Override
	public int deleteByPrimaryKey(String id) {
		return testMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Test record) {
		return testMapper.insert(record);
	}

	@Override
	public int insertSelective(Test record) {
		return testMapper.insertSelective(record);
	}

	@Override
	public Test selectByPrimaryKey(String id) {
		return testMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Test record) {
		return testMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Test record) {
		return testMapper.updateByPrimaryKey(record);
	}
	
}
