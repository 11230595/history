package com.hexun.personalcms.mapper;

import com.hexun.personalcms.entity.TsReadCount;

public interface TsReadCountMapper {
    int deleteByPrimaryKey(String id);

    int insert(TsReadCount record);

    int insertSelective(TsReadCount record);

    TsReadCount selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TsReadCount record);

    int updateByPrimaryKey(TsReadCount record);
}