package com.hexun.personalcms.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hexun.framework.core.mybatis.BaseMybatisDao;
import com.hexun.framework.core.page.Page;
import com.hexun.personalcms.entity.TsUser;
import com.hexun.personalcms.mapper.TsUserMapper;
import com.hexun.personalcms.service.TsUserService;

@Service
public class TsUserServiceImpl extends BaseMybatisDao implements TsUserService{
	@Resource
	private TsUserMapper tsUserMapper;

	@Override
	public int deleteByPrimaryKey(String id) {
		return tsUserMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(TsUser record) {
		return tsUserMapper.insert(record);
	}

	@Override
	public int insertSelective(TsUser record) {
		return tsUserMapper.insertSelective(record);
	}

	@Override
	public TsUser selectByPrimaryKey(String id) {
		return tsUserMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(TsUser record) {
		return tsUserMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TsUser record) {
		return tsUserMapper.updateByPrimaryKey(record);
	}
	
	/**
	 * 登录
	 */
	@Override
	public TsUser login(String userCode, String password) {
		return tsUserMapper.login(userCode,password);
	}
	/**
	 * 分页查询
	 */
	@Override
	public Page<TsUser> findUserByPage(String sqlId,
			Map<String, Object> paramMap, int pageNo, int pageSize) {
		return (Page<TsUser>) findByPageBySqlId(sqlId, paramMap, pageNo, pageSize);
	}

}
