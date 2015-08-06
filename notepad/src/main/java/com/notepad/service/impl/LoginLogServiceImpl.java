package com.notepad.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.notepad.entity.LoginLog;
import com.notepad.mapper.LoginLogMapper;
import com.notepad.service.LoginLogService;

/**
 * 登录日志
 * @author zhoudong
 *
 */
@Service
public class LoginLogServiceImpl implements LoginLogService {
	@Resource
	private LoginLogMapper loginLogMapper;
	
	/**
	 * 删除
	 */
	public int deleteByPrimaryKey(String id) {
		return loginLogMapper.deleteByPrimaryKey(id);
	}
	/**
	 * 保存
	 */
	public int insert(LoginLog record) {
		return loginLogMapper.insert(record);
	}
	/**
	 * 保存
	 */
	public int insertSelective(LoginLog record) {
		return loginLogMapper.insertSelective(record);
	}
	/**
	 * 根据ID查询
	 */
	public LoginLog selectByPrimaryKey(String id) {
		return loginLogMapper.selectByPrimaryKey(id);
	}
	/**
	 * 更新
	 */
	public int updateByPrimaryKeySelective(LoginLog record) {
		return loginLogMapper.updateByPrimaryKeySelective(record);
	}
	/**
	 * 更新
	 */
	public int updateByPrimaryKey(LoginLog record) {
		return loginLogMapper.updateByPrimaryKey(record);
	}

}
