package com.hexun.jndi.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hexun.jndi.entity.Demo;
import com.hexun.jndi.mapper.DemoMapper;
import com.hexun.jndi.service.DemoService;
@Service
public class DemoServiceImpl implements DemoService{
	@Resource
	private DemoMapper demoMapper;

	@Override
	public int deleteByPrimaryKey(String id) {
		return demoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Demo record) {
		return demoMapper.insert(record);
	}

	@Override
	public int insertSelective(Demo record) {
		return demoMapper.insertSelective(record);
	}

	@Override
	public Demo selectByPrimaryKey(String id) {
		return demoMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Demo record) {
		return demoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Demo record) {
		return demoMapper.updateByPrimaryKey(record);
	}
}
