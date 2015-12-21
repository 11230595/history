package com.hexun.baseproject.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hexun.baseproject.entity.User;
import com.hexun.baseproject.mapper.UserMapper;
import com.hexun.baseproject.service.UserService;
import com.hexun.framework.core.mybatis.BaseMybatisDao;
import com.hexun.framework.core.page.Page;
/**
 * 用户
 * @author zhoudong
 *
 */
@Service
public class UserServiceImpl extends BaseMybatisDao implements UserService{
	@Resource
	private UserMapper userMapper;
	

	public int deleteByPrimaryKey(String userId) {
		return userMapper.deleteByPrimaryKey(userId);
	}

	public int insert(User record) {
		return userMapper.insert(record);
	}

	public int insertSelective(User record) {
		return userMapper.insertSelective(record);
	}

	public User selectByPrimaryKey(String userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	public int updateByPrimaryKeySelective(User record) {
		return userMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(User record) {
		return userMapper.updateByPrimaryKey(record);
	}
	
	/**
	 * 根据userCode查询User
	 */
	public User findUserByUserCode(String userCode) {
		return userMapper.findUserByUserCode(userCode);
	}
	/**
	 * 根据email查询user
	 */
	public User findUserByEmail(String email) {
		return userMapper.findUserByEmail(email);
	}
	/**
	 * 根据ID查询用户
	 */
	public User findUserByUserId(String userId) {
		return userMapper.selectByPrimaryKey(userId);
	}
	/**
	 * 登陆
	 */
	public User login(String userCode, String password) {
		return userMapper.login(userCode,password);
	}
	/**
	 * 分页
	 */
	public Page<User> findUserByPage(String sqlId, Map<String, Object> param,
			int pageNo, int PageSize) {
		return (Page<User>) findByPageBySqlId(sqlId,param,pageNo,PageSize);
	}
	
}
