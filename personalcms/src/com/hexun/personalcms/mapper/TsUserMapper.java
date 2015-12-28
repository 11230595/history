package com.hexun.personalcms.mapper;

import org.apache.ibatis.annotations.Param;

import com.hexun.personalcms.entity.TsUser;

public interface TsUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(TsUser record);

    int insertSelective(TsUser record);

    TsUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TsUser record);

    int updateByPrimaryKey(TsUser record);

	TsUser login(@Param("userCode") String userCode, @Param("password") String password);
}