package com.hexun.baseproject.service.impl;

import java.util.List;

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

	@Override
	public Test findByCode(String code) {
		return testMapper.findByCode(code);
	}

	@Override
	public List<Test> findByNameOrCode(String name, String code) {
		return testMapper.findByNameOrCode(name,code);
	}

	
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		try {
			//代码块
			System.out.println("执行完毕，没有发生异常");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("出异常了！");
		}
	}
}
