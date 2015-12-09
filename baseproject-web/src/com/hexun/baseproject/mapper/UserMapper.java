package com.hexun.baseproject.mapper;

import org.apache.ibatis.annotations.Param;

import com.hexun.baseproject.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
   	/**
	 * 根据userCode查询User
	 */
	User findUserByUserCode(String userCode);
	/**
	 * 根据email查询user
	 */
	User findUserByEmail(String email);
	/**
     * 登录
     * @param userCode
     * @param password
     * @return
     */
	User login(@Param("userCode") String userCode, @Param("password") String password);
}