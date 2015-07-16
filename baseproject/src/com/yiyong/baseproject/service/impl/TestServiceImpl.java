package com.yiyong.baseproject.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yiyong.baseproject.dao.TestDao;
import com.yiyong.baseproject.entity.Test;
import com.yiyong.baseproject.service.TestService;
import com.yiyong.framework.core.orm.Page;
@Service
public class TestServiceImpl implements TestService {

	@Resource
	private TestDao testDao;
	
	@Override
	public void save(Test test) {
		testDao.save(test);
	}

	@Override
	public Test findByCode(String code) {
		return testDao.findByCode(code);
	}

	@Override
	public List<Test> findAll() {
		return testDao.findAll();
	}
	/**
	 * 分页查询
	 */
	@Override
	public void findByPage(Page<Test> page) {
		testDao.findByPage(page);
	}

}
