package com.hexun.baseproject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hexun.baseproject.entity.Test;

public interface TestMapper {
    int deleteByPrimaryKey(String id); //

    int insert(Test record);

    int insertSelective(Test record);

    Test selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKey(Test record);

	Test findByCode(String code);

	List<Test> findByNameOrCode(@Param("name") String name, @Param("code") String code);
}